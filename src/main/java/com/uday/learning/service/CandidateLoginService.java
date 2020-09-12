package com.uday.learning.service;

import com.uday.learning.bean.request.CandidateLoginRequest;
import com.uday.learning.bean.response.BaseLoginResponse;
import com.uday.learning.bean.response.ExaminerLoginFailedLoginResponse;
import com.uday.learning.bean.response.ExaminerLoginLoginResponse;
import com.uday.learning.dao.CandidateAuth;
import com.uday.learning.dao.repository.CandidateAuthRepository;
import com.uday.learning.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateLoginService  implements  LoginService{
    Logger log = LoggerFactory.getLogger(CandidateLoginService.class);

    @Autowired
    SecurityUtils securityUtils;

    @Autowired
    CandidateAuthRepository candidateAuthRepository;

    @Override
    public BaseLoginResponse login(Object req)
    {
        CandidateLoginRequest request =(CandidateLoginRequest)req;
        if(request!=null && request.getUserId()!=null)
        {
            String password = securityUtils.getHash(request.getPassword());
            CandidateAuth candidateAuth = candidateAuthRepository.findByEmailIdAndTestIdAndPassword(request.getUserId(),request.getTestId(),password);//, ExaminarStatus.ACTIVE);
            //Examinar examinar = examinarRepository.findByEmailIAndPasswordAndStatus(request.getUsername(),password, ExaminarStatus.ACTIVE);
            if(candidateAuth!=null)
            {
                String token = securityUtils.getToken(request);
                return new ExaminerLoginLoginResponse(token);
            }
        }
        return new ExaminerLoginFailedLoginResponse("Authentiion failed");
    }
}
