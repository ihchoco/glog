package com.ihchoco.glog.util.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // 예: 스프링 시큐리티에서 인증된 사용자 ID 반환
        return Optional.of("system"); // 테스트용 기본값 또는 actual user id 반환
    }
}
