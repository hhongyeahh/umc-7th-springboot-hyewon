package com.study;

import com.study.domain.enums.MissionStatus;
import com.study.service.MemberMissionService.MemberMissionQueryService;
import com.study.service.MemberService.MemberQueryService;
import com.study.service.MissionService.MissionQueryService;
import com.study.service.ReviewService.ReviewQueryService;
import com.study.service.StoreService.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);
            MemberMissionQueryService memberMissionQueryService = context.getBean(MemberMissionQueryService.class);
            MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);
            MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);
            ReviewQueryService reviewQueryService = context.getBean(ReviewQueryService.class);

            // 파라미터 값 설정
            String name = "요아정";
            Float score = 4.0f;
            Long memberId = 1L;
            String regionName = "서울";

            // 각 쿼리 호출 메서드 실행
            executeFindStoresByNameAndScore(storeService, name, score);
            executeFindMemberMissionsByStatus(memberMissionQueryService, memberId, MissionStatus.CHALLENGING);
            executeFindMemberMyPage(memberQueryService, memberId);
            executeFindMissionByRegion(missionQueryService, regionName);
            executeFindReviewByStoreName(reviewQueryService, name);
        };
    }

    private void executeFindStoresByNameAndScore(StoreQueryService storeService, String name, Float score) {
        System.out.println("Executing findStoresByNameAndScore with parameters:");
        System.out.println("Name: " + name);
        System.out.println("Score: " + score);

        storeService.findStoresByNameAndScore(name, score)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private void executeFindMemberMissionsByStatus(MemberMissionQueryService memberMissionQueryService, Long memberId, MissionStatus missionStatus) {
        System.out.println("Executing findMemberMissionByMemberNameAndMissionStatus with parameters:");
        System.out.println("memberId: " + memberId);
        System.out.println("missionStatus: " + missionStatus);

        memberMissionQueryService.findMemberMissionsByNameAndMissionStatus(memberId, missionStatus)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private void executeFindMemberMyPage(MemberQueryService memberQueryService, Long memberId) {
        System.out.println("Executing findMemberMyPageById with parameters:");
        System.out.println("memberId: " + memberId);

        memberQueryService.getMemberMyPage(memberId);
        System.out.println("\n");
    }

    private void executeFindMissionByRegion(MissionQueryService missionQueryService, String regionName) {
        System.out.println("Executing findMissionByRegion with parameters:");
        System.out.println("regionName: " + regionName);

        missionQueryService.findMissionByRegion(regionName)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    private void executeFindReviewByStoreName(ReviewQueryService reviewQueryService, String storeName){
        System.out.println("Executing findReviewByStoreName with parameters:");
        System.out.println("storeName: "+storeName);

        reviewQueryService.findReviewsByStoreName(storeName,null,null)
                .forEach(System.out::println);
        System.out.println("\n");
    }

}
