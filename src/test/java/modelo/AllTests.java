package modelo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CamioneroTest.class, CamionTest.class, CargaTest.class, ClienteTest.class, ModeloCamioneroTest.class,
		ModeloCamionTest.class, ModeloCargaTest.class, ModeloClienteTest.class, ModeloViajeTest.class,
		ViajeTest.class })
public class AllTests {

}
