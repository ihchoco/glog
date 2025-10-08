package com.ihchoco.glog.member.domain;

import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.util.TestFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
record MemberTest() {

    @Test
    void registerMember(){
        MemberRegisterRequest request = TestFixture.createMemberReigsterRequest();

        Member member = Member.register(request);

        Assertions.assertThat(member).isNotNull();
        Assertions.assertThat(member.getNickname()).isEqualTo(request.nickname());
    }

    @Test
    void registerMember_email_fail() {
        MemberRegisterRequest request = TestFixture.createWrongEmailMemberRegisterRequest();

        Assertions.assertThatThrownBy(() -> Member.register(request))
                .isInstanceOf(IllegalArgumentException.class);

    }

}