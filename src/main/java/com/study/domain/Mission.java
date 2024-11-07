package com.study.domain;

import com.study.domain.common.BaseEntity;
import com.study.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    @OneToMany(mappedBy = "mission", cascade = {CascadeType.ALL})
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", store=" + store +
                ", reward=" + reward +
                ", deadline=" + deadline +
                ", missionSpec='" + missionSpec + '\'' +
                '}';
    }
}
