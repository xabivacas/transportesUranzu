package modelo;

	import modelo.Camion;
	import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;

	public class CamionTest {

	    public Camion camion;

	    @Before
	    public void setUp() {
	        camion = new Camion();
	    }

	    @Test
	    public void testGetSetMatricula() {
	        camion.setMatricula("1234ABC");
	        assertEquals("1234ABC", camion.getMatricula());
	    }

	    @Test
	    public void testGetSetMarca() {
	        camion.setMarca("Ford");
	        assertEquals("Ford", camion.getMarca());
	    }

	    @Test
	    public void testGetSetModelo() {
	        camion.setModelo("F-150");
	        assertEquals("F-150", camion.getModelo());
	    }
	}

