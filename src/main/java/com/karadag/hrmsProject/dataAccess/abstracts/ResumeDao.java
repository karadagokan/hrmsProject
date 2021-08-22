package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

    Resume getAllByEmplooyeId(int employeeId);

}
