package com.example.daeching.company;

import com.example.daeching.company.dto.CompanyDto;
import com.example.daeching.company.dto.RecruitmentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("recruitments")
    public ResponseEntity<Void> registerRecruitments(@RequestBody RecruitmentsDto recruitmentsDto) {
        companyService.registerRecruitments(recruitmentsDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("companies/{companyId}")
    public ResponseEntity<CompanyDto> viewCompanyDetail(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.viewCompanyDetail(companyId), HttpStatus.OK);
    }

    @GetMapping("companies")
    public ResponseEntity<List<CompanyDto>> viewCompanyList() {
        return new ResponseEntity<>(companyService.viewAllCompanyList(),HttpStatus.OK);
    }
}
