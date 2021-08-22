package com.karadag.hrmsProject.business.concretes;

import com.karadag.hrmsProject.business.abstracts.ResumeServices;
import com.karadag.hrmsProject.core.concretes.CloudinaryAdapter;
import com.karadag.hrmsProject.core.concretes.PhotoUploadManager;
import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.core.utilities.SuccessDataResult;
import com.karadag.hrmsProject.core.utilities.SuccessResult;
import com.karadag.hrmsProject.dataAccess.abstracts.ResumeDao;
import com.karadag.hrmsProject.entities.concretes.Resume;
import com.karadag.hrmsProject.entities.concretes.ResumeExperience;
import com.karadag.hrmsProject.entities.concretes.ResumeSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ResumeManager implements ResumeServices {

    ResumeDao resumeDao;

    Resume myResume;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public Result addResume(Resume resume) {
        PhotoUploadManager photoUploadManager = new PhotoUploadManager(new CloudinaryAdapter());
        photoUploadManager.uploadToPhoto(resume.getPhotografLink());

        //Eğer mezun değilse mezuniyet tarihini giremesin (null olarak dönecektir)
        List<ResumeSchool> resumeSchools = resume.getResumeSchools();
        for (ResumeSchool school : resumeSchools) {
            if (!school.isGraduate()) {
                school.setGraduateDate(null);
            }
        }

        //Eğer işte ahala çalışıyorsa işten ayrılma yılı boş geçilmelidir.
        List<ResumeExperience> experiences = resume.getExperiences();
        for (ResumeExperience resumeExperience : experiences) {
            if (!resumeExperience.isDoesItContinue()) {
                resumeExperience.setFinishDate(null);
            }
        }

        resumeDao.save(resume);
        return new SuccessResult("Resume eklendi.");
    }

    //Aşağıdaki iki metot bu metot çalışmadan çalışmaz. Çünkü burada Resume ye değer geliyor. Front end düşünülerek hareket edilmiştir.
    @Override
    public DataResult<Resume> getAllByEmplooyeId(int employeeId) {
        this.myResume = resumeDao.getAllByEmplooyeId(employeeId);
        return new SuccessDataResult<>(resumeDao.getAllByEmplooyeId(employeeId), "Resume başarıyla getirildi");
    }

    @Override
    public DataResult<Resume> getAllByEmplooyeIdSortedWithGraduateDate(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("Desc")) {
            this.myResume.getResumeSchools().sort(Comparator.comparing((ResumeSchool::getGraduateDate)).reversed());
        } else {
            this.myResume.getResumeSchools().sort(Comparator.comparing((ResumeSchool::getGraduateDate)));
        }
        return new SuccessDataResult<>(this.myResume, "Okullar Mezuniyet Tarihine göre sıralanmıştır.");
    }

    @Override
    public DataResult<Resume> getAllByEmplooyeIdSortedWithExperienceFinishDate(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("Desc")) {
            this.myResume.getExperiences().sort(Comparator.comparing((ResumeExperience::getFinishDate)).reversed());
        } else {
            this.myResume.getExperiences().sort(Comparator.comparing((ResumeExperience::getFinishDate)));
        }
        return new SuccessDataResult<>(this.myResume, "Deneyimler işten ayrılma Tarihine göre sıralanmıştır.");
    }

}
