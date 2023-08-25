package com.example.daeching.company.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RecruitmentsDto {
    private Long score;
    private String imageUrl;
    private String name;
    private String introduction;
    private String mainTask;
    private String qualificationRequirements;
    private String preferredQualifications;
    private String recruitmentProcess;
    private String welfare;
}
