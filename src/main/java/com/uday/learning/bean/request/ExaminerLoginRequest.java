package com.uday.learning.bean.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExaminerLoginRequest extends BaseLoginRequest{
    private String userId;
    private String password;
}
