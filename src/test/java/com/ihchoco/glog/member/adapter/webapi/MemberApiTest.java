package com.ihchoco.glog.member.adapter.webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ihchoco.glog.member.application.provided.MemberRegisterService;
import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.vo.MemberType;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MemberRegisterService memberRegisterService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void register_returns_createdMember() throws Exception {
        // given
        MemberRegisterRequest request = new MemberRegisterRequest(
                "testUser", "tester", "password123", "test@example.com", MemberType.USER);

        Member member = Member.register(request);
        ReflectionTestUtils.setField(member, "uuid", "1234");
        // 각 필드 setter 대신 생성자 혹은 리플렉션 등으로 값 설정 필요할 수 있음
        // 테스트 목적에 맞게 member 객체 준비
        // 예) member.setUuid("uuid123"); member.setMemberId(...); 등 (getter가 있음)

        // 모킹으로 서비스 호출 시 미리 반환 값 지정
        given(memberRegisterService.register(any(MemberRegisterInfo.class))).willReturn(member);

        // when & then
        mockMvc.perform(post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(header().string("X-Custom-Header", "value"))
                .andExpect(jsonPath("$.memberUuid").exists())
                .andExpect(jsonPath("$.memberId").exists())
                .andExpect(jsonPath("$.nickname").exists())
                .andExpect(jsonPath("$.email").exists())
                .andDo(print());
    }
}
