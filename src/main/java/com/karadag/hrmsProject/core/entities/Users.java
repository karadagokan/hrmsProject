package com.karadag.hrmsProject.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Kalıtım yoluyla ortak alanları inherit eder , hem de kendi tablosunu oluşturur.
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "emailValidation" }) Bu anatasyonla da verilerin tekrarını önleyebilirsiniz. (Extra bilgi)
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, unique = true, updatable = false)
	private int userId;

	@Email(message = "Geçerli bir email adresi değil")
	@NotBlank
	@NotNull
	@Column(nullable = false, name = "email")
	private String email;

	@NotNull
	@NotBlank
	@Column(nullable = false, name = "password")
	private String password;

	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	@JsonIgnore // İlişkili tablolar varsa getAll kısmında bir sorun çıkabilir. Bu anatasyonla bu sorunu çözüyoruz. Bu da verilerin tekrarını önler.
	private EmailValidation emailValidation;

}
