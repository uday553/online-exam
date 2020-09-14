package com.uday.learning.service;

import com.uday.learning.bean.request.ExaminerLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.bean.response.ExaminerLoginResponse;
import com.uday.learning.dao.Examinar;
import com.uday.learning.dao.ExaminarStatus;
import com.uday.learning.redis.dao.ExaminerTokenCacheDao;
import com.uday.learning.dao.repository.ExaminarRepository;
import com.uday.learning.dao.repository.redis.ExaminarTokenCacheRepository;
import com.uday.learning.exception.NotAllowedToLoginException;
import com.uday.learning.exception.NotAuthorizedException;
import com.uday.learning.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminarLoginService implements  LoginService{
    Logger log = LoggerFactory.getLogger(ExaminarLoginService.class);

    @Autowired
    SecurityUtils securityUtils;

    @Autowired
    ExaminarRepository examinarRepository;

    @Autowired
    ExaminarTokenCacheRepository examinarTokenCacheRepository;

    @Override
    public BaseLoginResponse login(Object req)
    {
        ExaminerLoginRequest request =(ExaminerLoginRequest)req;

        if(request!=null && request.getUserId()!=null && request.getPassword()!=null)
        {
            String token = securityUtils.getToken(request);
            if(examinarTokenCacheRepository.findById(token)==null ) {
                Examinar examinar = examinarRepository.findByEmailIdAndPasswordAndStatus(request.getUserId(), request.getPassword(), ExaminarStatus.ACTIVE.ordinal());
                log.info("Examinar >>>>>> {} ",examinar);
                if(examinar!=null) {
                    examinarTokenCacheRepository.save(new ExaminerTokenCacheDao(token, examinar.getId()));
                    return new ExaminerLoginResponse(token);
                }
                throw  new NotAuthorizedException("Authentication Falied");
            }
        }
        throw  new NotAllowedToLoginException("Authentication Falied");
    }

    public Boolean delete( String token) {
        examinarTokenCacheRepository.delete(token);
        return true;
    }

    public ExaminerTokenCacheDao findById( String token) {
        return examinarTokenCacheRepository.findById(token);
    }

    public Boolean hasToken(String token) {
        return examinarTokenCacheRepository.hasKey(token);
    }
}
