package com.study.service;

import com.study.domain.Region;
import com.study.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    public boolean existsByName(String name) {
        return regionRepository.existsByName(name);
    }
}
