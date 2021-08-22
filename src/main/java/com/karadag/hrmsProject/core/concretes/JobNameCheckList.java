package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

public class JobNameCheckList {

    public static boolean checkListIn(List<JobPosition> list, String checkValue) {
        for (JobPosition jobPosition : list) {
            if (jobPosition.getPositionName().equalsIgnoreCase(checkValue)) {
                System.out.println("Bu meslek sistemde kayıtlı.");
                return true;
            }
        }
        return false;
    }
}
