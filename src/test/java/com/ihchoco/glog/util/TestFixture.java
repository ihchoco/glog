package com.ihchoco.glog.util;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.application.provided.dto.MemberUpdateInfo;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.vo.MemberType;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;

public record TestFixture() {

    public static MemberRegisterInfo createMemberRegisterInfo() {
        return new MemberRegisterInfo(
                "qkrrldus93",
                "차가운핫초코",
                "12345678",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static MemberRegisterRequest createMemberReigsterRequest() {
        return new MemberRegisterRequest(
                "qkrrldus93",
                "차가운핫초코",
                "12345678",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static MemberRegisterRequest createWrongEmailMemberRegisterRequest() {
        return new MemberRegisterRequest(
                "qkrrldus93",
                "차가운핫초코",
                "12345678",
                "qkrrldus93g@gmail",
                MemberType.ADMIN
        );
    }

    public static MemberUpdateInfo createMemberUpdateInfo() {
        return new MemberUpdateInfo(
                "icehot",
                "차가운핫초코2",
                "11112222",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static MemberUpdateRequest createMemberUpdateRequest() {
        return new MemberUpdateRequest(
                "icehot",
                "차가운핫초코",
                "12345678",
                "qkrrldus93g@gmail.com",
                MemberType.ADMIN
        );
    }

    public static Member createMember() {
        MemberRegisterRequest request = createMemberReigsterRequest();
        return Member.register(request);
    }
}
