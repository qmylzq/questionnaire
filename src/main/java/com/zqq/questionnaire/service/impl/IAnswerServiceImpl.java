package com.zqq.questionnaire.service.impl;

import com.zqq.questionnaire.dao.AnswerRepository;
import com.zqq.questionnaire.pojo.Answer;
import com.zqq.questionnaire.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig
public class IAnswerServiceImpl implements IAnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void insertOne(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Boolean existWorkerId(Long workerId) {
        return answerRepository.findByWorkerId(workerId) != null;
    }
    @Override
    public List<Answer> showByWorkerId(Long workerId){
        return answerRepository.findByWorkerId(workerId);
    }
    @Override
    public List<Answer> showByCategory(String categoryName){
        return answerRepository.findByCategory(categoryName);
    }

}
