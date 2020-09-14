//package com.uday.learning.controller;
//
//import com.uday.learning.dao.redis.ExamCacheDao;
//import com.uday.learning.dao.repository.redis.BaseRepository;
//import com.uday.learning.dao.repository.redis.ExamCacheRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/examinar/v1")
//public class ExaminerTestController {
//
//    @Autowired
//    BaseRepository<String, ExamCacheDao> redisRepository;
//
//    @Autowired
//    ExamCacheRepository userRepository;
//
//    @GetMapping("/add/{id}/{lastAttemptedQuestion}")
//    public ExamCacheDao add(@PathVariable("id") final String examID, @PathVariable("lastAttemptedQuestion") final int lastAttemptedQuestion) {
//        userRepository.save(new ExamCacheDao(examID,lastAttemptedQuestion));
//        return redisRepository.findById(examID);
//    }
//
//    @GetMapping("/update/{id}/{lastAttemptedQuestion}")
//    public ExamCacheDao update(@PathVariable("id") final String examID, @PathVariable("lastAttemptedQuestion") final int lastAttemptedQuestion) {
//        userRepository.save(new ExamCacheDao(examID,lastAttemptedQuestion));
//        return redisRepository.findById(examID);
//    }
//
//    @GetMapping("/delete/{id}")
//    public Boolean delete(@PathVariable("id") final String id) {
//        userRepository.delete(id);
//        return true;
//    }
//
//    @GetMapping("/find/{id}")
//    public ExamCacheDao find(@PathVariable("id") final String id) {
//        return userRepository.findById(id);
//    }
//}
