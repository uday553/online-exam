package com.uday.learning.controller;

import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.redis.dao.CandidateTokenCacheDao;
import com.uday.learning.service.CandidateTestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate/v1")
public class CandidateTestController {

    Logger log = LoggerFactory.getLogger(CandidateTestController.class);

    @Autowired
    CandidateTestServiceImpl candidateTestService;

    @GetMapping("/v1/{currentQuestion}/next")
    public BaseLoginResponse getNextQuestion(@PathVariable("currentQuestion") final String currentQuestion, @RequestHeader("token") String token)
    {
        return null;
    }

    @PostMapping("/v1{answer")
    public Boolean delete(@RequestBody List<String> answer, @RequestHeader("token") String token) {
        return null;
    }

    @GetMapping("/v1/submit")
    public CandidateTokenCacheDao findById(@RequestHeader("token") final String token) {
        return null;
    }

}
