package com.karadag.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.hrmsProject.entities.concretes.JobPosition;

public interface JobPositionsDao extends JpaRepository<JobPosition, Integer> {
}
