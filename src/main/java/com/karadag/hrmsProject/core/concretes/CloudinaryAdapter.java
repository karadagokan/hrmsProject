package com.karadag.hrmsProject.core.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.karadag.hrmsProject.core.abstracts.PhotoUploadService;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CloudinaryAdapter implements PhotoUploadService {

    @Override
    public void uploadToPhoto(String photoUrl) {
        try {
            FileReader fileReader = new FileReader("src/main/java/com/karadag/hrmsProject/CloudinarySettings.properties");

            Properties properties = new Properties();
            properties.load(fileReader);

            //CloudinarySettings den çekiyor kendi bilgilerinizi lütfen girin.
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", properties.getProperty("cloud_name"),
                           "api_key", properties.getProperty("api_key"),
                           "api_secret", properties.getProperty("api_secret")
            ));
            //cloudinary.uploader().upload(new File("Fotoğraf Yolu"),ObjectUtils.asMap()); ->Kendi bilgisayarınızdan yükleyecekseniz
            cloudinary.uploader().upload(photoUrl, ObjectUtils.asMap()); //Linkten alacaksanız.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fotoğraf yüklenirken hata lütfen url kontrol edin");
        }
    }

}
