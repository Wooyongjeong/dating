package com.rotation.dating.service;

import com.rotation.dating.dto.DatingCreateRequestDto;
import com.rotation.dating.dto.DatingCreateResponseDto;
import com.rotation.dating.entity.Dating;
import com.rotation.dating.entity.DatingCriteria;
import com.rotation.dating.entity.Member;
import com.rotation.dating.repository.DatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DatingManagerService {

    private final DatingRepository datingRepository;

    @Transactional
    public DatingCreateResponseDto createDating(Member member, DatingCreateRequestDto request) {
        Dating dating = request.toEntity(member);
        DatingCriteria datingCriteria = request.getDatingCriteria().toEntity();
        dating.setDatingCriteria(datingCriteria);

        datingRepository.save(dating);
        log.info("Created new dating event with ID: {}", dating.getId());

        return new DatingCreateResponseDto(dating.getId());
    }

}
