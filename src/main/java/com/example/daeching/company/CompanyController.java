package com.example.daeching.company;

import com.example.daeching.company.dto.CompanyDto;
import com.example.daeching.company.dto.RecruitmentsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "기업이 채용 공고를 울립니다", description = "기업이 구인 공고를 생성하는 API 입니다")
    @Parameters({
            @Parameter(name="score", description = "기업 평점"),
            @Parameter(name="imageUrl", description = "기업 대표 이미지 주소"),
            @Parameter(name="name", description = "기업 이름"),
            @Parameter(name="introduction", description = "기업 소개"),
            @Parameter(name="mainTask", description = "주요 업무"),
            @Parameter(name="qualificationRequirements", description = "자격 요건"),
            @Parameter(name="preferredQualifications", description = "우대 사항"),
            @Parameter(name="recruitmentProcess", description = "채용 절차"),
            @Parameter(name="welfare", description = "복리 후생")
    })@PostMapping("recruitments")
    public ResponseEntity<Void> registerRecruitments(@RequestBody RecruitmentsDto recruitmentsDto) {
        companyService.registerRecruitments(recruitmentsDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "기업 정보 상세 조회", description = "기업의 상세한 정보를 조회하는 API 입니다")
    @GetMapping("companies/{companyId}")
    public ResponseEntity<CompanyDto> viewCompanyDetail(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.viewCompanyDetail(companyId), HttpStatus.OK);
    }

    @Operation(summary = "기업 리스트 조회", description = "구인 공고를 등록한 기업의 리스트를 조회하는 API 입니다")
    @GetMapping("companies")
    public ResponseEntity<List<CompanyDto>> viewCompanyList() {
        return new ResponseEntity<>(companyService.viewAllCompanyList(),HttpStatus.OK);
    }
}
