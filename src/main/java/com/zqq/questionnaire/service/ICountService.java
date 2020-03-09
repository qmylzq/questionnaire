package com.zqq.questionnaire.service;

@Deprecated
public interface ICountService {

    // 获取已发放的问卷数
    int getCount();

    // 当前已发放的问卷数 +1
    int incrCount();
}
