package com.uday.learning.schedular;

import com.uday.learning.dao.CandidateAuth;
import com.uday.learning.dao.CandidateStatus;
import com.uday.learning.dao.repository.CandidateAuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Iterator;
import java.util.List;

@Configuration
@EnableScheduling
public class ExamSchedular {

    Logger log = LoggerFactory.getLogger(ExamSchedular.class);

    @Autowired
    CandidateAuthRepository candidateAuthRepository;

    @Scheduled(fixedRate = 6000)
    private void processCandidateAlerts()
    {
        List<CandidateAuth> candidateAuthList = candidateAuthRepository.findByAssignStatus(CandidateStatus.INACTIVE.ordinal());
        if (candidateAuthList!=null && candidateAuthList.size()>0)
        {
            log.info(">>>>>>>>  >>>>>   >>>> Alert processing");
            // send email here
            for (CandidateAuth candidateAuth:candidateAuthList) {
                candidateAuth.setAssignStatus(CandidateStatus.ACTIVE.ordinal());
                candidateAuth.setStatus(CandidateStatus.ACTIVE.ordinal());
            }
            candidateAuthRepository.saveAll(candidateAuthList);

        }
    }
}
