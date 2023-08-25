package com.example.daeching.company;

import com.example.daeching.company.dto.CompanyDto;
import com.example.daeching.company.dto.RecruitmentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void registerRecruitments(RecruitmentsDto recruitmentsDto) {
        CompanyEntity companyEntity = CompanyEntity.builder()
                .score(recruitmentsDto.getScore())
                .imageUrl(recruitmentsDto.getImageUrl())
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

    public CompanyDto viewCompanyDetail(Long companyId) {
        CompanyEntity companyEntity = companyRepository.findById(companyId).orElseThrow();

        return CompanyDto.builder()
                .companyId(companyEntity.getCompanyId())
                .imageUrl(companyEntity.getImageUrl())
                .score(companyEntity.getScore())
                .introduction(companyEntity.getIntroduction())
                .mainTask(companyEntity.getMainTask())
                .qualificationRequirements(companyEntity.getQualificationRequirements())
                .preferredQualifications(companyEntity.getPreferredQualifications())
                .recruitmentProcess(companyEntity.getRecruitmentProcess())
                .welfare(companyEntity.getWelfare())
                .build();
    }

    public List<CompanyDto> viewAllCompanyList() {
        List<CompanyDto> companyDtoList = new ArrayList<>();

        List<CompanyEntity> companyEntityList = companyRepository.findAll();

        for(CompanyEntity companyEntity : companyEntityList) {
            CompanyDto companyDto = CompanyDto.builder()
                    .companyId(companyEntity.getCompanyId())
                    .imageUrl(companyEntity.getImageUrl())
                    .score(companyEntity.getScore())
                    .introduction(companyEntity.getIntroduction())
                    .mainTask(companyEntity.getMainTask())
                    .qualificationRequirements(companyEntity.getQualificationRequirements())
                    .preferredQualifications(companyEntity.getPreferredQualifications())
                    .recruitmentProcess(companyEntity.getRecruitmentProcess())
                    .welfare(companyEntity.getWelfare())
                    .build();

            companyDtoList.add(companyDto);
        }

        return companyDtoList;
    }
}
