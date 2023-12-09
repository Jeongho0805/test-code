package com.test.repository;

import com.test.domain.Member;
import com.test.respotiroy.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("member를 저장하면 Id값이 부여된다.")
    void saveMember() {
        Member member = new Member("jeongho", 28);
        Member saveMember = memberRepository.save(member);

        assertThat(saveMember.getId()).isNotNull();
    }
}
