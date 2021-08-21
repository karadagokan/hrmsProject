package com.karadag.hrmsProject.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karadag.hrmsProject.entities.concretes.AdvertisementDetail;
import com.karadag.hrmsProject.entities.concretes.Advertisement;

import java.util.List;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer> {


    //Veritabanında bu bilgileri barındıran bir tablo oluşturmak yerine Class oluşturduk. Verileri buraya çektik class dan işlemler yapacağız.->
    //Böylelikle fazla tablo oluşturmamış olduk.
    @Query(value = "SELECT new com.karadag.hrmsProject.entities.concretes.AdvertisementDetail(e.companyName,p.positionName,a.numberOfOpenPosition,a.realeseDate,a.applicationDeadline) FROM Advertisement as a LEFT JOIN a.employer as e left join a.jobPosition as p where a.jobStatus=true ")
    List<AdvertisementDetail> getAllJobAdvertisement();

    //@Query("SELECT new com.karadag.hrmsProject.entities.concretes.AdvertisementDetail(e.companyName,p.positionName,a.numberOfOpenPosition,a.realeseDate,a.applicationDeadline) FROM JobAdvertisement a,Employer e,JobPosition p where a.jobStatus=true and e.companyName=:companyName and e.userId=a.employerId and p.jobPositionId=a.jobPositionId ")
    @Query("SELECT new com.karadag.hrmsProject.entities.concretes.AdvertisementDetail(e.companyName,p.positionName,a.numberOfOpenPosition,a.realeseDate,a.applicationDeadline) FROM Advertisement as a LEFT JOIN a.employer as e left join a.jobPosition as p where a.jobStatus=true and e.companyName=:companyName")
    List<AdvertisementDetail> getAllJobAdvertisementWithCompany(@Param("companyName") String companyName);

}
