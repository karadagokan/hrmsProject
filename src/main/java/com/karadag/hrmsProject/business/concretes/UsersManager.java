package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.UsersService;
import com.karadag.hrmsProject.dataAccess.abstracts.UsersDao;
import com.karadag.hrmsProject.entities.concretes.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersManager implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Override
    public List<Users> getAll() {
        return usersDao.findAll();
    }
}
