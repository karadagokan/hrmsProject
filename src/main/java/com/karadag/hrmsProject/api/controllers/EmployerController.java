package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.EmployerService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }

    @PostMapping(value = "/addNew")
    public Result addEmployer(@RequestBody  Employer employer){
        return employerService.addEmployer(employer);
    }
}
