package com.blog.repository;

import com.blog.model.CaptchaCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface CaptchaRepository extends JpaRepository<CaptchaCodes, Integer> {
    long countBySecretCodeAndCode(String secretCode, String code);
    void deleteByTimeBefore(Instant time);
}
