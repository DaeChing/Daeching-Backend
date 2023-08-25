package com.example.daeching.user;

import com.example.daeching.user.dto.LoginDto;
import com.example.daeching.user.dto.SignUpDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 가입을 합니다")
    @Parameters({
            @Parameter(name="userName", description = "회원 이름"),
            @Parameter(name="loginId", description = "로그인 ID"),
            @Parameter(name="password", description = "비밀번호"),
            @Parameter(name="role", description = "WORKER 인지 COMPANY 인지")
    })
    @PostMapping("signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpDto signUpDto) {
        userService.singUp(signUpDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "로그인을 합니다")
    @Parameters({
            @Parameter(name="userId", description = "회원 고유 Id"),
            @Parameter(name="name", description = "회원 이름"),
            @Parameter(name="loginId", description = "로그인 ID"),
            @Parameter(name="password", description = "비밀번호"),
            @Parameter(name="role", description = "WORKER 인지 COMPANY 인지")
    })
    @PostMapping("login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }
}
