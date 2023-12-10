package com.test.unit.dto;

import com.test.domain.Member;
import com.test.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberDtoTest {

    @Test
    @DisplayName("Member 정보를 바탕으로 MemberDto를 생성한다.")
    void makeMemberDto() {
        Member member = new Member("hoya", 28);
        MemberDto memberDto = MemberDto.of(member);

        assertThat(memberDto.getName()).isEqualTo("hoya");
        assertThat(memberDto.getAge()).isEqualTo(28);
    }
}
