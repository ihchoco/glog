package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.application.required.MemberRepository;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.util.service.RecordConvertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberRegisterService implements MemberRegister {

    private final MemberRepository memberRepository;

    @Override
    public Member register(MemberRegisterInfo memberRegisterInfo) {
        MemberRegisterRequest request = RecordConvertUtil.convert(memberRegisterInfo, MemberRegisterRequest.class);

        Member member = Member.register(request);

        memberRepository.save(member);

        return member;
    }
}
