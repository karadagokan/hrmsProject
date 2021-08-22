package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
