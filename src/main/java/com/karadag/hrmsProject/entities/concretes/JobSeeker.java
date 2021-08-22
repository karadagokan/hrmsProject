package com.karadag.hrmsProject.entities.concretes;

import com.karadag.hrmsProject.core.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "JobSeeker")
@PrimaryKeyJoinColumn(name = "employeeId")
public class JobSeeker extends Users {

    @NotBlank
    @NotNull
    @Column(name = "yearOfBirth", length = 4)
    private String yearOfBirth;

    @NotBlank
    @NotNull
    @Column(name = "nationalityId", length = 11)
    private String nationalityId;

    @NotBlank
    @NotNull
    @Column(name = "firstName", length = 50)
    private String firstName;

    @NotBlank
    @NotNull
    @Column(name = "lastName", length = 50)
    private String lastName;

    public JobSeeker(String yearOfBirth, String nationalityId, String firstName, String lastName, String email, String password) {
        this.yearOfBirth = yearOfBirth;
        this.nationalityId = nationalityId;
        this.firstName = firstName;
        this.lastName = lastName;
        super.setEmail(email);
        super.setPassword(password);
    }


}
