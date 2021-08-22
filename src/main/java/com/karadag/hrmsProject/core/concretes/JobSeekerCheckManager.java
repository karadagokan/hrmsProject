package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.core.abstracts.JobSeekerCheckService;

public class JobSeekerCheckManager implements JobSeekerCheckService {

    JobSeekerCheckService jobSeekerCheckService;

    public JobSeekerCheckManager(JobSeekerCheckService jobSeekerCheckService) {
        this.jobSeekerCheckService = jobSeekerCheckService;
    }

    @Override
    public boolean ifRealPerson(String firstName, String lastName, String nationalityId, String yearOfBirth) {
        return jobSeekerCheckService.ifRealPerson(firstName, lastName, nationalityId, yearOfBirth);
    }
}
