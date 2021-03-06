package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.JobSeekerService;
import com.karadag.hrmsProject.business.abstracts.UsersService;
import com.karadag.hrmsProject.core.concretes.CheckRegisterRullers;
import com.karadag.hrmsProject.core.concretes.JobSeekerCheckManager;
import com.karadag.hrmsProject.core.concretes.MernisServiceAdapter;
import com.karadag.hrmsProject.core.entities.EmailValidation;
import com.karadag.hrmsProject.core.utilities.*;
import com.karadag.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    UsersService usersService;

    JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UsersService usersService) {
        this.jobSeekerDao = jobSeekerDao;
        this.usersService = usersService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {

        // Mail adresini denetliyoruz önceden kayıt olmuş mu ?.
        CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
        checkRegisterRullers.setUsersList(usersService.getAll());
        checkRegisterRullers.setJobSeekerList(jobSeekerDao.findAll());

        boolean isContainsMail = checkRegisterRullers.checkUserMail(jobSeeker.getEmail());
        boolean isContainNationalityId = checkRegisterRullers.checkEmployeeNationalityId(jobSeeker.getNationalityId());

        JobSeekerCheckManager jobSeekerCheckManager = new JobSeekerCheckManager(new MernisServiceAdapter());

        boolean checkUser = jobSeekerCheckManager.ifRealPerson(jobSeeker.getNationalityId(), jobSeeker.getFirstName(), jobSeeker.getLastName(),
                jobSeeker.getYearOfBirth());

        if (isContainsMail || isContainNationalityId || !checkUser) {
            System.out.println("Bu kullanıcı kayıtlı lütfen bilgilerinizi kontrol edin.");
            return new ErrorResult("Kayıt başarısız bilgilerinizi kontrol edin.");
        }

        jobSeeker.setEmailValidation(new EmailValidation());
        jobSeekerDao.save(jobSeeker);

        return new SuccessResult("Başarıyla kayıt oldunuz.");

    }

}
