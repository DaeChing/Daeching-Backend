package com.example.daeching.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ResumeDto {
    private Long userId;
    private String introduction;
    private String portfolio;
    private String resume;
    private String awards;
}
