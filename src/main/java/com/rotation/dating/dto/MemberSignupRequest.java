package com.rotation.dating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberSignupRequest {
    private String email;
    private String password;
    private String nickname;
}
