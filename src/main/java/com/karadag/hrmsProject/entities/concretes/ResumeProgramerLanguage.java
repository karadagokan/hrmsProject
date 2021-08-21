package com.karadag.hrmsProject.entities.concretes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ResumeProgramerLanguage {

	private String languageName;
}
