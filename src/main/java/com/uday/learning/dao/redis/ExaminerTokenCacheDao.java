package com.uday.learning.dao.redis;

import lombok.*;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ExaminerTokenCacheDao extends Base {
    private String token;
    private int examinarId;
    private Date createdAt;
    public ExaminerTokenCacheDao(String token, int examinarId)
    {
        this.examinarId=examinarId;
        this.token=token;
        createdAt= Calendar.getInstance().getTime();
    }
}
