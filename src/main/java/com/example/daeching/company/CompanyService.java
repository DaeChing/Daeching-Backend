package com.example.daeching.company;

import com.example.daeching.company.dto.RecruitmentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void registerRecruitments(RecruitmentsDto recruitmentsDto) {
        CompanyEntity companyEntity = CompanyEntity.builder()
                .name(recruitmentsDto.getName())
                .introduction(recruitmentsDto.getIntroduction())
                .mainTask(recruitmentsDto.getMainTask())
                .qualificationRequirements(recruitmentsDto.getQualificationRequirements())
                .preferredQualifications(recruitmentsDto.getPreferredQualifications())
                .recruitmentProcess(recruitmentsDto.getRecruitmentProcess())
                .welfare(recruitmentsDto.getWelfare())
                .build();

        companyRepository.save(companyEntity);
    }
}
