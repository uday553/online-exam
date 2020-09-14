package com.uday.learning.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class CandidateAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int testId;
    private String emailId;
    private String password;
    private int status;
    private Date createdAt;
    private Date expiredAt;
}
