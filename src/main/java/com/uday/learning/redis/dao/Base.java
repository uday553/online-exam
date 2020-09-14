package com.uday.learning.redis.dao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class Base  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date createdAt;
}
