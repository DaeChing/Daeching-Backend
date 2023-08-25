package com.example.daeching.resume;

import com.example.daeching.resume.dto.ResumeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ResumeController {

    private final ResumeService resumeService;

    @Operation(summary = "이력서를 등록합니다")
    @Parameters({
            @Parameter(name="userId", description = "회원 고유 Id"),
            @Parameter(name="introduction", description = "기업 소개"),
            @Parameter(name="portfolio", description = "포트폴리오"),
            @Parameter(name="resume", description = "이력서"),
            @Parameter(name="awards", description = "수상 내역")
    })
    @PostMapping("resumes")
    public ResponseEntity<Void> registerResume(@RequestBody ResumeDto resumeDto) {
        resumeService.registerResume(resumeDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
