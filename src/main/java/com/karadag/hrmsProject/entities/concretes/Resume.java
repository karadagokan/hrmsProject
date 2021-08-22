package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resumeId;

    @ElementCollection
    @CollectionTable(name = "jobSeekerSchools", joinColumns = @JoinColumn(name = "resumeId"))
    private List<ResumeSchool> resumeSchools;

    @ElementCollection
    @CollectionTable(name = "jobExperience", joinColumns = @JoinColumn(name = "resumeId"))
    private List<ResumeExperience> experiences;

    @ElementCollection
    @CollectionTable(name = "jobSeekerLanguage", joinColumns = @JoinColumn(name = "resumeId"))
    private List<ResumeLanguage> resumeLanguages;

    @Lob //Uzun string değerler için kullanılır
    private String githubLink;

    @Lob
    private String linkedinLink;

    @Lob
    private String photografLink;

    @Lob
    private String coverLetter;

    @Column(nullable = false)
    private int emplooyeId;

    @ManyToMany(mappedBy = "resumes")// Mapped by olan kısım tablonun sağdaki kismıdır. Yani inverseJoin dediğimiz.
    private List<Advertisement> advertisement;

}
