package com.uday.learning.redis.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamCacheDao extends Base implements Serializable {
    private String testId;
    private int lastAttemptedQuestion;
    private String token;

    public ExamCacheDao(String testId,int lastAttemptedQuestion,String token)
    {
        this.testId=testId;
        this.lastAttemptedQuestion=lastAttemptedQuestion;
        this.token=token;
    }
}
