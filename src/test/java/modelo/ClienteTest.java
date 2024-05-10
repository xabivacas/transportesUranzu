package modelo;

import modelo.Cliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {

    public Cliente cliente;

    @Before
    public void setUp() {
        cliente = new Cliente();
    }

    @Test
    public void testGetSetCif() {
        cliente.setCif("12345678A");
        assertEquals("12345678A", cliente.getCif());
    }

    @Test
    public void testGetSetNombre() {
        cliente.setNombre("Juan");
        assertEquals("Juan", cliente.getNombre());
    }

    @Test
    public void testGetSetDireccion() {
        cliente.setDireccion("Calle Falsa 123");
        assertEquals("Calle Falsa 123", cliente.getDireccion());
    }
}


