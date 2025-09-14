package com.rotation.dating.service;

import com.rotation.dating.repository.DatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DatingService {

    private final DatingRepository datingRepository;



}
