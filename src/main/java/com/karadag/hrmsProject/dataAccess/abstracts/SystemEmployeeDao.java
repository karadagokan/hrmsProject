package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.SystemEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
}
