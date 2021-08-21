package com.karadag.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class HrmsValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hrmsId;

    @Value("${some.key:false}")
    private boolean statusHrmsValidation;

    @OneToOne
    @JoinColumn(name = "employerId")
    @JsonIgnore
    private Employer employer;


}
