package com.prototype.scrumconnect.controllers;

import java.util.List;

import javax.validation.Valid;

import com.prototype.scrumconnect.models.UserDataModel;
import com.prototype.scrumconnect.repositories.UserDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/userData")
public class UserDataController {
    
    @Autowired
    UserDataRepository userDataRepository;

    @GetMapping
    public List<UserDataModel> getUserData(){
        return userDataRepository.findAll();
    }

    @PostMapping
    public UserDataModel postUserData(@Valid @RequestBody UserDataModel userData){
        return userDataRepository.save(userData);
    }
}
