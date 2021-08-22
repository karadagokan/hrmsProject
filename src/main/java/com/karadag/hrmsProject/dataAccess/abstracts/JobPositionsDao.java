package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionsDao extends JpaRepository<JobPosition, Integer> {
}
