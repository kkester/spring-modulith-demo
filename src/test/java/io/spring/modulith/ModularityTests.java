package io.spring.modulith;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
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
