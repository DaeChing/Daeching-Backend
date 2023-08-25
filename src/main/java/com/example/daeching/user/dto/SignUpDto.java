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
public class SignUpDto {
    private String userName;
    private String loginId;
    private String password;
    private Role role;
}
