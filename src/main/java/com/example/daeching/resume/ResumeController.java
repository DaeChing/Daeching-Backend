package com.example.daeching.resume;

import com.example.daeching.resume.dto.ResumeDto;
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

    @PostMapping("resumes")
    public ResponseEntity<Void> registerResume(@RequestBody ResumeDto resumeDto) {
        resumeService.registerResume(resumeDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
