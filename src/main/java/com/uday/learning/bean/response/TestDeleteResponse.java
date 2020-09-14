package com.uday.learning.bean.response;

import com.uday.learning.dao.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@Setter
@ResponseStatus(HttpStatus.OK)
@AllArgsConstructor
@NoArgsConstructor
public class TestDeleteResponse {
    public String msg;
}
