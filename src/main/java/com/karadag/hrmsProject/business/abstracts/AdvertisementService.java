package com.karadag.hrmsProject.business.abstracts;


import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.Advertisement;
import com.karadag.hrmsProject.entities.dtos.AdvertisementDetail;

import java.util.List;

public interface AdvertisementService {

    Result addJobAdvertisement(Advertisement advertisement);

    DataResult<List<AdvertisementDetail>> getAllJobAdvertisement();

    DataResult<List<AdvertisementDetail>> getAllJobAdvertisementSortedDate(String ascOrDesc);

    DataResult<List<AdvertisementDetail>> getAllJobAdvertisementByCompany(String companyName);


}
