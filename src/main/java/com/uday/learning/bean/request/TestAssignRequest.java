package com.uday.learning.bean.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TestAssignRequest {
    private List<String> candidates;
    private int testId;
    private Date expireDate;
}
