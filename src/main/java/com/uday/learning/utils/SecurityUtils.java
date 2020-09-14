package com.uday.learning.utils;

import com.uday.learning.bean.request.BaseLoginRequest;
import com.uday.learning.bean.request.CandidateLoginRequest;
import com.uday.learning.bean.request.ExaminerLoginRequest;
import com.uday.learning.config.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Calendar;

@Service
public class SecurityUtils {

    Logger log = LoggerFactory.getLogger(SecurityUtils.class);

    @Autowired
    SecurityConfig securityConfig;

    public String getAESEncryptedData(String data)
    {
        log.info(">>>>>>>>>//////  {}",securityConfig);
        return Encryptors.text(securityConfig.getAesKey(), securityConfig.getAesSalt()).encrypt(data);
    }

    public String getAESDecryptedData(String data)
    {
        return Encryptors.text(securityConfig.getAesKey(), securityConfig.getAesSalt()).decrypt(data);
    }

    public String getHAsh(String data)
    {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder(securityConfig.getAesSalt());
        return encoder.encode(data);
    }
    public String getToken(BaseLoginRequest baseLoginRequest)
    {
        if(baseLoginRequest!=null) {
            if (baseLoginRequest.getClass() == ExaminerLoginRequest.class) {
                ExaminerLoginRequest request = (ExaminerLoginRequest) baseLoginRequest;
                return getHAsh(request.getUserId() );
            } else if (baseLoginRequest.getClass() == CandidateLoginRequest.class) {
                CandidateLoginRequest request = (CandidateLoginRequest) baseLoginRequest;
                return getHAsh(request.getTestId() +request.getUserId() );
            }
        }
        return null;
    }



}
