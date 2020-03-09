package com.zqq.questionnaire.pojo;

import lombok.Data;

// 单个问题
@Data
public class SingleTest {

    // 前景图片类名
    private String fgCategory;
    // 背景图片编号
    private int bgIndex;
    // 背景图片链接
    private String bgURL;
    // 前景图片编号
    private int fgIndex;
    // 前景图片链接
    private String fgURL;
}
