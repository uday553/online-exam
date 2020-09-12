package com.uday.learning.controller;

import com.uday.learning.dao.repository.redis.BaseRepository;
import com.uday.learning.dao.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    BaseRepository<User> redisRepository;

    public UserResource(BaseRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id, @PathVariable("name") final String name) {
        redisRepository.save(new User(id, name, 20000L));
        return redisRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
        redisRepository.update(new User(id, name, 1000L));
        return redisRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        redisRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, User> all() {
        return redisRepository.findAll();
    }

}
