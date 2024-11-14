package com.study.repository;

import com.study.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsByName(String regionName);
    Optional<Region> findByName(String regionName);
}
