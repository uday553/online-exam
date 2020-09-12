package com.uday.learning.bean.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.FORBIDDEN)
@AllArgsConstructor
@ToString
public class ExaminerLoginFailedLoginResponse extends BaseLoginResponse {
    private String token;
}
