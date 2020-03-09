package com.zqq.questionnaire.init;

import com.zqq.questionnaire.pojo.BgFgPairs;
import lombok.extern.slf4j.Slf4j;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Slf4j
@Component
// CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，SpringApplication.run() 之前执行
// 需要执行的任务放在run方法里面
public class InitQuestions implements CommandLineRunner {

    @Value(value="classpath:mapping_file")
    private Resource resource;

    @Override
    public void run(String... args) throws Exception {
        String file_path = "E:\\ideaIU\\tomcat\\apache-tomcat-8.5.50\\webapps\\proj\\questionnaire\\questionnaire\\src\\main\\resources\\mapping_file";
        File file = new File(file_path);
        // 读取txt文件，将 group 数据存到 list 里
        BufferedReader br = null;
        try {//两种方法读取mapping文件
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            // br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            // 第一行是表头，去掉
            br.readLine();
            String current = null;
            while ((current = br.readLine()) != null) {
                if (current.length() != 0) {
                    String[] splits = current.trim().split(",");
                    BgFgPairs pair = new BgFgPairs();
                    pair.setIndex(Integer.parseInt(splits[0].trim()));
                    pair.setBgIndex(Integer.parseInt(splits[1].trim()));
                    pair.setCategory(splits[2].trim());
                    pair.setTnIndex(pair.getIndex());
                    ArrayList<Integer> fgIndexs = new ArrayList<>();
                    String fg_list = splits[3].trim();
                    fg_list = fg_list.substring(2, fg_list.length()-2);
                    String[] fgs = fg_list.split(" ");
                    for (String fg : fgs) {
                        if (fg != null && fg.length() > 0) {
                            fgIndexs.add(Integer.parseInt(fg.trim()));
                        }
                    }
                    pair.setFgIndexes(fgIndexs);
                    Globals.QUESTIONS.add(pair);
                }
            }
            log.info("读取文件成功");
            System.out.println(Globals.QUESTIONS);
        } catch (Exception e) {
            log.info("读取 group 文件失败");
            log.info("成功读取行数" + Globals.QUESTIONS.size());
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
    }
}
