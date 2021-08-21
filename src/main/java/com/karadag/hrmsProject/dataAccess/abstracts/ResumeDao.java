package com.karadag.hrmsProject.dataAccess.abstracts;

import com.karadag.hrmsProject.entities.concretes.ResumeSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import com.karadag.hrmsProject.entities.concretes.Resume;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

    Resume getAllByEmplooyeId(int employeeId);

//    @Query(value = "FROM Resume order by resumeSchools.graduateDate ")
//    Resume getAllByEmplooyeIdWithGraduateDate(int emplooyeId,String ascOrDesc);

}
