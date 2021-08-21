package com.karadag.hrmsProject.business.abstracts;

import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.Resume;
import com.karadag.hrmsProject.entities.concretes.ResumeSchool;

import java.util.List;

public interface ResumeServices {
	
	Result addResume(Resume resume);

	DataResult<Resume> getAllByEmplooyeId(int employeeId);

	DataResult<Resume> getAllByEmplooyeIdSortedWithGraduateDate(String ascOrDesc);

	DataResult<Resume> getAllByEmplooyeIdSortedWithExperienceFinishDate(String ascOrDesc);


}
