package com.ihchoco.glog.member.domain;

import com.ihchoco.glog.member.domain.dto.MemberRegisterRequest;
import com.ihchoco.glog.member.domain.dto.MemberUpdateRequest;
import com.ihchoco.glog.member.domain.vo.Email;
import com.ihchoco.glog.member.domain.vo.MemberType;
import com.ihchoco.glog.member.domain.vo.MemberTypeConverter;
import com.ihchoco.glog.member.domain.vo.Password;
import com.ihchoco.glog.util.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
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

    @Column(name = "MEMBER_ID", unique = true)
    private String memberId;

    @Column(name = "NICKNAME", unique = true)
    private String nickname;

    @Embedded
    private Password password;

    @Embedded
    private Email email;

    @Column(name = "MEMBER_TYPE")
    @Convert(converter = MemberTypeConverter.class)
    private MemberType memberType;

    public static Member register(MemberRegisterRequest memberRegisterRequest) {
        Member member = new Member();

        member.memberId = memberRegisterRequest.memberId();
        member.nickname = memberRegisterRequest.nickname();
        member.password = new Password(memberRegisterRequest.password());
        member.email = new Email(memberRegisterRequest.email());
        member.memberType = memberRegisterRequest.memberType();

        return member;
    }

    public void update(MemberUpdateRequest memberUpdateRequest) {
        this.memberId = memberUpdateRequest.memberId();
        this.nickname = memberUpdateRequest.nickname();
        this.password = new Password(memberUpdateRequest.password());
        this.email = new Email(memberUpdateRequest.email());
        this.memberType = memberUpdateRequest.memberType();
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password.value();
    }

    public String getMemberId() {
        return this.memberId;
    }

    public Email getEmail() {
        return email;
    }
}
