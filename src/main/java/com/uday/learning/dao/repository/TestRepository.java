package com.uday.learning.dao.repository;

import com.uday.learning.dao.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
}
