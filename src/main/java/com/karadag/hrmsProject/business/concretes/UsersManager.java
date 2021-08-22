package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.UsersService;
import com.karadag.hrmsProject.core.dataAccess.UsersDao;
import com.karadag.hrmsProject.core.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersManager implements UsersService {

    UsersDao usersDao;

    @Autowired
    public UsersManager(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<Users> getAll() {
        return usersDao.findAll();
    }
}
