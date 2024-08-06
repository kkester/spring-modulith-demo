package io.spring.modulith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "io.spring.modulith")
class LayeringTests {
    @ArchTest
    static ArchRule layering = JMoleculesArchitectureRules.ensureLayering();

    @ArchTest
    void ensureApi(JavaClasses classes) {
        classes()
            .that()
            .areAnnotatedWith(RestController.class)
            .should()
            .onlyHaveDependentClassesThat()
            .resideInAPackage("boo")
            .check(classes);
    }

    @ArchTest
    void ensureServices(JavaClasses classes) {
//        List<String> modules = ApplicationModules.of(ModulithApplication.class).stream()
//            .map(m -> m.getBasePackage().getName())
//            .toList();
//        modules.forEach(module -> {
//            classes()
//                .that()
//                .resideInAPackage(module)
//                .and()
//                .areAnnotatedWith(Service.class)
//                .should()
//                .dependOnClassesThat()
//                .areAssignableFrom(CrudRepository.class)
//                .andShould()
//                .resideInAPackage(module + ".persist..")
//                .orShould()
//                .dependOnClassesThat()
//                .areAnnotatedWith(Service.class)
//                .orShould()
//                .dependOnClassesThat()
//                .resideOutsideOfPackage("..modulith")
//                .check(classes);
//        });
    }
}
