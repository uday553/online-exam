package com.uday.learning.bean.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@ResponseStatus(HttpStatus.ACCEPTED)
public class ExaminerLoginLoginResponse extends BaseLoginResponse {
    private String token;
}
