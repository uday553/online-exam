package com.uday.learning.bean.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class CandidateLoginLoginResponse extends BaseLoginResponse {
    private String token;
}
