package com.uday.learning.dao.redis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash(value = "candidateToken", timeToLive = 300)
@Data
public class ExaminerTokenDao {
    private String token;
}
