package com.example.daeching.company;

import com.example.daeching.company.dto.RecruitmentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("recruitments")
    public ResponseEntity<Void> registerRecruitments(@RequestBody RecruitmentsDto recruitmentsDto) {
        companyService.registerRecruitments(recruitmentsDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
