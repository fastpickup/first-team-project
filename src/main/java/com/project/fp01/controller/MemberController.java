package com.project.fp01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.fp01.dto.MemberDTO;
import com.project.fp01.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 리스트
    @GetMapping("/list")
    public String list(Model model) {

        log.info("GET | /member/list");

        List<MemberDTO> list =  memberService.listMember();

        model.addAttribute("memberList", list);

        return "member/list";

    }

    // 회원 상세페이지
    @GetMapping("/read/{email}")
    public String read(
            @PathVariable("email") String email,
            Model model) {

        log.info("GET | /member/read/" + email);

        MemberDTO memberDTO = memberService.readMember(email);

        model.addAttribute("memberDTO", memberDTO);

        return "member/read";
    }

    // 회원가입 페이지
    @PostMapping("create")
    public String join(MemberDTO memberDTO) {

        log.info("POST | /member/create");

        memberService.joinMember(memberDTO);

        return "redirect:/member/list";
    }

    // 회원 정보 수정 페이지
    @GetMapping("update/{email}")
    public String getModifyPage(@PathVariable("email") String email, Model model){

        log.info("GET | /update/" + email);

        MemberDTO memberDTO = memberService.readMember(email);

        model.addAttribute("memberDTO", memberDTO);

        return "/member/modify";
    }

    @PostMapping("update")
    public String postModifyPage(MemberDTO memberDTO){

        log.info("POST /member/update");
        memberService.updateMember(memberDTO);

        return "redirect:/member/read/" + memberDTO.getEmail();
    }

    // 회원 삭제 페이지
    @PostMapping("delete/{email}")
    public String remove(@PathVariable("email") String email) {

        log.info("POST | /delete/" + email);

        memberService.deleteMember(email);

        return "redirect:/member/list";
    }

}
