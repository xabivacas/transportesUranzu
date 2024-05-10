package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Viaje;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class ViajeTest {

    private Viaje viaje;

    @Before
    public void setUp() {
        viaje = new Viaje();
    }

    @Test
    public void testGetSetId() {
        viaje.setId(1);
        assertEquals(1, viaje.getId());
    }

    @Test
    public void testGetSetOrigen() {
        viaje.setOrigen("Ciudad A");
        assertEquals("Ciudad A", viaje.getOrigen());
    }

    @Test
    public void testGetSetDestino() {
        viaje.setDestino("Ciudad B");
        assertEquals("Ciudad B", viaje.getDestino());
    }

    @Test
    public void testGetSetFecha() {
        Date fecha = new Date();
        viaje.setFecha(fecha);
        assertEquals(fecha, viaje.getFecha());
    }

    @Test
    public void testGetSetPagado() {
        viaje.setPagado(true);
        assertTrue(viaje.isPagado());
    }

    @Test
    public void testGetSetPrecio() {
        viaje.setPrecio(100);
        assertEquals(100, viaje.getPrecio());
    }
}
