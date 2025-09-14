package com.rotation.dating.controller;

import com.rotation.dating.dto.MemberLoginRequestDto;
import com.rotation.dating.dto.MemberResponseDto;
import com.rotation.dating.dto.MemberSignupRequestDto;
import com.rotation.dating.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody MemberSignupRequestDto request) {
        memberService.signup(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody MemberLoginRequestDto request) {
        String token = memberService.login(request);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentMember(@AuthenticationPrincipal User user) {
        String email = user.getUsername();
        log.info("Current user email from UserDetails: {}", email);

        MemberResponseDto memberResponseDto = memberService.getMyInfo(email);
        return ResponseEntity.ok(memberResponseDto);
    }
}
