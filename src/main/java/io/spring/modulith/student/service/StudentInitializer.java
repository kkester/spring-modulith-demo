package io.spring.modulith.student.service;

import io.spring.modulith.ModulithApplication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Slf4j
public class StudentInitializer implements ApplicationModuleInitializer {

    private final IncompleteEventPublications incompleteEventPublications;

    @Override
    public void initialize() {
        log.info("Validating Modules");
        ApplicationModules.of(ModulithApplication.class).verify();

        log.info("Resubmitting Incomplete Events");
        incompleteEventPublications.resubmitIncompletePublications(ee -> {
            log.info("Resubmitting event {} in state {}", ee.getIdentifier(), ee.isPublicationCompleted());
            return !ee.isPublicationCompleted();
        });
    }
}
