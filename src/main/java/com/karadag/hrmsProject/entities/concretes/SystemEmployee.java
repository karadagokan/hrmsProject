package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "SystemEmployee")
@PrimaryKeyJoinColumn(name = "systemEmployeeId")
public class SystemEmployee extends Users {


}
