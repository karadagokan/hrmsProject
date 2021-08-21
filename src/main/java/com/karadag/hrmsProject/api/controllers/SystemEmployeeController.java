package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.SystemEmployeeService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemEmployee")
public class SystemEmployeeController {

    SystemEmployeeService systemEmployeeService;

    @Autowired
    public SystemEmployeeController(SystemEmployeeService systemEmployeeService) {
        this.systemEmployeeService = systemEmployeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SystemEmployee>> getAll() {
        return systemEmployeeService.getAll();
    }


    @PostMapping(value = "/addNew")
    public Result addSystemEmployee(@RequestBody SystemEmployee employee) {
        return systemEmployeeService.addSystemEmployee(employee);

    }
}
