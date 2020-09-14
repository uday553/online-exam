package com.uday.learning.service;

import com.uday.learning.bean.response.TestListResponse;

public interface ExaminarTestService {

    TestListResponse getTestList(String token);

}
