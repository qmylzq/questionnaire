package com.zqq.questionnaire.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "classification_result")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "bg_index")
    private int bgIndex;

    @Column(name = "fg_index")
    private int fgIndex;

    // 答案 3 match well; 2 probably match; 1 probably not match; 0 doesn't match
    @Column(name = "level_of_performance")
    private int answer;

    // 作答持续时间
    @Column(name = "duration")
    private long duration;

    // 试卷编号
    @Column(name = "worker_id")
    private long workerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBgIndex() {
        return bgIndex;
    }

    public void setBgIndex(int bgIndex) {
        this.bgIndex = bgIndex;
    }

    public int getFgIndex() {
        return fgIndex;
    }

    public void setFgIndex(int fgIndex) {
        this.fgIndex = fgIndex;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
}
