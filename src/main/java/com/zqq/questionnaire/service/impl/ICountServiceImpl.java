package com.zqq.questionnaire.service.impl;

import com.zqq.questionnaire.dao.CountRepository;
import com.zqq.questionnaire.pojo.Count;
import com.zqq.questionnaire.service.ICountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Deprecated
public class ICountServiceImpl implements ICountService {

    private CountRepository countRepository;

    @Autowired
    public void setCountRepository(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    @Override
    public int getCount() {
        Count count = countRepository.findById(1L).get();
        return count.getTotal();
    }

    @Override
    @Transactional
    public int incrCount() {
        Count count = countRepository.findById(1L).get();
        count.setTotal(count.getTotal()+1);
        log.info("当前总问卷数 ：" + count.getTotal());
        countRepository.save(count);
        return count.getTotal();
    }
}
