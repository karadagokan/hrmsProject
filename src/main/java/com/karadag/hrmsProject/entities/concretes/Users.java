package com.karadag.hrmsProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Kalıtım yoluyla ortak alanları inherit eder , hem de kendi tablosunu
												// oluşturur.
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, unique = true, updatable = false)
	private int userId;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(nullable = false, name = "password")
	private String password;

	@OneToOne(mappedBy = "users",cascade = CascadeType.ALL)
	@JsonIgnore // İlişkili tablolar varsa getAll kısmında bir sorun çıkabilir. Bu anatasyonla
				// bu sorunu çözüyoruz.
	private EmailValidation emailValidation;
	
	

}
