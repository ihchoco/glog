package com.ihchoco.glog.member.application.required;

import com.ihchoco.glog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 회원 정보를 저장하거나 조회한다
 */
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByUuid(String uuid);
}
