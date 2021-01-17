package de.fsujena.inf.swt.spaethe.arcbyexample.arcunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "de.fsujena.inf.swt.spaethe.arcbyexample")
public class PortAndAdaptersDependencyRulesTest {

    // 'access' catches only violations by real accesses, i.e. accessing a field, calling a method; compare 'dependOn' further down

    @ArchTest
    static final ArchRule front_should_not_access_persistence =
            noClasses().that().resideInAPackage("..front..")
                    .should().accessClassesThat().resideInAPackage("..persistence..");

    @ArchTest
    static final ArchRule rest_should_not_access_html =
            noClasses().that().resideInAPackage("..front.rest..")
                    .should().accessClassesThat().resideInAPackage("..front.html..");

    @ArchTest
    static final ArchRule persistence_should_not_access_controller =
            noClasses().that().resideInAPackage("..persistence..")
                    .should().accessClassesThat().resideInAPackage("..controller..");

    @ArchTest
    static final ArchRule domain_should_not_access_persistence =
            noClasses().that().resideInAPackage("..domain..")
                    .should().accessClassesThat().resideInAPackage("..persistence..");

    /** Dieser Test SOLL fehlschlagen, um zu prüfen, ob der Testmechanismus auch funktioniert. */
    /*
    @ArchTest
    static final ArchRule persistence_should_not_access_domain =
            noClasses().that().resideInAPackage("..persistence..")
                    .should().accessClassesThat().resideInAPackage("..domain..");
    // */

}