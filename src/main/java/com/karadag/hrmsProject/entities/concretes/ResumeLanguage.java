package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ResumeLanguage {

    private String languageName;

    @Max(5)
    @Min(1)
    private int languageLevel;
}
