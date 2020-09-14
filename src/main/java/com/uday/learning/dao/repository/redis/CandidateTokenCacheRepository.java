package com.uday.learning.dao.repository.redis;

import com.uday.learning.dao.redis.CandidateTokenCacheDao;
import com.uday.learning.dao.redis.ExamCacheDao;
import com.uday.learning.service.CandidateLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class CandidateTokenCacheRepository implements BaseRepository<String, CandidateTokenCacheDao> {
    Logger log = LoggerFactory.getLogger(CandidateTokenCacheRepository.class);

    private RedisTemplate<String, CandidateTokenCacheDao> candidateTokenTemplate;
    private ValueOperations valueOperations;

    public CandidateTokenCacheRepository(RedisTemplate<String, CandidateTokenCacheDao> redisTemplate) {
        this.candidateTokenTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(CandidateTokenCacheDao candidateTokenCacheDao) {
        String key = candidateTokenCacheDao.getToken();
        log.info(" key : {} candidateTokenCacheDao {}",key,candidateTokenCacheDao);
        candidateTokenTemplate.opsForValue().set(key, candidateTokenCacheDao);
        log.info("value {} ",candidateTokenTemplate.opsForValue().get(key));
        candidateTokenTemplate.expire( key, 100, TimeUnit.SECONDS );
    }

    @Override
    public CandidateTokenCacheDao findById(String id) {
        return candidateTokenTemplate.opsForValue().get(id);
    }

    @Override
    public void update(String  key, CandidateTokenCacheDao candidateTokenCacheDao) {
        valueOperations.set( key, candidateTokenCacheDao);
        candidateTokenTemplate.expire( key, 100, TimeUnit.SECONDS );
    }

    @Override
    public void updateExpire(String  key) {
        candidateTokenTemplate.expire( key, 100, TimeUnit.SECONDS );
    }

    @Override
    public void delete(String id) {
        candidateTokenTemplate.delete(id);
    }

    @Override
    public boolean hasKey(String id)
    {
        return candidateTokenTemplate.hasKey(id);
    }


}
