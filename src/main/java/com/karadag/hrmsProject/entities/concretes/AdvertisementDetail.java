package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
