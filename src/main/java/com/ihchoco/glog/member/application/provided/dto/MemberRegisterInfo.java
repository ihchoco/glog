package com.ihchoco.glog.member.application.provided.dto;

import com.ihchoco.glog.member.domain.MemberType;

public record MemberRegisterInfo(
         String memberId,
         String nickname,
         String password,
         String email,
         MemberType memberType
) {
}
