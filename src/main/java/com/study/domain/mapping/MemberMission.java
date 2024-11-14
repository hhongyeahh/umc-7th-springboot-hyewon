package com.study.domain.mapping;

import com.study.domain.Member;
import com.study.domain.Mission;
import com.study.domain.common.BaseEntity;
import com.study.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MissionStatus status;

    @Override
    public String toString() {
        return "MemberMission{" +
                "id=" + id +
                ", member=" + member.getName() +
                ", mission_store=" + mission.getStore().getName() +
                ", mission_spec=" + mission.getMissionSpec() +
                ", mission_reward=" +mission.getReward() +
                ", status=" + status +
                '}';
    }
}