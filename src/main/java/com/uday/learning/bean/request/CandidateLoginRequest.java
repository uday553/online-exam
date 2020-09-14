package com.uday.learning.bean.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CandidateLoginRequest extends BaseLoginRequest{
    private String userId;
    private String password;
    private int lastAttemptedQuestion;
    private int testId;
}
