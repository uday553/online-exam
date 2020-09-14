package com.uday.learning.dao.repository.redis;

import com.uday.learning.dao.redis.ExaminerTokenCacheDao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class ExaminarTokenCacheRepository implements BaseRepository<String, ExaminerTokenCacheDao> {


    private RedisTemplate<String, ExaminerTokenCacheDao> examinarTokenTemplate;
    private ValueOperations valueOperations;

    public ExaminarTokenCacheRepository(RedisTemplate<String, ExaminerTokenCacheDao> redisTemplate) {
        this.examinarTokenTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(ExaminerTokenCacheDao examinerTokenCacheDao) {
        String key = examinerTokenCacheDao.getToken();
        examinarTokenTemplate.opsForValue().set(key, examinerTokenCacheDao);
        examinarTokenTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public ExaminerTokenCacheDao findById(String id) {
        return examinarTokenTemplate.opsForValue().get(id);
    }

    @Override
    public void update(String  key, ExaminerTokenCacheDao examinerTokenCacheDao) {
        valueOperations.set( key, examinerTokenCacheDao);
        examinarTokenTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public void updateExpire(String  key) {
        examinarTokenTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public void delete(String id) {
        examinarTokenTemplate.delete(id);
    }

    @Override
    public boolean hasKey(String id) {
        return examinarTokenTemplate.hasKey(id);
    }
}
