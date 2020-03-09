package com.zqq.questionnaire.pojo;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 试卷类
@Data
public class QuestionPaper {

    @Data
    // 一道大题
    public static class SingleBg{
        private String bgURL;
        private String tnURL;
        private String category;
        // 多道小题
        private List<SingleTest> tests;
    }

    // 试卷编号
    private long sheetIndex;
    // 试题内容
    private List<SingleBg> paper;
}
