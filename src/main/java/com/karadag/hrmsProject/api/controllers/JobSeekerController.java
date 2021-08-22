package com.karadag.hrmsProject.api.controllers;


import com.karadag.hrmsProject.business.abstracts.JobSeekerService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.ErrorDataResult;
import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {


    JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @PostMapping(value = "/addNew")
    public ResponseEntity<?> addJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) { //RequestBody olmadan istek 500 Error hatası verir postman den şablonu yollayamayız.
        return ResponseEntity.ok(this.jobSeekerService.addJobSeeker(jobSeeker));

    }


    //To Do : Sisteme Global olarak eklenecek.
    //Sistemde bir hata çıktığında buraya yönlendir diyoruz. 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Default olarak bu hata 500 dönsün dedik.
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
    }


}