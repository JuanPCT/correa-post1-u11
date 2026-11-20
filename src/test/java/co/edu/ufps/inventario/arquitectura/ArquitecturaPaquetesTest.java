package co.edu.ufps.inventario.arquitectura;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
class ArquitecturaPaquetesTest {
    private final JavaClasses clases=new ClassFileImporter().importPackages("co.edu.ufps.inventario");
    @Test void paquetesNoFormanCiclos(){slices().matching("co.edu.ufps.inventario.(*)..").should().beFreeOfCycles().check(clases);}
    @Test void dominioNoDependeDeFramework(){noClasses().that().resideInAPackage("..domain..").should().dependOnClassesThat().resideInAnyPackage("org.springframework..").check(clases);}
}
