package com.ihchoco.glog.util;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.domain.MemberType;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;

public record TestFixture() {

    public static MemberRegisterInfo createMemberRegisterInfo() {
        return new MemberRegisterInfo(
                "qkrrldus93",
                "차가운핫초코",
                "1234",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static MemberRegisterRequest createMemberReigsterRequest() {
        return new MemberRegisterRequest(
                "qkrrldus93",
                "차가운핫초코",
                "1234",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static MemberUpdateRequest createMemberUpdateRequest() {
        return new MemberUpdateRequest(
                "icehot",
                "차가운핫초코",
                "1234",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

}
