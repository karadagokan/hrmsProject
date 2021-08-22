package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.JobPositionsService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {


    JobPositionsService jobPositionsService;

    @Autowired
    public JobPositionsController(JobPositionsService jobPositionsService) {
        this.jobPositionsService = jobPositionsService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll() {
        return jobPositionsService.getAll();
    }

    @PostMapping("/addNew")
    public Result addJobPosition(@RequestBody JobPosition jobPosition) {
        return jobPositionsService.addJobPosition(jobPosition);
    }

}
