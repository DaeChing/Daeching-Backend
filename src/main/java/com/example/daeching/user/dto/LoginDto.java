package com.example.daeching.user.dto;

import com.example.daeching.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class LoginDto {
    private Long userId;
    private String name;
    private Role role;
    private String loginId;
    private String password;
}
