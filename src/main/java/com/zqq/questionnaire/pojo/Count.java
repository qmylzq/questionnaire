package com.zqq.questionnaire.pojo;

import lombok.Data;

import javax.persistence.*;

// 记录已发放的问卷数
@Data
@Entity
@Table(name = "counter")
public class Count {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int total;
}
