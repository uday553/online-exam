package com.uday.learning.service;

public interface LoginService<S,R> {
    R login(S request);
}
