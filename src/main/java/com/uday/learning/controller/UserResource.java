package com.uday.learning.controller;

import com.uday.learning.dao.repository.redis.CandidateTokenCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    CandidateTokenCacheRepository candidateTokenCacheRepository;


//    @GetMapping("/add/{testId}/{lastAttemptedQuestion}")
//    public ExamCacheDao add(@PathVariable("id") final String testId, @PathVariable("lastAttemptedQuestion") final int lastAttemptedQuestion) {
//        examCacheRepository.save(new ExamCacheDao(testId,lastAttemptedQuestion));
//        return examCacheRepository.findById(testId);
//    }
//
//    @GetMapping("/update/{testId}/{lastAttemptedQuestion}")
//    public ExamCacheDao update(@PathVariable("testId") String  token, @PathVariable("lastAttemptedQuestion") final int lastAttemptedQuestion) {
//        examCacheRepository.save(new ExamCacheDao(token,lastAttemptedQuestion));
//        return examCacheRepository.findById(testId);
//    }





}
