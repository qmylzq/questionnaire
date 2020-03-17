package com.zqq.questionnaire.dao;

import com.zqq.questionnaire.pojo.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByWorkerId(long workerId);
    List<Answer> findByCategory(String categoryName);

}
