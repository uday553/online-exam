package com.uday.learning.schedular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ExamSchedular {

    Logger log = LoggerFactory.getLogger(ExamSchedular.class);

    @Scheduled(fixedRate = 6000)
    private void createTest()
    {
        log.debug("aes config {}");
    }
}
