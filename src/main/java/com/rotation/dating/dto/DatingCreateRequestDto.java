package com.rotation.dating.dto;

import com.rotation.dating.entity.Dating;
import com.rotation.dating.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DatingCreateRequestDto {

    private String title;
    private String content;
    private AddressDto address;
    private DatingCriteriaDto datingCriteria;
    private LocalDateTime meetingDateTime;

    public Dating toEntity(Member member) {
        return Dating.builder()
                .member(member)
                .title(title)
                .content(content)
                .address(address.toEntity())
                .meetingDateTime(meetingDateTime)
                .build();
    }
}
