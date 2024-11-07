package com.study.service.MemberService;

import com.study.repository.MemberRepository.MemberRepository;
import com.study.web.dto.MemberMyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberMyPageDto getMemberMyPage(Long memberId) {
        MemberMyPageDto memberMyPageDto = memberRepository.findMemberMyPageById(memberId);

        if (memberMyPageDto != null) {
            // MemberMyPageDto 객체의 필드 값을 출력
            memberMyPageDto.print();
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }

        return memberMyPageDto;
    }
}