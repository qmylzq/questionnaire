package com.zqq.questionnaire.dao;

import com.zqq.questionnaire.pojo.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends JpaRepository<Count, Long> {
}
