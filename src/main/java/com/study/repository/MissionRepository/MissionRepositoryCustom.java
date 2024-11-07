package com.study.repository.MissionRepository;

import com.study.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(String regionName);
}
