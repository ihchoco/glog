package com.ihchoco.glog.member.adapter.webapi;

import com.ihchoco.glog.member.domain.Member;

public record MemberRegisterResponse(
    String memberUuid,
    String memberId,
    String nickname,
    String email
) {

    public static MemberRegisterResponse of(Member member) {
        return new MemberRegisterResponse(
                member.getUuid(),
                member.getMemberId(),
                member.getNickname(),
                member.getEmail().address());

    }
}
