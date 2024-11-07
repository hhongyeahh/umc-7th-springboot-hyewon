package com.study.web.dto;

import com.study.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MemberMyPageDto {
    private Long id;
    private String email;
    private Integer point;
    private List<Review> reviews; // 작성한 리뷰 본문 리스트

    public void print() {
        System.out.println("Member ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Point: " + point);
        System.out.println("Reviews:");
        reviews.forEach(review -> System.out.println(" - " + review.getStore()+", "+review.getScore()+", "+review.getBody()));
    }
}