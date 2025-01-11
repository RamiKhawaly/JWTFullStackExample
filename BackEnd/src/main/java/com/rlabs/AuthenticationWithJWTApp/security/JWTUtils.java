package com.rlabs.AuthenticationWithJWTApp.security;

import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class JWTUtils {

    @Value("${application.security.jwt.secret-key}")
    private String jwtSecret;

    @Value("${application.security.jwt.expiration}")
    private int expirationMinutes;

    private Key secretKey;

    @PostConstruct
    public void init()
    {
        this.secretKey = new SecretKeySpec(jwtSecret.getBytes(), SignatureAlgorithm.HS512.getJcaName());
    }

    public String generateJWTKey(String username)
    {
        Date expirationTime = new Date(Calendar.getInstance().getTimeInMillis()+expirationMinutes*1000*60);
        return Jwts.builder()
                .setIssuer("R-Labs")
                .setExpiration(expirationTime)
                .setIssuedAt(new Date(Calendar.getInstance().getTimeInMillis()))
                .setSubject(username)
                .signWith(this.secretKey)
                .compact();
    }


    public Claims verifyToken(String token) throws ExpiredJwtException, UnsupportedJwtException,MalformedJwtException
    {
        Claims claims = Jwts.parserBuilder().setSigningKey(this.secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        if (claims == null) {
            return null;
        }
        return claims;
    }
}
