package io.spring.modulith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;

@AnalyzeClasses(packages = "io.spring.modulith")
class OnionTests {

    @ArchTest
    static ArchRule onionClassical = JMoleculesArchitectureRules.ensureOnionClassical();

}
