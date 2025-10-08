package com.ihchoco.glog.member.domain;

import com.ihchoco.glog.member.domain.vo.Password;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

record PasswordTest () {

    @Test
    void registerPassword(){
        String passwordRequest = "12345678";
        Password password = new Password(passwordRequest);

        Assertions.assertThat(password.value()).isEqualTo(passwordRequest);
    }

    @Test
    void registerEmail_fail(){
        String passwordRequest = "1234";

        Assertions.assertThatThrownBy(() -> new Password(passwordRequest))
                .isInstanceOf(IllegalArgumentException.class);
    }

}