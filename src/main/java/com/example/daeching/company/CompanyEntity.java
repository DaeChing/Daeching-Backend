package com.example.daeching.company;

import com.example.daeching.resume.ResumeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String name;

    @Column(length = 500)
    private String introduction;

    @Column(length = 500)
    private String mainTask;

    @Column(length = 500)
    private String qualificationRequirements;

    @Column(length = 500)
    private String preferredQualifications;

    @Column(length = 500)
    private String recruitmentProcess;

    @Column(length = 500)
    private String welfare;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    List<ResumeEntity> resumeEntityList = new ArrayList<>();


}
