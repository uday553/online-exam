package com.uday.learning.dao.repository;

import com.uday.learning.dao.Examinar;
import com.uday.learning.dao.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
        List<Test> findByCreatedByAndStatus(int createdBy, int status);
        Test findByIdAndCreatedByAndStatus(int id, int createdBy, int status);
}
