package com.test.service;

import com.test.domain.Member;
import com.test.respotiroy.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("memberId로 회원의 이름을 조회할 수 있다.")
    void findMemberNameByIdTest() {
        Member member = new Member("jeongho", 28);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        String memberName = memberService.findMemberName(1L);

        Assertions.assertThat(memberName).isEqualTo(member.getName());
    }
}
