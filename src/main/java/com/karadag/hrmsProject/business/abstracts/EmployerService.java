package com.karadag.hrmsProject.business.abstracts;

import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    Result addEmployer(Employer employer);
}
