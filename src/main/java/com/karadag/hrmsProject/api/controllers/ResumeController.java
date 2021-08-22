package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.ResumeServices;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/resume")
public class ResumeController {


    ResumeServices resumeServices;

    @Autowired
    public ResumeController(ResumeServices resumeServices) {
        this.resumeServices = resumeServices;
    }


    @PostMapping(value = "/addNew")
    public Result addResume(@RequestBody Resume resume) {
        return resumeServices.addResume(resume);
    }

    @GetMapping(value = "/getAllByEmplooyeId")
    public DataResult<Resume> getAllByEmplooyeId(@RequestParam int employeeId) {
        return resumeServices.getAllByEmplooyeId(employeeId);
    }

    @GetMapping(value = "/getAllByEmplooyeIdSortedWithGraduateDate")
    public DataResult<Resume> getAllByEmplooyeIdSortedWithGraduateDate(@RequestParam String ascOrDesc) {
        return resumeServices.getAllByEmplooyeIdSortedWithGraduateDate(ascOrDesc);
    }

    @GetMapping(value = "/getAllByEmplooyeIdSortedWithExperienceFinishDate")
    public DataResult<Resume> getAllByEmplooyeIdSortedWithExperienceFinishDate(@RequestParam String ascOrDesc) {
        return resumeServices.getAllByEmplooyeIdSortedWithExperienceFinishDate(ascOrDesc);
    }


}
