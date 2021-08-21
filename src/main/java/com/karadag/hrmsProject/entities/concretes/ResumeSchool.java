package com.karadag.hrmsProject.entities.concretes;

import java.util.Date;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ResumeSchool {

    private String schoolName;

    private String department;

    private boolean isGraduate;

    private Date graduateDate;

    private Date startDate;

    private Date finishDate;


}
