package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.EmployerService;
import com.karadag.hrmsProject.business.abstracts.UsersService;
import com.karadag.hrmsProject.core.concretes.CheckRegisterRullers;
import com.karadag.hrmsProject.core.utilities.*;
import com.karadag.hrmsProject.dataAccess.abstracts.EmployerDao;
import com.karadag.hrmsProject.entities.concretes.EmailValidation;
import com.karadag.hrmsProject.entities.concretes.Employer;
import com.karadag.hrmsProject.entities.concretes.HrmsValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;

	@Autowired
	UsersService usersService;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<>(employerDao.findAll(), "İş verenler listelendi");
	}

	@Override
	public Result addEmployer(Employer employer) {
		CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
		checkRegisterRullers.setUsersList(usersService.getAll());

		boolean isContainsMail = checkRegisterRullers.checkUserMail(employer.getEmail());

		if (isContainsMail) {
			System.out.println("Bu kullanıcı kayıtlı lütfen bilgilerinizi kontrol edin.");
			return new ErrorResult("Kayıt başarısız bilgilerinizi kontrol edin.");
		}

		EmailValidation emailValidation= new EmailValidation();
		employer.setEmailValidation(emailValidation);
		emailValidation.setUsers(employer);
		
		HrmsValidation hrmsValidation = new HrmsValidation();
		employer.setHrmsValidation(hrmsValidation);
		hrmsValidation.setEmployer(employer);
		
		employerDao.save(employer);

		return new SuccessResult("Başarıyla kayıt oldunuz.");
	}
}
