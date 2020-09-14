package com.uday.learning.service;

import com.uday.learning.bean.request.TestAssignRequest;
import com.uday.learning.bean.response.TestAssignResponse;
import com.uday.learning.bean.response.TestListResponse;
import com.uday.learning.dao.CandidateAuth;
import com.uday.learning.dao.CandidateStatus;
import com.uday.learning.dao.Test;
import com.uday.learning.dao.TestStatus;
import com.uday.learning.redis.dao.ExaminerTokenCacheDao;
import com.uday.learning.dao.repository.CandidateAuthRepository;
import com.uday.learning.dao.repository.TestRepository;
import com.uday.learning.dao.repository.redis.ExaminarTokenCacheRepository;
import com.uday.learning.exception.NotAuthorizedException;
import com.uday.learning.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminarTestServiceImpl implements ExaminarTestService {
    Logger log = LoggerFactory.getLogger(ExaminarTestServiceImpl.class);

    @Autowired
    ExaminarTokenCacheRepository examinarTokenCacheRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    CandidateAuthRepository candidateAuthRepository;

    @Autowired
    SecurityUtils securityUtils;

    @Override
    public TestListResponse getTestList(String token)
    {
        ExaminerTokenCacheDao examinerTokenCacheDao = examinarTokenCacheRepository.findById(token);
        if (examinerTokenCacheDao!=null)
        {
            return new TestListResponse(testRepository.findByCreatedByAndStatus(examinerTokenCacheDao.getExaminarId(), TestStatus.ACTIVE.ordinal()));
        }
        throw  new NotAuthorizedException("You are not authorized");
    }

    @Override
    public TestListResponse getTest(String token, int testID) {
        ExaminerTokenCacheDao examinerTokenCacheDao = examinarTokenCacheRepository.findById(token);
        if (examinerTokenCacheDao!=null)
        {
            return new TestListResponse(testRepository.findByIdAndCreatedByAndStatus(testID,examinerTokenCacheDao.getExaminarId(), TestStatus.ACTIVE.ordinal()));
        }
        throw  new NotAuthorizedException("You are not authorized");
    }

    @Override
    public TestAssignResponse assignTest( String token, TestAssignRequest testAssignRequest) {
        ExaminerTokenCacheDao examinerTokenCacheDao = examinarTokenCacheRepository.findById(token);
        log.info("examinerTokenCacheDao >>>>>   {}",examinerTokenCacheDao);
        if (examinerTokenCacheDao!=null && testAssignRequest!=null && testAssignRequest.getCandidates()!=null && testAssignRequest.getCandidates().size()>0)
        {
            List<Test> testList = testRepository.findByIdAndCreatedByAndStatus(testAssignRequest.getTestId(),examinerTokenCacheDao.getExaminarId(), TestStatus.ACTIVE.ordinal());
            if(testList!=null && testList.size()>0 )
            {
                List<CandidateAuth> candidateList = new ArrayList<>();
                Iterator<String> itr = testAssignRequest.getCandidates().iterator();
                while (itr.hasNext())
                {
                    String userId = itr.next();
                    CandidateAuth candidateAuth = new CandidateAuth();
                    candidateAuth.setExpiredAt(testAssignRequest.getExpireDate());
                    candidateAuth.setCreatedAt(Calendar.getInstance().getTime());
                    candidateAuth.setPassword(securityUtils.getHAsh(userId));
                    candidateAuth.setStatus(CandidateStatus.INACTIVE.ordinal());
                    candidateAuth.setAssignStatus(CandidateStatus.INACTIVE.ordinal());
                    candidateAuth.setEmailId(userId);
                    candidateList.add(candidateAuth);
                }
                candidateAuthRepository.saveAll(candidateList);
                return new TestAssignResponse("Assigned succeesully");
            }

        }
        throw  new NotAuthorizedException("You are not authorized");
    }
}
