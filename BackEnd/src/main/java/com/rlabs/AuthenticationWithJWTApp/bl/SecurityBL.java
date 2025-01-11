package com.rlabs.AuthenticationWithJWTApp.bl;

import com.rlabs.AuthenticationWithJWTApp.components.LoginData;
import com.rlabs.AuthenticationWithJWTApp.entities.User;
import com.rlabs.AuthenticationWithJWTApp.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityBL {

    @Autowired
    private UsersBL usersBL;

    @Autowired
    private JWTUtils jwtUtils;

    public LoginData login(String username, String password)
    {
        User existingUser = this.usersBL.getUser(username);
        if(existingUser!=null)
        {
            if(existingUser.getPassword().equals(password))
            {
                String token = jwtUtils.generateJWTKey(existingUser.getUsername());
                return LoginData.builder().token(token).build();
            }
        }
        return null;
    }
}
