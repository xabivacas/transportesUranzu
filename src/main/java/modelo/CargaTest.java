package modelo;

import modelo.Carga;
import modelo.Viaje;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CargaTest {

	public Carga carga;

    @Before
    public void setUp() {
        carga = new Carga();
    }

    @Test
    public void testGetSetId() {
        carga.setId(1);
        assertEquals(1, carga.getId());
    }

    @Test
    public void testGetSetPeso() {
        carga.setPeso(100.5);
        assertEquals(100.5, carga.getPeso(), 0.001); // Utilizamos delta para comparar valores double
    }

    @Test
    public void testGetSetDimensiones() {
        carga.setDimensiones("10x5x3");
        assertEquals("10x5x3", carga.getDimensiones());
    }

    @Test
    public void testGetSetViaje() {
        Viaje viaje = new Viaje();
        carga.setViaje(viaje);
        assertEquals(viaje, carga.getViaje());
    }

    @Test
    public void testGetSetTipo() {
        // Prueba para los métodos get y set de tipo
        carga.setTipo("Fragil");
        assertEquals("Fragil", carga.getTipo());
    }
}



