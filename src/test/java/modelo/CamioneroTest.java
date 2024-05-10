package modelo;

import modelo.Camionero;
import modelo.Viaje;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CamioneroTest {

    private Camionero camionero;

    @Before
    public void setUp() {
        camionero = new Camionero();
    }

    @Test
    public void testGetSetDni() {
        camionero.setDni("12345678X");
        assertEquals("12345678X", camionero.getDni());
    }

    @Test
    public void testGetSetNombre() {
        camionero.setNombre("Juan");
        assertEquals("Juan", camionero.getNombre());
    }

    @Test
    public void testGetSetApellido() {
        camionero.setApellido("González");
        assertEquals("González", camionero.getApellido());
    }

    @Test
    public void testGetSetViajes() {
        ArrayList<Viaje> viajes = new ArrayList<>();
        Viaje viaje1 = new Viaje();
        Viaje viaje2 = new Viaje();
        viajes.add(viaje1);
        viajes.add(viaje2);

        camionero.setViajes(viajes);
        assertEquals(viajes, camionero.getViajes());
    }
}
