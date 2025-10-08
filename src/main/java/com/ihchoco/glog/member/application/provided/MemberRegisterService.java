package com.ihchoco.glog.member.application.provided;

import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.application.provided.dto.MemberUpdateInfo;
import com.ihchoco.glog.member.application.required.MemberRepository;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;
import com.ihchoco.glog.util.service.RecordConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberRegisterService implements MemberRegister {

    private final MemberRepository memberRepository;

    public MemberRegisterService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(MemberRegisterInfo memberRegisterInfo) {
        MemberRegisterRequest request = RecordConvertUtil.convert(memberRegisterInfo, MemberRegisterRequest.class);

        Member member = Member.register(request);

        memberRepository.save(member);

        return member;
    }

    @Override
    public Member update(String memberUuid, MemberUpdateInfo memberUpdateInfo) {
        MemberUpdateRequest request = RecordConvertUtil.convert(memberUpdateInfo, MemberUpdateRequest.class);

        Member member = memberRepository.findByUuid(memberUuid)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] Member Has Not Founded By UUID :" + memberUuid));

        member.update(request);

        return member;
    }
}
