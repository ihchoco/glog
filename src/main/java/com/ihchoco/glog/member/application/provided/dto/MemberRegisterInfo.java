package com.ihchoco.glog.member.application.provided.dto;

import com.ihchoco.glog.member.domain.vo.MemberType;
import jakarta.validation.constraints.NotNull;

public record MemberRegisterInfo(
         @NotNull String memberId,
         @NotNull String nickname,
         @NotNull String password,
         @NotNull String email,
         @NotNull MemberType memberType
) {
}
