package com.uday.learning.service;

import com.uday.learning.bean.request.CandidateLoginRequest;
import com.uday.learning.bean.response.CandidateLoginLoginResponse;
import com.uday.learning.dao.CandidateAuth;
import com.uday.learning.dao.CandidateStatus;
import com.uday.learning.redis.dao.CandidateTokenCacheDao;
import com.uday.learning.dao.repository.CandidateAuthRepository;
import com.uday.learning.dao.repository.redis.CandidateTokenCacheRepository;
import com.uday.learning.exception.NotAllowedToLoginException;
import com.uday.learning.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CandidateLoginService  implements  LoginService<CandidateLoginRequest, CandidateLoginLoginResponse> {
    Logger log = LoggerFactory.getLogger(CandidateLoginService.class);

    @Autowired
    SecurityUtils securityUtils;

    @Autowired
    CandidateAuthRepository candidateAuthRepository;

    @Autowired
    CandidateTokenCacheRepository candidateTokenCacheRepository;

    @Override
    public CandidateLoginLoginResponse login(CandidateLoginRequest candidateLoginRequest)
    {
        if(candidateLoginRequest!=null && candidateLoginRequest.getUserId()!=null)
        {
            String token = securityUtils.getToken(candidateLoginRequest);
            if(candidateTokenCacheRepository.findById(token)==null ) {
                CandidateAuth candidateAuth = candidateAuthRepository.findByEmailIdAndTestIdAndPasswordAndStatus(candidateLoginRequest.getUserId(), candidateLoginRequest.getTestId(), candidateLoginRequest.getPassword(), CandidateStatus.ACTIVE.ordinal());
                if (candidateAuth != null) {
                    candidateAuth.setStatus(CandidateStatus.INACTIVE.ordinal());
                    candidateAuth.setExpiredAt(Calendar.getInstance().getTime());
                    candidateAuthRepository.save(candidateAuth);
                    candidateTokenCacheRepository.save(new CandidateTokenCacheDao(candidateLoginRequest.getTestId(),token,candidateLoginRequest.getLastAttemptedQuestion(),candidateLoginRequest.getUserId()));
                    return new CandidateLoginLoginResponse(token);
                }
            }
            throw  new NotAllowedToLoginException("Already Loggedin");
        }
        throw  new NotAllowedToLoginException("Authentication Falied");
    }

    public Boolean delete( String token) {
        candidateTokenCacheRepository.delete(token);
        return true;
    }

    public CandidateTokenCacheDao findById( String token) {
        return candidateTokenCacheRepository.findById(token);
    }

    public Boolean hasToken(String token) {
        return candidateTokenCacheRepository.hasKey(token);
    }
}
