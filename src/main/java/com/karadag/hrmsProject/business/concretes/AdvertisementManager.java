package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.AdvertisementService;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.core.utilities.SuccessDataResult;
import com.karadag.hrmsProject.core.utilities.SuccessResult;
import com.karadag.hrmsProject.dataAccess.abstracts.AdvertisementDao;
import com.karadag.hrmsProject.entities.concretes.Advertisement;
import com.karadag.hrmsProject.entities.dtos.AdvertisementDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AdvertisementManager implements AdvertisementService {

    AdvertisementDao advertisementDao;

    @Autowired
    public AdvertisementManager(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Override
    public Result addJobAdvertisement(Advertisement advertisement) {
        advertisementDao.save(advertisement);
        return new SuccessResult("İş ilanı eklendi.");
    }

    @Override
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisement() {
        return new SuccessDataResult<>(advertisementDao.getAllJobAdvertisement());
    }

    @Override
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisementSortedDate(String ascOrDesc) {
        // Bilgileri veritabanından farklı tablolardan çektiğimiz için sort işlemi
        // findAll fonksiyonundan yapmadık. Çünkü kendi sorgumuzu yazdık
        // ->Bundan dolayı gelen listenin Clasının memberlarından sıralama yaptık.
        // Farklı seçenekler de yapılabilir örneğin başka bir sorgu yazmak gibi .

        List<AdvertisementDetail> allJobAdvertisement = advertisementDao.getAllJobAdvertisement();

        if (ascOrDesc.equalsIgnoreCase("Desc")) {
            allJobAdvertisement.sort(Comparator.comparing(AdvertisementDetail::getRealeseDate).reversed());
        } else {
            allJobAdvertisement.sort(Comparator.comparing(AdvertisementDetail::getRealeseDate));
        }

        return new SuccessDataResult<>(allJobAdvertisement, "Başarılı bir şekilde listelendi");
    }

    @Override
    public DataResult<List<AdvertisementDetail>> getAllJobAdvertisementByCompany(String companyName) {
        return new SuccessDataResult<>(advertisementDao.getAllJobAdvertisementWithCompany(companyName),
                "Başarılı bir şekilde listelendi");
    }

}
