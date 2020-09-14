package com.uday.learning.controller;

import com.uday.learning.bean.request.ExaminerLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.redis.dao.ExaminerTokenCacheDao;
import com.uday.learning.service.ExaminarLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examinar")
public class ExaminerLoginController {

    Logger log = LoggerFactory.getLogger(ExaminerLoginController.class);

    @Autowired
    ExaminarLoginService examinarLoginService;

    @RequestMapping("/v1/login")
    public BaseLoginResponse login(@RequestBody ExaminerLoginRequest request)
    {
        return examinarLoginService.login(request);
    }

    @GetMapping("/v1/signout")
    public Boolean delete(@RequestHeader("token") final String token) {
        examinarLoginService.delete(token);
        return true;
    }

    @GetMapping("/v1/find")
    public ExaminerTokenCacheDao findById(@RequestHeader("token") final String token) {
        log.info("token >>> {}",token);
        return examinarLoginService.findById(token);
    }
}
