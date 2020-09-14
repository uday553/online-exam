package com.uday.learning.controller;

import com.uday.learning.bean.request.AppendQuestionsRequest;
import com.uday.learning.bean.response.AppendQuestionsResponse;
import com.uday.learning.dao.redis.ExamCacheDao;
import com.uday.learning.dao.repository.redis.BaseRepository;
import com.uday.learning.dao.repository.redis.ExamCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examinar/test")
public class ExaminerTestController {

    @Autowired
    BaseRepository<String, ExamCacheDao> redisRepository;

    @Autowired
    ExamCacheRepository userRepository;

    @GetMapping("/list")
    public ExamCacheDao add(@RequestHeader("token") String token ) {
        return  null;
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
        return userRepository.findById(id);
    }
}
