package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.util.TestFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberRegisterServiceTest(
        MemberRegisterService memberRegisterService
) {

    @Test
    void registerMember() {
        MemberRegisterInfo request = TestFixture.createMemberRegisterInfo();

        Member member = memberRegisterService.register(request);

        Assertions.assertThat(member.getUuid()).isNotNull();
    }
}