package com.study.service.MemberService;

import com.study.apiPayload.code.exception.handler.FoodCategoryHandler;
import com.study.apiPayload.code.status.ErrorStatus;
import com.study.converter.MemberConverter;
import com.study.converter.MemberPreferConverter;
import com.study.domain.FoodCategory;
import com.study.domain.Member;
import com.study.domain.mapping.MemberPrefer;
import com.study.dto.request.MemberRequestDTO;
import com.study.repository.FoodCategoryRepository;
import com.study.repository.MemberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository
                            .findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
