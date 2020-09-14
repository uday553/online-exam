package com.uday.learning.dao.repository.redis;

import com.uday.learning.redis.dao.ExamCacheDao;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class ExamCacheRepository implements BaseRepository<String, ExamCacheDao> {

    private RedisTemplate<String, ExamCacheDao> redisTemplate;
    private ValueOperations valueOperations;

    public ExamCacheRepository(RedisTemplate<String, ExamCacheDao> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(ExamCacheDao examCacheDao) {
        String key = examCacheDao.getTestId();
        redisTemplate.opsForValue().set(key, examCacheDao);
        redisTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public ExamCacheDao findById(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    @Override
    public void update(String  key, ExamCacheDao lastAttemptedQuestion) {
        valueOperations.set( key, lastAttemptedQuestion);
        //redisTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public void updateExpire(String  key) {
        redisTemplate.expire( key, 10, TimeUnit.SECONDS );
    }

    @Override
    public void delete(String id) {
        redisTemplate.delete(id);
    }

    @Override
    public boolean hasKey(String id) {
        return redisTemplate.hasKey(id);
    }
}



