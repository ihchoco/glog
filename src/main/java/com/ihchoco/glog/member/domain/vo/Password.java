package com.ihchoco.glog.member.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Password(
        @Column(name = "password")
        String value
) {

    public Password {
        if (value == null || value.length() < 8) {
            throw new IllegalArgumentException("[ERROR] Password must not be null and must be at least 8 characters long.");
        }
    }
}
