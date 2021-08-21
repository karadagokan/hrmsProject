package com.karadag.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JobPositions")
public class JobPosition {

    @Id
    @Column(name = "jobPositionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobPositionId;

    @Column(name = "positionName", nullable = false)
    private String positionName;

    @OneToMany(mappedBy = "jobPosition")
    private List<Advertisement> advertisements;

}
