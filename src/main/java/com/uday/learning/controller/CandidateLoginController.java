package com.uday.learning.controller;

import com.uday.learning.bean.request.BaseLoginRequest;
import com.uday.learning.bean.request.CandidateLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login/candidate")
public class CandidateLoginController {
    Logger log = LoggerFactory.getLogger(CandidateLoginController.class);

    @Autowired
    LoginService<BaseLoginRequest, BaseLoginResponse> candidateLoginService;

    @RequestMapping("/v1/login")
    public BaseLoginResponse login(@RequestBody CandidateLoginRequest request)
    {
        log.info(">>>>>>>>{}",request);
        return candidateLoginService.login(request);
    }
}
