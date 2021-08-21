package com.karadag.hrmsProject.business.abstracts;

import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionsService {

    Result addJobPosition(JobPosition jobPosition);

    DataResult<List<JobPosition>> getAll();
}
