package com.uday.learning.dao.repository.redis;

public interface BaseRepository<K,V> {
    void save(V value);
    void update(K key , V value);
    void delete(K key);
    V findById(K key) ;
    void updateExpire(K key);
    boolean hasKey(K id);
}
