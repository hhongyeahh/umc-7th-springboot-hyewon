package com.study.domain;

import com.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String body;

    private Float score;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", member=" + member.getName() +
                ", store=" + store.getName() +
                ", body='" + body + '\'' +
                ", score=" + score +
                '}';
    }
}
