package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.application.provided.dto.MemberUpdateInfo;
import com.ihchoco.glog.member.domain.Member;
import jakarta.validation.Valid;

public interface MemberRegister {

    Member register(@Valid MemberRegisterInfo memberRegisterInfo);

    Member update(String memberUuid, @Valid MemberUpdateInfo memberUpdateInfo);

}
