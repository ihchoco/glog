package com.ihchoco.glog.member.domain.dto;

import com.ihchoco.glog.member.domain.vo.MemberType;

public record MemberUpdateRequest(
        String memberId,
        String nickname,
        String password,
        String email,
        MemberType memberType
) {
}
