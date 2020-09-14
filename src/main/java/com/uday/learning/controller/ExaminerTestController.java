package com.uday.learning.controller;

import com.uday.learning.bean.request.AppendQuestionsRequest;
import com.uday.learning.bean.response.AppendQuestionsResponse;
import com.uday.learning.bean.response.TestListResponse;
import com.uday.learning.dao.redis.ExamCacheDao;
import com.uday.learning.dao.repository.redis.BaseRepository;
import com.uday.learning.dao.repository.redis.ExamCacheRepository;
import com.uday.learning.dao.repository.redis.ExaminarTokenCacheRepository;
import com.uday.learning.service.ExaminarLoginService;
import com.uday.learning.service.ExaminarTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examinar/test")
public class ExaminerTestController {
    Logger log = LoggerFactory.getLogger(ExaminerTestController.class);

    @Autowired
    BaseRepository<String, ExamCacheDao> redisRepository;

    @Autowired
    ExaminarTestService examinarTestService;

    @GetMapping("/list")
    public TestListResponse list(@RequestHeader("token") String token ) {
        log.info("List Test >>>>");
        return  examinarTestService.getTestList(token);
    }

    @GetMapping("/delete/{testId}")
    public ExamCacheDao update(@PathVariable("testId") final int testId, @RequestHeader("token") String token ) {
        return null;
    }

    @GetMapping("{testId}/append/questions/")
    public AppendQuestionsResponse addQuestionsToTest(@PathVariable("testId") final String testId, @RequestBody AppendQuestionsRequest appendQuestionsRequest) {

        return null;
    }

    @GetMapping("/fetch/{id}")
    public ExamCacheDao find(@PathVariable("id") final String id) {
        return null;
    }

    @PostMapping("/fetch/{id}")
    public ExamCacheDao assignTest(@RequestHeader("token") final String token) {
        return null;
    }

}
