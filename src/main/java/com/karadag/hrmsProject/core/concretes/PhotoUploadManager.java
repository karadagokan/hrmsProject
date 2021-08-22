package com.karadag.hrmsProject.core.concretes;

import com.karadag.hrmsProject.core.abstracts.PhotoUploadService;

public class PhotoUploadManager implements PhotoUploadService {

    PhotoUploadService photoUploadService;

    public PhotoUploadManager(PhotoUploadService photoUploadService) {
        this.photoUploadService = photoUploadService;
    }

    @Override
    public void uploadToPhoto(String photoUrl) {
        photoUploadService.uploadToPhoto(photoUrl);
    }

}
