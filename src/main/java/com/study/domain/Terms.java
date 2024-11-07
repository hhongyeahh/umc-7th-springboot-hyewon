package com.study.domain;

import com.study.domain.common.BaseEntity;
import com.study.domain.mapping.MemberAgree;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = {CascadeType.ALL})
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
