package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

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
