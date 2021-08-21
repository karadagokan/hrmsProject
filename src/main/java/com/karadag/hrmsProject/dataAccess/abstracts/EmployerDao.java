package com.karadag.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.hrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
