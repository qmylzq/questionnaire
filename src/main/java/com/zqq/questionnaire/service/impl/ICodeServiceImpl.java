package com.zqq.questionnaire.service.impl;

import com.zqq.questionnaire.dao.VerifyCodeRepository;
import com.zqq.questionnaire.pojo.VerifyCode;
import com.zqq.questionnaire.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICodeServiceImpl implements ICodeService {

    private VerifyCodeRepository codeRepository;

    @Autowired
    public void setCodeRepository(VerifyCodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public String getCodeByWorkerId(Long workerId) {
        VerifyCode previous = codeRepository.findByWorkerId(workerId);
        // 已经获取过 verify code
        if (previous != null){
            return previous.getCode();
        }
        return null;
    }

    @Override
    public void saveCode(Long workerId, String code) {
        VerifyCode newCode = new VerifyCode();
        newCode.setWorkerId(workerId);
        newCode.setCode(code);
        codeRepository.save(newCode);
    }
}
