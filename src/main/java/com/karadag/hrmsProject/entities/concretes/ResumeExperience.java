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
public class ResumeExperience {

    private String jobCompany;

    private String jobPosition;

    private Date startDate;

    private Date finishDate;

    private boolean doesItContinue;
}
