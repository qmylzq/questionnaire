package com.zqq.questionnaire.controller;

import com.zqq.questionnaire.pojo.QuestionPaper;
import com.zqq.questionnaire.service.IQuestionService;
import com.zqq.questionnaire.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    private IQuestionService questionService;

    @Autowired
    public void setQuestionService(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/paper", method = RequestMethod.GET)//用get方法处理请求
    public QuestionPaper dispatchPaper(HttpServletRequest request){
        log.info("收到请求 /question/paper");
        log.info("from: " + GeneralUtil.getIpAddr(request));
        return questionService.dispatchTestPaper();
    }

}
