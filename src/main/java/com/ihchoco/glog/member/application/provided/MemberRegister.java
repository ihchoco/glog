package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.domain.Member;

public interface MemberRegister {

    Member register(MemberRegisterInfo memberRegisterInfo);

}
