package com.study.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;
import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.QMember;
import com.study.domain.enums.MissionStatus;
import com.study.domain.mapping.MemberMission;
import com.study.domain.mapping.QMemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPQLQueryFactory jpqlQueryFactory;

    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;

    @Override
    public List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus missionStatus) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null){
            predicate.and(memberMission.member.id.eq(memberId));

        }
        if(missionStatus != null){
            predicate.and(memberMission.status.eq(missionStatus));
        }
        return jpqlQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.member, member).fetchJoin()
                .where(predicate)
                .fetch();

    }
    @Override
    public MemberMission findByMemberAndMission(Member member, Mission mission) {
        return jpqlQueryFactory
                .selectFrom(memberMission)
                .where(
                        memberMission.member.eq(member),
                        memberMission.mission.eq(mission)
                )
                .fetchOne();
    }


}
