package com.rotation.dating.controller;

import com.rotation.dating.dto.DatingCreateRequestDto;
import com.rotation.dating.dto.DatingCreateResponseDto;
import com.rotation.dating.dto.DatingResponseDto;
import com.rotation.dating.service.DatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dating")
@RequiredArgsConstructor
@Slf4j
public class DatingController {

    private final DatingService datingService;

    @GetMapping("/{datingId}")
    public ResponseEntity<DatingResponseDto> getDatingEvent(@PathVariable Long datingId) {
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<?> getDatingEvents(Pageable pageable) {
        // TODO : https://velog.io/@jthugg/spring-how-to-bind-method-arguments 쿼리파라미터 객체로 만들어서 쓰기
        // TODO : Implement this method
        return ResponseEntity.ok(null);
    }

}
