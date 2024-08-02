package io.spring.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {
    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);

    @Test
    void verifiesModuleStructure() {
        modules.verify().forEach( System.out::println );
    }

    @Test
    void createModuleDocumentation() {
        new Documenter( modules ).writeDocumentation();
    }

    @Test
    void createPlantUml() {
        new Documenter( modules )
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml();
    }

    @Test
    void writeDocumentationSnippets() {
        new Documenter( modules )
            .writeModuleCanvases();
    }
}
