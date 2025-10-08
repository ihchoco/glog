package com.ihchoco.glog.member.application.required;

import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import static com.ihchoco.glog.util.TestFixture.createMemberReigsterRequest;
import static com.ihchoco.glog.util.TestFixture.createMemberUpdateRequest;

// # AutoConfigureTestDataBase : DataJpaTest를 사용할 때 임베디드 DB(H2)를 사용하려고 시도하는 것을 방지하고 yml에 설정된 DB를 사용하도록 변경
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Transactional
// @DataJpaTest // # 기존에는 사용가능했지만, JPA Auditor 추가되었기에 SpringBootTest로 변경 (No bean named 'auditorAware' available 에러 방지)
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberRepositoryTest(
    MemberRepository memberRepository
) {

    @BeforeEach
    void before() {
        memberRepository.deleteAll();
    }

    @Test
    // @Rollback(value = false)
    void registerMember(){
        Member member = saveMember();

        Assertions.assertThat(member.getUuid()).isNotNull();
    }

    @Test
    void updateMember(){
        Member member = saveMember();

        Member savedMember = memberRepository.findByUuid(member.getUuid())
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] No Such Member Founded"));

        MemberUpdateRequest updateRequest = createMemberUpdateRequest();

        savedMember.update(updateRequest);
    }


    private Member saveMember() {
        MemberRegisterRequest request = createMemberReigsterRequest();

        Member member = Member.register(request);

        memberRepository.save(member);

        return member;
    }

}