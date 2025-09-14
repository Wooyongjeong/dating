package com.rotation.dating.controller;

import com.rotation.dating.dto.DatingCreateRequestDto;
import com.rotation.dating.dto.DatingCreateResponseDto;
import com.rotation.dating.service.DatingManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dating-manager")
@RequiredArgsConstructor
@Slf4j
public class DatingManagerController {

    private final DatingManagerService datingManagerService;

    @PostMapping
    public ResponseEntity<DatingCreateResponseDto> createDatingEvent(@RequestBody DatingCreateRequestDto request) {
        DatingCreateResponseDto dating = datingManagerService.createDating(null, request);// TODO : Replace null with actual member object
        // TODO : 공통 응답 객체 만들어서 감싸기
        return ResponseEntity.ok(dating);
    }

    @PutMapping("/{datingId}")
    public ResponseEntity<?> updateDatingEvent(@PathVariable Long datingId, @RequestBody DatingCreateRequestDto request) {
        // TODO : DatingUpdateRequestDto 만들어서 사용. DatingStatus에 대한 부분도 추가
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{datingId}")
    public ResponseEntity<?> deleteDatingEvent(@PathVariable Long datingId) {
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

}
