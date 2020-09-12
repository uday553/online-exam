package com.uday.learning.dao.repository.redis;

import com.uday.learning.dao.redis.User;

import java.util.Map;

public interface BaseRepository<T> {
    void save(T user);
    Map<String,T> findAll();
    void update(User user);
    void delete(String id);
    User findById(String id) ;
}
