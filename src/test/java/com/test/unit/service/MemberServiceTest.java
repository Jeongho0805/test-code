package com.test.unit.service;

import com.test.domain.Member;
import com.test.dto.MemberDto;
import com.test.respotiroy.MemberRepository;
import com.test.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원은 정상적으로 저장된다.")
    void saveMember() {
        Member member = new Member("jeongho", 28);
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        Member savedMember = memberService.saveMember("jeongho", 28);

        assertThat(savedMember.getName()).isEqualTo("jeongho");
        assertThat(savedMember.getAge()).isEqualTo(28);
    }

    @Test
    @DisplayName("memberId로 회원의 이름을 조회할 수 있다.")
    void findMemberNameByIdTest() {
        Member member = new Member("jeongho", 28);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        String memberName = memberService.findMemberName(1L);

        assertThat(memberName).isEqualTo(member.getName());
    }

    @Test
    @DisplayName("모든 회원의 나이를 1씩 증가시킨다.")
    void plusAgeAllMemberTest() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 25);

        List<Member> members = Arrays.asList(member1, member2);
        when(memberRepository.findAll()).thenReturn(members);

        memberService.plusAgeAllMember();

        assertThat(member1.getAge()).isEqualTo(21);
        assertThat(member2.getAge()).isEqualTo(26);
    }

    @Test
    @DisplayName("이름이 'jeongho' 이면 나이를 먹지 않는다.")
    void jeonghoIsNotAging() {
        Member member = new Member("jeongho", 28);
        when(memberRepository.findAll()).thenReturn(List.of(member));

        memberService.plusAgeAllMember();

        assertThat(member.getAge()).isEqualTo(28);
    }

    @Test
    @DisplayName("회원 Id를 바탕으로 회원을 찾을 수 있다.")
    void findMemberById() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(new Member("hoya", 28)));

        MemberDto member = memberService.findMember(1L);

        assertThat(member.getName()).isEqualTo("hoya");
        assertThat(member.getAge()).isEqualTo(28);
    }


}
