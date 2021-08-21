package com.karadag.hrmsProject.api.controllers;

import com.karadag.hrmsProject.business.abstracts.AdvertisementService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.AdvertisementDetail;
import com.karadag.hrmsProject.entities.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class AdvertisementController {

    AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping("/addNew")
    public Result addJobAdvertisement(@RequestBody Advertisement advertisement) {
        return advertisementService.addJobAdvertisement(advertisement);
    }

    @GetMapping("/getAll")
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisement() {
        return advertisementService.getAllJobAdvertisement();
    }

    @GetMapping("/getAllSortedDate")
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisementSortedDate(@RequestParam String ascOrDesc) {
        return advertisementService.getAllJobAdvertisementSortedDate(ascOrDesc);
    }

    @GetMapping("/getAllByCompany")
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisementByCompany(@RequestParam String companyName) {
        return advertisementService.getAllJobAdvertisementByCompany(companyName);
    }


}
