package com.zqq.questionnaire.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "verify_code")
public class VerifyCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "verify_code")
    private String code;
}
