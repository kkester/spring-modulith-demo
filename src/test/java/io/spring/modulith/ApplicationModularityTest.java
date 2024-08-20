package io.spring.modulith;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

@Tag("ModularityTest")
class ApplicationModularityTest {

    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);

    @Test
    void verifiesModuleStructure() {
        modules.verify().forEach( System.out::println );
    }
}
