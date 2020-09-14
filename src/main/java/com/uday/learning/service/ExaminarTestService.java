package com.uday.learning.service;

import com.uday.learning.bean.request.TestAssignRequest;
import com.uday.learning.bean.response.TestAssignResponse;
import com.uday.learning.bean.response.TestListResponse;

public interface ExaminarTestService {

    TestListResponse getTestList(String token);

    TestListResponse getTest(String token,int testID);

    TestAssignResponse assignTest(String token , TestAssignRequest testAssignRequest);


}
