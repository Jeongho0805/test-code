package com.test.dto;

import com.test.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {

    private String name;

    private int age;

    public static MemberDto of(Member member) {
        return new MemberDto(member.getName(), member.getAge());
    }
}
