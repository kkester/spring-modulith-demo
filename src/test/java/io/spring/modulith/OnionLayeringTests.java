package io.spring.modulith;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import org.jmolecules.archunit.JMoleculesArchitectureRules;
import org.springframework.context.ApplicationEvent;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "io.spring.modulith")
class OnionLayeringTests {

    List<String> modules = ApplicationModules.of(ModulithApplication.class).stream()
        .map(m -> m.getBasePackage().getName())
        .toList();

    @ArchTest
    static ArchRule onionClassical = JMoleculesArchitectureRules.ensureOnionSimple();

    @ArchTest
    void ensureServices(JavaClasses classes) {
        modules.forEach(module ->
            classes()
                .that()
                .areAnnotatedWith(Service.class)
                .and()
                .resideInAPackage(module)
                .should()
                .onlyDependOnClassesThat(new ServiceDependencyPredicate(module))
                .check(classes)
        );
    }

    @ArchTest
    void ensureControllers(JavaClasses classes) {
        modules.forEach(module ->
            classes()
                .that()
                .areAnnotatedWith(RestController.class)
                .and()
                .resideInAPackage(module+".api")
                .should()
                .onlyDependOnClassesThat(new ControllerDependencyPredicate(module))
                .check(classes));
    }

    private static class ServiceDependencyPredicate extends DescribedPredicate<JavaClass> {
        private final String moduleName;

        public ServiceDependencyPredicate(String moduleName, Object... params) {
            super("Service Dependencies", params);
            this.moduleName = moduleName;
        }

        @Override
        public boolean test(JavaClass javaClass) {
            return javaClass.isAnnotatedWith(Service.class) ||
                javaClass.isAssignableTo(ApplicationEvent.class) ||
                !javaClass.getPackage().getName().contains("modulith") ||
                javaClass.getPackage().getName().endsWith(moduleName);
        }
    }

    private static class ControllerDependencyPredicate extends DescribedPredicate<JavaClass> {
        private final String moduleName;

        public ControllerDependencyPredicate(String moduleName, Object... params) {
            super("Service Dependencies", params);
            this.moduleName = moduleName;
        }

        @Override
        public boolean test(JavaClass javaClass) {
            return !javaClass.getPackage().getName().contains("modulith") ||
                javaClass.getPackage().getName().contains(moduleName+".api") ||
                (javaClass.isAnnotatedWith(Service.class) && javaClass.getPackage().getName().endsWith(moduleName)) ||
                (javaClass.isAnnotatedWith(Entity.class) && javaClass.getPackage().getName().endsWith(moduleName));
        }
    }
}
