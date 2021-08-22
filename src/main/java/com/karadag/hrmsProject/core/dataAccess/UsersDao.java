package com.karadag.hrmsProject.core.dataAccess;

import com.karadag.hrmsProject.core.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Integer> {

}
