package com.rlabs.AuthenticationWithJWTApp.security;

import com.rlabs.AuthenticationWithJWTApp.exceptions.NoTokenProvidedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Value("${application.security.openURLS}")
    private List<String> openUrls;

    private final AntPathMatcher matcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("Request received: " + path);

        // Check if the URL is in the list of open (unprotected) URLs
        boolean isOpenUrl = openUrls.stream().anyMatch(pattern -> matcher.match(pattern, path));

        if (!isOpenUrl) {
            // Validate JWT
            try {
                isValidRequest(request); // in case the token is expired or invalid it will throw an exception
            } catch (ExpiredJwtException | NoTokenProvidedException e) {
                // The provided token has expired
                changeResponse(response, HttpServletResponse.SC_UNAUTHORIZED); // 401
                return;
            } catch (UnsupportedJwtException | MalformedJwtException e) {
                // The token is of an unsupported type or format
                changeResponse(response, HttpServletResponse.SC_BAD_REQUEST); // 400
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private void changeResponse(HttpServletResponse response, int status) throws IOException {
        response.setStatus(status);
        response.getWriter().write("Unauthorized or invalid token");
        response.getWriter().flush();
    }

    private void isValidRequest(HttpServletRequest request) throws NoTokenProvidedException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String path = request.getServletPath();

        if (token == null) {
            System.out.println("Request " + path + " didn't include a token");
            throw new NoTokenProvidedException();
        }

        // Strip out 'Bearer' prefix
        token = token.replaceFirst("^Bearer\\s*", "");
        if ("".equals(token)) {
            System.out.println("Request " + path + " has invalid token");
            throw new UnsupportedJwtException(token +" is not well formatted");
        }
        this.jwtUtils.verifyToken(token);
    }
}
