package com.uday.learning.bean.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.FORBIDDEN)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExaminerLoginFailedLoginResponse extends BaseLoginResponse {
    private String token;
}
