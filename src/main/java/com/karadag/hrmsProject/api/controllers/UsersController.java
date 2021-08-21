package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.UsersService;
import com.karadag.hrmsProject.entities.concretes.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/getAll")
    public List<Users> getAll() {
        return this.usersService.getAll();
    }
}
