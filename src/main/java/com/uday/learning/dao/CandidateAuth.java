package com.uday.learning.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class CandidateAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int testId;
    private String emailId;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private CandidateStatus status;
    private Date createdAt;
    private Date expiredAt;
}
