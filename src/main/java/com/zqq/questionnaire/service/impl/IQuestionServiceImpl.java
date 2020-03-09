package com.zqq.questionnaire.service.impl;

import com.zqq.questionnaire.init.Globals;
import com.zqq.questionnaire.pojo.BgFgPairs;
import com.zqq.questionnaire.pojo.QuestionPaper;
import com.zqq.questionnaire.pojo.SingleTest;
import com.zqq.questionnaire.service.ICountService;
import com.zqq.questionnaire.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IQuestionServiceImpl implements IQuestionService {

    private Environment env;

    @Override
    // 分发试卷，每张试卷3题
    public QuestionPaper dispatchTestPaper() {
        int count = Globals.COUNTPERPAPER;
        QuestionPaper paper = new QuestionPaper();
        paper.setSheetIndex(System.currentTimeMillis());
        System.out.println("问卷编号："+paper.getSheetIndex());

        // 随机抽count道题目，不重复
        Set<Integer> idxs = new HashSet<>();
        int total = Globals.QUESTIONS.size();//来自mapping-file
        Random random = new Random();
        //确定试题编号
        while (idxs.size() < count){
            idxs.add(random.nextInt(total));
        }

        List<QuestionPaper.SingleBg> bgs = new ArrayList<>();
        for (Integer idx: idxs) {
            BgFgPairs one = Globals.QUESTIONS.get(idx);
            // 生成单个大题
            QuestionPaper.SingleBg bg = new QuestionPaper.SingleBg();
            String thisCategory = one.getCategory();
            int thisBgIndex = one.getBgIndex();
            bg.setCategory(thisCategory);
            bg.setBgURL(getBgURL(thisCategory, thisBgIndex));
            bg.setTnURL(getTnURL(thisCategory, one.getTnIndex()));
            // 生成单个大题中的小题
            List<SingleTest> tests = new ArrayList<>();
            List<Integer> fgs = one.getFgIndexes();
            Collections.shuffle(fgs);//fgs随机排序
            for (Integer fgIndex : fgs) {
                SingleTest test = new SingleTest();
                test.setFgCategory(thisCategory);
                test.setBgIndex(one.getBgIndex());
                test.setBgURL(getBgURL(thisCategory, one.getBgIndex()));
                test.setFgIndex(fgIndex);
                test.setFgURL(getFgURL(thisCategory, fgIndex));
                tests.add(test);
//                if (tests.size() == perTest){
//                    break;
//                }
            }
            bg.setTests(tests);
            // 添加一道大题
            bgs.add(bg);
        }
        paper.setPaper(bgs);
        return paper;
    }

    /**
     * 生成背景图访问 url
     */
    private String getBgURL(String category, int bgIndex){
        String url = env.getProperty("access.url");
        return url + String.format(Objects.requireNonNull(env.getProperty("access.bgURLf")), bgIndex);
    }

    /**
     * 生成前景图访问 url
     */
    private String getFgURL(String category, int fgIndex){
        String url = env.getProperty("access.url");
        return url + String.format(Objects.requireNonNull(env.getProperty("access.fgURLf")), fgIndex);
    }

    /**
     * 生成前景缩略图 url
     */
    private String getTnURL(String category, int tnIndex){
        String url = env.getProperty("access.url");
        return url + String.format(Objects.requireNonNull(env.getProperty("access.tnURLf")), tnIndex);
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
