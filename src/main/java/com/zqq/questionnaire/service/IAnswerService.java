package com.zqq.questionnaire.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zqq.questionnaire.pojo.Answer;

import java.util.List;

public interface IAnswerService {

    void insertOne(Answer answer);

    Boolean existWorkerId(Long workerId);

    List<Answer> showByWorkerId(Long workerId);

    List<Answer> showByCategory(String categoryName);
}
