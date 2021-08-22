package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JobAdvertisements")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advertisementId;

    @Column(nullable = false)
    private String jobDescription;

    @Column(nullable = false)
    private String jobCountry;

    @Column
    private int minSalary;

    @Column
    private int maxSalary;

    @Column(nullable = false)
    private int numberOfOpenPosition;

    @Temporal(TemporalType.DATE)
    private Date applicationDeadline;

    //Default olarak true geçsin
    @Column
    @Value("${some.key:true}")
    private boolean jobStatus;

    //Default olarak new Date() gelsin.
    //@Value("#{new java.util.Date()}") Default olarak tarih verebiliriz.
    @Temporal(TemporalType.DATE)
    @Column
    private Date realeseDate;

    @ManyToOne
    @JoinColumn(name = "jobPositionId")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "employerId")
    private Employer employer;

    //Bir ilana başvuran cv leri tutacağımız kısım.
    @ManyToMany//İlk değer oluşturulacak tablo ismidir. JoinColums dediği 1.sütundur.
    @JoinTable(name="advertisementResumes",joinColumns = @JoinColumn(name = "advertisementId"),inverseJoinColumns = @JoinColumn(name = "resumeId"))
    private List<Resume> resumes;


}
