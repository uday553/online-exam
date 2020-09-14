package com.uday.learning.controller;

import com.uday.learning.bean.request.CandidateLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.dao.redis.CandidateTokenCacheDao;
import com.uday.learning.service.CandidateLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/candidate")
public class CandidateLoginController {
    Logger log = LoggerFactory.getLogger(CandidateLoginController.class);

    @Autowired
    CandidateLoginService candidateLoginService;

    @RequestMapping("/v1/login")
    public BaseLoginResponse login(@RequestBody CandidateLoginRequest candidateLoginRequest)
    {
        log.info(">>>>>>>>{}",candidateLoginService);
        return candidateLoginService.login(candidateLoginRequest);
    }

    @GetMapping("/v1/delete/{token}")
    public Boolean delete(@PathVariable("token") final String token) {
        candidateLoginService.delete(token);
        return true;
    }

    @GetMapping("/v1/find")
    public CandidateTokenCacheDao findById(@RequestHeader("token") final String token) {
        log.info("token >>> {}",token);
        return candidateLoginService.findById(token);
    }
}
