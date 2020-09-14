package com.uday.learning.dao.repository.redis;

public interface CacheRepository<T> {
    void save(T token);
    void delete(T token);
    boolean hasTokenToken(T token);

}
