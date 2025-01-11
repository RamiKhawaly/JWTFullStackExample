package com.rlabs.AuthenticationWithJWTApp.controllers;

import com.rlabs.AuthenticationWithJWTApp.bl.DataBL;
import com.rlabs.AuthenticationWithJWTApp.entities.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private DataBL dataBL;

    @GetMapping("getAll")
    public List<Data> getAllData()
    {
        return this.dataBL.getAll();
    }
}
