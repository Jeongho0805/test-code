package com.test.service;

import com.test.domain.Member;
import com.test.dto.MemberDto;
import com.test.respotiroy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(final String name, final int age) {
        return memberRepository.save(new Member(name, age));
    }

    public String findMemberName(final Long id) {
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return member.getName();
    }

    public void plusAgeAllMember() {
        List<Member> members = memberRepository.findAll();
        members.forEach(this::plusAge);
    }

    private void plusAge(Member member) {
        if (member.getName() == "jeongho") {
            return;
        }
        member.plusAge();
    }

    public MemberDto findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
        return MemberDto.of(member);
    }
}
