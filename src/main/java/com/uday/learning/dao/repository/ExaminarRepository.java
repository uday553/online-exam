package com.uday.learning.dao.repository;

import com.uday.learning.dao.Examinar;
import com.uday.learning.dao.ExaminarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminarRepository  extends JpaRepository<Examinar,Long> {

    Examinar findByEmailIdAndPassword(String emailId,String password);
    Examinar findByEmailIdAndPasswordAndStatus(String emailId,String password, int status);
    Examinar findById(int id);
}
