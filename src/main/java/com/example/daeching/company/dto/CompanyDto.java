package com.example.daeching.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CompanyDto {
    private Long companyId;
    private String imageUrl;
    private Long score;
    private String introduction;
    private String mainTask;
    private String qualificationRequirements;
    private String preferredQualifications;
    private String recruitmentProcess;
    private String welfare;
}
