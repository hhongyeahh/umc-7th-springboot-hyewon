package com.study.domain;

import com.study.domain.common.BaseEntity;
import com.study.domain.enums.Gender;
import com.study.domain.enums.MemberStatus;
import com.study.domain.enums.Role;
import com.study.domain.enums.SocialType;
import com.study.domain.mapping.MemberAgree;
import com.study.domain.mapping.MemberMission;
import com.study.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus;

    private LocalDate inactiveDate;

    @ColumnDefault("0")
    private Integer point;

    //@Column(nullable = false, length = 50)
    private String email;

    //spring security 보안 관련 필드 및 비밀번호 설정 함수 추가
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void encodePassword(String password){
        this.password = password;
    }

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL})
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL})
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL})
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL})
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", point=" + point +
                ", reviewList=" + reviewList.stream().toList() +
                '}';
    }
}
