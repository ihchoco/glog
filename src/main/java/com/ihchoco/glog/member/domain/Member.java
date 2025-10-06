package com.ihchoco.glog.member.domain;

import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;
import com.ihchoco.glog.util.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MEMBER_UUID")
    private String uuid;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MEMBER_TYPE")
    @Convert(converter = MemberTypeConverter.class)
    private MemberType memberType;

    public static Member register(MemberRegisterRequest memberRegisterRequest) {
        Member member = new Member();

        member.memberId = memberRegisterRequest.memberId();
        member.nickname = memberRegisterRequest.nickname();
        member.password = memberRegisterRequest.password();
        member.email = memberRegisterRequest.email();
        member.memberType = memberRegisterRequest.memberType();

        return member;
    }

    public void update(MemberUpdateRequest memberUpdateRequest) {
        this.memberId = memberUpdateRequest.memberId();
        this.nickname = memberUpdateRequest.nickname();
        this.password = memberUpdateRequest.password();
        this.email = memberUpdateRequest.email();
        this.memberType = memberUpdateRequest.memberType();
    }

    public String getUuid() {
        return uuid;
    }
}
