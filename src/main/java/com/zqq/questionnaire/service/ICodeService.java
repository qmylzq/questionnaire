package com.zqq.questionnaire.service;

public interface ICodeService {

    // 查询workerId的code
    String getCodeByWorkerId(Long workerId);

    // 存储一条新的code
    void saveCode(Long workerId, String code);
}
