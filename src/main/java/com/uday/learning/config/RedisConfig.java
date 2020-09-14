package com.uday.learning.config;


import com.uday.learning.redis.dao.CandidateTokenCacheDao;
import com.uday.learning.redis.dao.ExamCacheDao;
import com.uday.learning.redis.dao.ExaminerTokenCacheDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackageClasses = {ExamCacheDao.class})
public class RedisConfig {

    Logger log = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    RedisClusterConfig redisClusterConfig;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory  = new JedisConnectionFactory();
        jedisConFactory.setHostName(redisClusterConfig.getHost());
        jedisConFactory.setPort(redisClusterConfig.getPort());
        return jedisConFactory;
    }

    @Bean
    RedisTemplate<String , ExamCacheDao> redisTemplate(JedisConnectionFactory jedisConnectionFactory){

        RedisTemplate<String, ExamCacheDao> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<ExamCacheDao> tokenSerializer = new Jackson2JsonRedisSerializer<>(ExamCacheDao.class);

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(tokenSerializer);

        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(tokenSerializer);

        return redisTemplate;
    }

    @Bean
    RedisTemplate<String , ExaminerTokenCacheDao> examinarTokenTemplate(JedisConnectionFactory jedisConnectionFactory){

        RedisTemplate<String, ExaminerTokenCacheDao> examinarTokenTemplate = new RedisTemplate<>();
        examinarTokenTemplate.setConnectionFactory(jedisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<ExaminerTokenCacheDao> tokenSerializer = new Jackson2JsonRedisSerializer<>(ExaminerTokenCacheDao.class);

        examinarTokenTemplate.setKeySerializer(stringSerializer);
        examinarTokenTemplate.setValueSerializer(tokenSerializer);

        examinarTokenTemplate.setHashKeySerializer(stringSerializer);
        examinarTokenTemplate.setHashValueSerializer(tokenSerializer);

        return examinarTokenTemplate;
    }

    @Bean
    RedisTemplate<String , CandidateTokenCacheDao> candidateTokenTemplate(JedisConnectionFactory jedisConnectionFactory){

        RedisTemplate<String, CandidateTokenCacheDao> candidateTokenTemplate = new RedisTemplate<>();
        candidateTokenTemplate.setConnectionFactory(jedisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<CandidateTokenCacheDao> tokenSerializer = new Jackson2JsonRedisSerializer<>(CandidateTokenCacheDao.class);

        candidateTokenTemplate.setKeySerializer(stringSerializer);
        candidateTokenTemplate.setValueSerializer(tokenSerializer);

        candidateTokenTemplate.setHashKeySerializer(stringSerializer);
        candidateTokenTemplate.setHashValueSerializer(tokenSerializer);

        return candidateTokenTemplate;
    }

}