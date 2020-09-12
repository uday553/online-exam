package com.uday.learning.dao.repository;

import com.uday.learning.dao.CandidateAuth;
import com.uday.learning.dao.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateAuthRepository extends JpaRepository<CandidateAuth,Long> {

    CandidateAuth findByEmailIdAndTestIdAndPassword(String emailId, int testId, String password);
    CandidateAuth findByEmailIdAndTestIdAndPasswordAndStatus(String emailId, int testId, String password, CandidateStatus status);
    CandidateAuth findById(int id);
}
