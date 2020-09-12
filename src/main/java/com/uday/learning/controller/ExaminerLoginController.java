package com.uday.learning.controller;

import com.uday.learning.bean.request.BaseLoginRequest;
import com.uday.learning.bean.request.ExaminerLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/examinar")
public class ExaminerLoginController {

    Logger log = LoggerFactory.getLogger(ExaminerLoginController.class);

    @Autowired
    LoginService<BaseLoginRequest, BaseLoginResponse> examinarLoginService;

    @RequestMapping("/v1/login")
    public BaseLoginResponse login(@RequestBody ExaminerLoginRequest request)
    {
        return examinarLoginService.login(request);
    }
}
