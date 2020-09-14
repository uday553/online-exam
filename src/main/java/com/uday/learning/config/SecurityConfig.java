package com.uday.learning.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties("security")
public class SecurityConfig {
    private String aesKey;
    private String aesSalt;
    private String bcryptSalt;
    private int rounds;
}
