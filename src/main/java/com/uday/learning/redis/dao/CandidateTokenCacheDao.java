package com.uday.learning.redis.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CandidateTokenCacheDao extends Base {
    private String token;
    private int testId;
    private int lastAttemptedQuestion;
    private String userId;
    public CandidateTokenCacheDao(String token)
    {
        this.token=token;
        setCreatedAt(Calendar.getInstance().getTime());
    }
    public CandidateTokenCacheDao(int testId)
    {
        this.testId=testId;
        setCreatedAt(Calendar.getInstance().getTime());
    }
    public CandidateTokenCacheDao(int testId, String token,int lastAttemptedQuestion,String userId)
    {
        this.testId=testId;
        this.token=token;
        this.lastAttemptedQuestion = lastAttemptedQuestion;
        this.userId=userId;
        setCreatedAt(Calendar.getInstance().getTime());
    }
}
