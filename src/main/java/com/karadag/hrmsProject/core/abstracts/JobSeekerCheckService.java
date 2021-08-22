package com.karadag.hrmsProject.core.abstracts;

public interface JobSeekerCheckService {

    boolean ifRealPerson(String nationalityId, String firstName, String lastName, String yearOfBirth);
}
