package com.rotation.dating.dto;

import com.rotation.dating.entity.Member;
import lombok.Data;

@Data
public class MemberResponseDto {
    private Long id;
    private String email;
    private String nickname;
    private String role;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.role = member.getRole().name();
    }

}
