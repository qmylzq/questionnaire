package com.zqq.questionnaire.dao;

import com.zqq.questionnaire.pojo.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, Long> {

    VerifyCode findByWorkerId(Long workerId);
}
