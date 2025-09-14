package com.rotation.dating.controller;

import com.rotation.dating.entity.Member;
import com.rotation.dating.service.ParticipationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/participation")
@RequiredArgsConstructor
@Slf4j
public class ParticipationController {

    private final ParticipationService participationService;

    @PostMapping("/dating/{datingId}")
    public ResponseEntity<?> participateInDating(@PathVariable Long datingId, Member member) {
        // TODO : Implement this method
        // TODO : 1. 결제, 2. DatingUser의 참여 요청, 3. DatingManager에게 알림, 4. DatingManager가 수락 또는 거절
        // TODO : 4-1. 수락 시 참여 상태 변경, Dating의 DatingUser의 성별 현원 변경 및 DatingUser에게 알림
        // TODO : 4-2. 거절 시 참여 상태 변경 및 DatingUser에게 알림
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/dating/{datingId}")
    public ResponseEntity<?> cancelParticipation(@PathVariable Long datingId, Member member) {
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<?> getMyParticipations(Member member, Pageable pageable) {
        // TODO : Implement this method
        // TODO : 검색 조건 추가 (예: 상태, 날짜, 위치 등)
        return ResponseEntity.ok(null);
    }

    @GetMapping("/dating/{datingId}")
    public ResponseEntity<?> getParticipation(@PathVariable Long datingId, Member member) {
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

}
