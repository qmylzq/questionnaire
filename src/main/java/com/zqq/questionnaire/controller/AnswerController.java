package com.zqq.questionnaire.controller;

import com.zqq.questionnaire.pojo.Answer;
import com.zqq.questionnaire.service.IAnswerService;
import com.zqq.questionnaire.service.ICodeService;
import com.zqq.questionnaire.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/answer")
public class AnswerController {

    private IAnswerService answerService;
    private ICodeService codeService;
    private final Base64.Encoder base64Encoder = Base64.getEncoder();

    @Autowired
    public void setAnswerService(IAnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setCodeService(ICodeService codeService) {
        this.codeService = codeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAnswer(@RequestBody HashMap<String, String> data, HttpServletRequest request) {
        log.info("/answer/add 收到参数：" + data.toString());
        log.info("from: " + GeneralUtil.getIpAddr(request));
        long sheetIndex = Long.parseLong(data.get("sheetIndex"));
        String category = data.get("category");
        int bgIndex = Integer.parseInt(data.get("bgIndex"));
        int fgIndex = Integer.parseInt(data.get("fgIndex"));
        int answer = Integer.parseInt(data.get("answer"));
        long duration = Long.parseLong(data.get("duration")) / 1000;
        Answer res = new Answer();
        res.setWorkerId(sheetIndex);
        res.setCategory(category);
        res.setBgIndex(bgIndex);
        res.setFgIndex(fgIndex);
        res.setAnswer(answer);
        res.setDuration(duration);
        try {//向数据表中插入一条记录
            answerService.insertOne(res);
        } catch (Exception e) {
            log.info("保存失败");
            log.error("保存答案请求失败");
            return "failed";
        }
        log.info("保存成功");
        return "success";
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public Map<String, Object> getCode(@RequestBody HashMap<String, String> data, HttpServletRequest request) {
        log.info("/answer/code 收到参数: " + data.toString());
        log.info("from: " + GeneralUtil.getIpAddr(request));
        Map<String, Object> resData = new HashMap<>();
        try {
            Long workerId = Long.parseLong(data.get("sheetIndex"));
            System.out.println("workerId = " + workerId);
            String preCode = codeService.getCodeByWorkerId(workerId);
            if (preCode != null) {
                resData.put("isRepeated", true);
                resData.put("code", preCode);
            } else {
                // 防止白嫖
                if (!answerService.existWorkerId(workerId)) {
                    resData.put("code", "please finish the questionnaire first!");
                    return resData;
                }
                // 生成 code ip#workerId#timestamp 的base64编码
                String ip = GeneralUtil.getIpAddr(request);
                Long timestamp = System.currentTimeMillis();
                String code = String.format("%s#%d#%d", ip, workerId, timestamp);
                code = base64Encoder.encodeToString(code.getBytes(StandardCharsets.UTF_8));
                System.out.println("生成的 code： " + code);
                codeService.saveCode(workerId, code);
                resData.put("isRepeated", false);
                resData.put("code", code);
            }
            return resData;
        } catch (Exception e) {
            log.error(e.toString());
            resData.put("code", "wrong parameter");
            return resData;
        }
    }
    @RequestMapping(value = "/showByworker", method = RequestMethod.POST)
    public List<Answer> showByWorkerId(HttpServletRequest request) {
        return answerService.showByWorkerId(Long.parseLong(request.getParameter("worker_id")));
    }
    @RequestMapping(value="/showByCategory",method = RequestMethod.POST)
    public List<Answer> showByCategory(HttpServletRequest request){
        return answerService.showByCategory(request.getParameter("categoryName"));
    }
}
