package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.application.provided.dto.MemberUpdateInfo;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.util.TestFixture;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberRegisterServiceTest(
        MemberRegisterService memberRegisterService,
        EntityManager em
) {

    @Test
    void registerMember() {
        Member member = registerMemeber();

        Assertions.assertThat(member.getUuid()).isNotNull();
    }

    @Test
    void updateMember() {
        Member member = registerMemeber();

        em.flush();
        em.clear();

        String updateMemberUUID = member.getUuid();
        MemberUpdateInfo updateInfo = TestFixture.createMemberUpdateInfo();

        Member updatedMember = memberRegisterService.update(updateMemberUUID, updateInfo);

        Assertions.assertThat(updatedMember.getUuid()).isNotNull();
        Assertions.assertThat(updatedMember.getNickname()).isEqualTo(updateInfo.nickname());
        Assertions.assertThat(updatedMember.getPassword()).isEqualTo(updateInfo.password());
    }

    private Member registerMemeber() {
        MemberRegisterInfo request = TestFixture.createMemberRegisterInfo();

        return memberRegisterService.register(request);
    }
}