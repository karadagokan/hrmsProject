package com.karadag.hrmsProject.core.abstracts;

import com.karadag.hrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {

    boolean ifRealPerson(String nationalityId,String firstName,String lastName,String yearOfBirth);
}
