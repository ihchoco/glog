package com.ihchoco.glog.member.domain.dto;

import com.ihchoco.glog.member.domain.MemberType;

public record MemberRegisterRequest(
         String memberId,
         String nickname,
         String password,
         String email,
         MemberType memberType
) {
}
