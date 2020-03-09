package com.zqq.questionnaire.pojo;

import lombok.Data;

import java.util.List;

@Data
public class BgFgPairs {
    private Integer index;
    // bg编号
    private Integer bgIndex;
    // fg类别
    private String category;
    // fg缩略图编号
    private Integer tnIndex;
    // 一个bg对应的所有fg
    private List<Integer> fgIndexes;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBgIndex() {
        return bgIndex;
    }

    public void setBgIndex(Integer bgIndex) {
        this.bgIndex = bgIndex;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getTnIndex() {
        return tnIndex;
    }

    public void setTnIndex(Integer tnIndex) {
        this.tnIndex = tnIndex;
    }

    public List<Integer> getFgIndexes() {
        return fgIndexes;
    }

    public void setFgIndexes(List<Integer> fgIndexes) {
        this.fgIndexes = fgIndexes;
    }
}
