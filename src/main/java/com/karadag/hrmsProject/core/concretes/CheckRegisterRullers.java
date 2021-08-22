package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.core.entities.Users;
import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import lombok.Data;

import java.util.List;

@Data
public class CheckRegisterRullers {

    private List<Users> usersList;
    private List<JobSeeker> jobSeekerList;


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
