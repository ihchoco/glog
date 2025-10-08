package com.ihchoco.glog.member.adapter.webapi;

import com.ihchoco.glog.member.application.provided.MemberRegisterService;
import com.ihchoco.glog.member.application.provided.dto.MemberRegisterInfo;
import com.ihchoco.glog.member.domain.Member;
import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApi {

    private final MemberRegisterService memberRegisterService;

    public MemberApi(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @PostMapping("/api/v1/members")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterInfo request) {
        Member member = memberRegisterService.register(request);
        MemberRegisterResponse response = MemberRegisterResponse.of(member);

        return ResponseEntity
                .status(HttpStatus.CREATED)  // 생성 성공 상태 코드 지정
                .header("X-Custom-Header", "value") // 필요하면 커스텀 헤더 추가
                .body(response); // 응답 객체 전달
    }


}
