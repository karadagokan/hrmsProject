package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import com.karadag.hrmsProject.entities.concretes.Users;

import java.util.List;

public class CheckRegisterRullers {

    private List<Users> usersList;
    private List<JobSeeker> jobSeekerList;

    public CheckRegisterRullers() {

    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public List<JobSeeker> getEmployeeList() {
        return jobSeekerList;
    }

    public void setEmployeeList(List<JobSeeker> jobSeekerList) {
        this.jobSeekerList = jobSeekerList;
    }

    public boolean checkUserMail(String email) {
        for (Users user : this.usersList) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmployeeNationalityId(String nationalityId) {
        for (JobSeeker jobSeeker : this.jobSeekerList) {
            if (jobSeeker.getNationalityId().equalsIgnoreCase(nationalityId)) {
                return true;
            }
        }
        return false;
    }

}
