package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.JobPositionsService;
import com.karadag.hrmsProject.core.concretes.CheckList;
import com.karadag.hrmsProject.core.utilities.*;
import com.karadag.hrmsProject.dataAccess.abstracts.JobPositionsDao;
import com.karadag.hrmsProject.entities.concretes.JobPosition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionsManager implements JobPositionsService {

	JobPositionsDao jobPositionsDao;

	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		boolean containsJob = CheckList.checkListIn(jobPositionsDao.findAll(), jobPosition.getPositionName());

		if (containsJob) {
			return new ErrorResult("Bu meslek sistemde var");
		}

		jobPositionsDao.save(jobPosition);
		return new SuccessResult("Meslek sisteme eklendi");

	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<>(jobPositionsDao.findAll(), "Meslekler listelendi");
	}
}
