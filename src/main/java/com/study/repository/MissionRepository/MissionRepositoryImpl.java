package com.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;
import com.study.domain.Mission;
import com.study.domain.QMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{
    private final JPQLQueryFactory jpqlQueryFactory;
    private final QMission mission = QMission.mission;
    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(String regionName) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(regionName != null){
            predicate.and(mission.store.region.name.eq(regionName));
        }
        return jpqlQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }
}
