package io.spring.modulith;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.core.ApplicationModules;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "io.spring.modulith")
class HexagonalTests {
    @ArchTest
    static ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);

    @Test
    void ensureModules() {
        var packages = new ClassFileImporter().importPackages("io.spring.modulith..");
        modules.stream().map(applicationModule -> applicationModule.getBasePackage())
            .forEach(javaPackage -> {
                classes()
                    .that()
                    .resideInAPackage(javaPackage.getName())
                    .should()
                    .beAnnotatedWith(PrimaryPort.class)
                    .orShould()
                    .beRecords()
                    .orShould()
                    .beAssignableTo(ApplicationEvent.class)
                    .check(packages);
            });
    }
}
