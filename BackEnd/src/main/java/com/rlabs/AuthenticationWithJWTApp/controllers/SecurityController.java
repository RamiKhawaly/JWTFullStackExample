package com.rlabs.AuthenticationWithJWTApp.controllers;

import com.rlabs.AuthenticationWithJWTApp.bl.SecurityBL;
import com.rlabs.AuthenticationWithJWTApp.components.LoginData;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
@CrossOrigin
public class SecurityController {

    @Autowired
    private SecurityBL securityBL;

    @GetMapping("login")
    public ResponseEntity<LoginData> login(String username, String password)
    {
        LoginData loginData = securityBL.login(username,password);
        if(loginData!=null)
        {
            return ResponseEntity.ok(loginData);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }


}
