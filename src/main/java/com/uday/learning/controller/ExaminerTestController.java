package com.uday.learning.controller;

import com.uday.learning.bean.request.AppendQuestionsRequest;
import com.uday.learning.bean.request.TestAssignRequest;
import com.uday.learning.bean.response.AppendQuestionsResponse;
import com.uday.learning.bean.response.TestAssignResponse;
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

import java.util.Calendar;
import java.util.List;

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


    @GetMapping("{testId}/append/questions/")
    public AppendQuestionsResponse addQuestionsToTest(@PathVariable("testId") final String testId, @RequestBody AppendQuestionsRequest appendQuestionsRequest) {

        return null;
    }

    @GetMapping("/fetch/{id}")
    public TestListResponse find(@PathVariable("id") final int  id,@RequestHeader("token") String token ) {
        return examinarTestService.getTest(token,id);
    }

    @PostMapping("/assign")
    public TestAssignResponse assignTest(@RequestHeader("token") final String token ,
                                            @RequestBody TestAssignRequest testAssignRequest
    ) {
        return examinarTestService.assignTest(token,testAssignRequest );
    }

}
