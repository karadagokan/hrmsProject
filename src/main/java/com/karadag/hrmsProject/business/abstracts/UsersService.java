package com.karadag.hrmsProject.business.abstracts;

import com.karadag.hrmsProject.entities.concretes.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAll();
}
