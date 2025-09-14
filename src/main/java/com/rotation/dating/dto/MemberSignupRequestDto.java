package com.rotation.dating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberSignupRequestDto {
    private String email;
    private String password;
    private String nickname;
}
