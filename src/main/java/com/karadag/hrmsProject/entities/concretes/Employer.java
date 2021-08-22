package com.karadag.hrmsProject.entities.concretes;

import com.karadag.hrmsProject.core.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employer")
@PrimaryKeyJoinColumn(name = "employerId")
public class Employer extends Users {

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "telephoneNumber", length = 20, nullable = false)
    private String telephoneNumber;

    @Column(name = "website", nullable = false)
    private String website;

    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private HrmsValidation hrmsValidation;

    @OneToMany(mappedBy = "employer")
    private List<Advertisement> advertisement;


}
