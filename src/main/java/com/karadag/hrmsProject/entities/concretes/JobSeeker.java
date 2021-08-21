package com.karadag.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "JobSeeker")
@PrimaryKeyJoinColumn(name = "employeeId")
public class JobSeeker extends Users {

	@Column(name = "yearOfBirth", length = 4, nullable = false)
	private String yearOfBirth;

	@Column(name = "nationalityId", length = 11, nullable = false)
	private String nationalityId;

	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 50, nullable = false)
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
