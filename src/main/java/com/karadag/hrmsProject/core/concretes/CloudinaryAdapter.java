package com.karadag.hrmsProject.core.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.karadag.hrmsProject.core.abstracts.PhotoUploadService;

public class CloudinaryAdapter implements PhotoUploadService{

	@Override
	public boolean uploadToPhoto(String photoUrl) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "karadag",
				  "api_key", "331497793914745",
				  "api_secret", "T4ejZVzESCPWHRehevQZg_XiHts"));
				
		try {
			//cloudinary.uploader().upload(new File("Fotoğraf Yolu"),ObjectUtils.asMap()); ->Kendi bilgisayarınızdan yükleyecekseniz
			cloudinary.uploader().upload(photoUrl,ObjectUtils.asMap()); //Linkten alacaksanız.
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Fotoğraf yüklenirken hata lütfen url kontrol edin");
		}		
		return false;
	}

}
