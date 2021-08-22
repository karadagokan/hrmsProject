package com.karadag.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//DTOS data transfer object anlamına gelir. Birden fazla tablodan alacağımız şeyleri koyuyoruz.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDetail {

    private String companyName;

    private String positionName;

    private int numberOfOpenPosition;

    private Date realeseDate;

    private Date applicationDeadLine;

}
