package com.uday.learning.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Examinar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String emailId;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private ExaminarStatus status;

    private Date createdAt;

}
