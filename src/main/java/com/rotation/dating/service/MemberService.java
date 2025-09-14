package com.rotation.dating.service;

import com.rotation.dating.dto.MemberLoginRequestDto;
import com.rotation.dating.dto.MemberResponseDto;
import com.rotation.dating.dto.MemberSignupRequestDto;
import com.rotation.dating.entity.Member;
import com.rotation.dating.entity.Role;
import com.rotation.dating.global.error.CustomException;
import com.rotation.dating.global.error.ErrorCode;
import com.rotation.dating.global.error.exception.EntityNotFoundException;
import com.rotation.dating.global.jwt.JwtTokenProvider;
import com.rotation.dating.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signup(MemberSignupRequestDto request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .role(Role.USER)
                .build();

        memberRepository.save(member);
    }

    public String login(MemberLoginRequestDto request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return jwtTokenProvider.createToken(member.getEmail());
    }

    public MemberResponseDto getMyInfo(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        return new MemberResponseDto(member);
    }

    public MemberResponseDto getCurrentMember(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        log.info("Found member: {}", member);
        return new MemberResponseDto(member);
    }
}
