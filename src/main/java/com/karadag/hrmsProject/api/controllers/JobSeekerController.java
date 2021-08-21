package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.JobSeekerService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {

    @Autowired
    JobSeekerService jobSeekerService;

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    //@RequestMapping(value = "/addNew", method = {RequestMethod.POST, RequestMethod.GET})
    @PostMapping(value = "/addNew")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) { //RequestBody olmadan istek 500 Error hatası verir postman den şablonu yollayamayız.
        return this.jobSeekerService.addJobSeeker(jobSeeker);

    }
}