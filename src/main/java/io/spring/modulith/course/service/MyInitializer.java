package io.spring.modulith.course.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyInitializer  implements ApplicationModuleInitializer {

    @Override
    public void initialize() {
        log.info("We are wae are getting closer");
        // Initialization code goes here
    }
}
