package com.uday.learning.config;


import com.uday.learning.dao.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

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
    RedisTemplate<String , User> redisTemplate(){
        RedisTemplate<String,User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}