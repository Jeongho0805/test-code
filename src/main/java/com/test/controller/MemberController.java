package com.test.controller;

import com.test.dto.MemberDto;
import com.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> findMemberById(@PathVariable Long memberId) {
        MemberDto member = memberService.findMember(memberId);
        return ResponseEntity.ok().body(member);
    }
}
