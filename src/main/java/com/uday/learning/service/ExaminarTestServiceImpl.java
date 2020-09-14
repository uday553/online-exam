package com.uday.learning.service;

import com.uday.learning.bean.response.TestListResponse;
import com.uday.learning.controller.ExaminerTestController;
import com.uday.learning.dao.Test;
import com.uday.learning.dao.TestStatus;
import com.uday.learning.dao.redis.ExaminerTokenCacheDao;
import com.uday.learning.dao.repository.TestRepository;
import com.uday.learning.dao.repository.redis.ExaminarTokenCacheRepository;
import com.uday.learning.exception.NotAuthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminarTestServiceImpl implements ExaminarTestService {
    Logger log = LoggerFactory.getLogger(ExaminarTestServiceImpl.class);
    @Autowired
    ExaminarTokenCacheRepository examinarTokenCacheRepository;

    @Autowired
    TestRepository testRepository;

    @Override
    public TestListResponse getTestList(String token)
    {
        log.info("TestListResponse {}",token);
        ExaminerTokenCacheDao examinerTokenCacheDao = examinarTokenCacheRepository.findById(token);
        if (examinerTokenCacheDao!=null)
        {
            return new TestListResponse(testRepository.findByCreatedByAndStatus(examinerTokenCacheDao.getExaminarId(), TestStatus.ACTIVE.ordinal()));
        }
        throw  new NotAuthorizedException("You are not authorized");
    }
}
