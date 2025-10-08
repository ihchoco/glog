package com.ihchoco.glog.member.domain;

import com.ihchoco.glog.member.domain.vo.Email;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

record EmailTest () {

    @Test
    void registerEmail(){
        String emailAddress = "qkrrldus93@gmail.com";
        Email email = new Email(emailAddress);

        Assertions.assertThat(email.address()).isEqualTo(emailAddress);
    }

    @Test
    void registerEmail_fail(){
        String emailAddress = "gmail.com";

        Assertions.assertThatThrownBy(() -> new Email(emailAddress))
                .isInstanceOf(IllegalArgumentException.class);
    }

}