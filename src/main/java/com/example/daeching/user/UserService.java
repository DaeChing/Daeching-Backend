package com.example.daeching.user;

import com.example.daeching.user.dto.LoginDto;
import com.example.daeching.user.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void singUp(SignUpDto signUpDto) {
        UserEntity userEntity = UserEntity.builder()
                .loginId(signUpDto.getLoginId())
                .name(signUpDto.getUserName())
                .password(signUpDto.getPassword())
                .role(signUpDto.getRole())
                .build();

        userRepository.save(userEntity);
    }

    public LoginDto login(LoginDto loginDto) {
        UserEntity user = userRepository.findByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());

        return LoginDto.builder()
                .name(user.getName())
                .role(user.getRole())
                .userId(user.getUserId())
                .build();
    }
}
