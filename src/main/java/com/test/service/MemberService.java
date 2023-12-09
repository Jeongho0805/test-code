package com.test.service;

import com.test.domain.Member;
import com.test.respotiroy.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(final String name, final int age) {
        memberRepository.save(new Member(name, age));
    }

    public String findMemberName(final Long id) {
        Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return member.getName();
    }

    public void
}
