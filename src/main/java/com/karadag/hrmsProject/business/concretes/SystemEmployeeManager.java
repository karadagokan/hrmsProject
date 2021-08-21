package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.SystemEmployeeService;
import com.karadag.hrmsProject.core.concretes.CheckRegisterRullers;
import com.karadag.hrmsProject.core.utilities.*;
import com.karadag.hrmsProject.dataAccess.abstracts.SystemEmployeeDao;
import com.karadag.hrmsProject.dataAccess.abstracts.UsersDao;
import com.karadag.hrmsProject.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {


    @Autowired
    UsersDao usersDao;

    SystemEmployeeDao systemEmployeeDao;

    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
        this.systemEmployeeDao = systemEmployeeDao;
    }

    @Override
    public DataResult<List<SystemEmployee>> getAll() {
        return new SuccessDataResult<>(systemEmployeeDao.findAll(), "Sistem elemanları listelendi");
    }

    @Override
    public Result addSystemEmployee(SystemEmployee employee) {
        CheckRegisterRullers checkRegisterRullers = new CheckRegisterRullers();
        checkRegisterRullers.setUsersList(usersDao.findAll());

        boolean isContainMail = checkRegisterRullers.checkUserMail(employee.getEmail());

        if (isContainMail) {
            System.out.println("Bu kullanıcı kayıtlı lütfen bilgilerinizi kontrol edin.");
            return new ErrorResult("Kayıt başarısız bilgilerinizi kontrol edin.");
        }


        systemEmployeeDao.save(employee);

        return new SuccessResult("Başarıyla kayıt oldunuz.");
    }
}
