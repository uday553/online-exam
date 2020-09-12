package com.uday.learning.service;

import com.uday.learning.bean.request.ExaminerLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.bean.response.ExaminerLoginFailedLoginResponse;
import com.uday.learning.bean.response.ExaminerLoginLoginResponse;
import com.uday.learning.dao.Examinar;
import com.uday.learning.dao.repository.ExaminarRepository;
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

    @Override
    public BaseLoginResponse login(Object req)
    {
        ExaminerLoginRequest request =(ExaminerLoginRequest)req;
        if(request!=null && request.getUserId()!=null)
        {
            String password = securityUtils.getHash(request.getPassword());
            Examinar examinar = examinarRepository.findByEmailIdAndPassword(request.getUserId(),password);//, ExaminarStatus.ACTIVE);
            //Examinar examinar = examinarRepository.findByEmailIAndPasswordAndStatus(request.getUsername(),password, ExaminarStatus.ACTIVE);
            if(examinar!=null)
            {
                String token = securityUtils.getToken(request);
                return new ExaminerLoginLoginResponse(token);
            }
        }
        return new ExaminerLoginFailedLoginResponse("Authentiion failed");
    }
}
