package com.ihchoco.glog.member.domain;

public enum MemberType {

    USER(1, "사용자"),
    ADMIN(2, "관리자");

    private final Integer code;

    private final String description;

    MemberType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
       return code;
    }
}
