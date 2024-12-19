package com.study.controller;

import com.study.dto.request.MemberRequestDTO;
import com.study.service.MemberService.MemberCommandService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

//    @PostMapping("/members/signup")
//    @Operation(summary = "타임리프와 스프링 시큐리티 사용한 회원가입 API")
//    public String joinMember(@ModelAttribute("memberJoinDto")MemberRequestDTO.JoinDto request,
//                             BindingResult bindingResult,
//                             Model model){
//        if(bindingResult.hasErrors()){
//            //뷰에 데이터 바인딩 실패 시 -> signup 페이지 유지
//            return "singup";
//        }
//        try{
//            memberCommandService.joinMember(request);
//            return "redirect:/login";
//        }catch (Exception e){
//            //회원가입 과정에서 에러 발생 -> 에러 메시지 + signup 페이지 유지
//            model.addAttribute("error",e.getMessage());
//            return "signup";
//        }
//    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }


}
