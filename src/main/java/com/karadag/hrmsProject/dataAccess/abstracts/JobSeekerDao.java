package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
