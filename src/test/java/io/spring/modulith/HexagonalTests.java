package io.spring.modulith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.architecture.hexagonal.Application;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.core.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "io.spring.modulith")
class HexagonalTests {
    @ArchTest
    static ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

    ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);

    @ArchTest
    void ensureModules(JavaClasses javaClasses) {
        modules.stream().map(ApplicationModule::getBasePackage)
                .forEach(javaPackage -> classes()
                        .that()
                        .resideInAPackage(javaPackage.getName())
                        .should()
                        .beAnnotatedWith(PrimaryPort.class)
                        .orShould()
                        .beRecords()
                        .orShould()
                        .beAnnotatedWith(DomainEvent.class)
                        .orShould()
                        .bePackagePrivate()
                        .check(javaClasses));
    }

    @ArchTest
    void ensureEvents(JavaClasses javaClasses) {
        noClasses()
                .that()
                .areAnnotatedWith(Application.class)
                .should()
                .dependOnClassesThat()
                .areAssignableTo(ApplicationEvent.class)
                .check(javaClasses);
    }

    @ArchTest
    void ensurePersists(JavaClasses javaClasses) {
        noClasses()
                .that()
                .resideInAPackage("..persist")
                .should()
                .dependOnClassesThat()
                .areAssignableTo(ApplicationEvent.class)
                .check(javaClasses);
    }
}
