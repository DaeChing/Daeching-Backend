package com.example.daeching.resume;

import com.example.daeching.resume.dto.ResumeDto;
import com.example.daeching.user.UserEntity;
import com.example.daeching.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void registerResume(ResumeDto resumeDto) {
        UserEntity userEntity = userRepository.findById(resumeDto.getUserId()).orElseThrow();

        ResumeEntity resumeEntity = ResumeEntity.builder()
                .user(userEntity)
                .introduction(resumeDto.getIntroduction())
                .portfolio(resumeDto.getPortfolio())
                .resume(resumeDto.getResume())
                .awards(resumeDto.getAwards())
                .build();

        resumeRepository.save(resumeEntity);
    }
}
