package com.karadag.hrmsProject.entities.concretes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ResumeLanguage {

    private String languageName;

    private int languageLevel;
}
