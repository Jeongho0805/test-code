package com.test.unit.controller;

import com.test.controller.MemberController;
import com.test.dto.MemberDto;
import com.test.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("회원 Id로 회원 정보 조회")
    void findMemberById() throws Exception {
        when(memberService.findMember(1L)).thenReturn(new MemberDto("jeongho", 28));

        MockHttpServletRequestBuilder requestInfo = get("/members/{id}", 1);
        mockMvc.perform(requestInfo)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("jeongho"))
                .andExpect(jsonPath("$.age").value(28));
    }
}
