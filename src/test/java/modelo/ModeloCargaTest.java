package modelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModeloCargaTest {

    private Connection mockConnection;
    private ModeloCarga modeloCarga;

    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        modeloCarga = new ModeloCarga();
        modeloCarga.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        reset(mockConnection);
    }

    @Test
    public void testInsert() throws SQLException {
        Carga carga = new Carga();
        carga.setPeso(100.5);
        carga.setDimensiones("10x5x3");
        carga.setViaje(new Viaje()); 
        carga.setTipo("Fragil");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        modeloCarga.insert(carga);

        
    }

    @Test
    public void testDelete() throws SQLException {
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        modeloCarga.delete(1); 

        verify(mockStatement).setInt(1, 1);
        verify(mockStatement).execute();
    }

    @Test
    public void testUpdate() throws SQLException {
        Carga carga = new Carga();
        carga.setId(1); 
        carga.setPeso(150.7);
        carga.setDimensiones("15x6x4");
        carga.setViaje(new Viaje()); 
        carga.setTipo("Delicado");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        modeloCarga.update(carga);
    }
    @Test
    public void testGetUno() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getDouble("peso")).thenReturn(100.5);
        when(mockResultSet.getString("dimensiones")).thenReturn("10x5x3");
        when(mockResultSet.getInt("viaje")).thenReturn(1); 
        when(mockResultSet.getString("tipo")).thenReturn("Fragil");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        Carga carga = modeloCarga.getUno(1);

        verify(mockStatement).setInt(1, 1); 
        verify(mockStatement).executeQuery();

        assertEquals(1, carga.getId());
        assertEquals(100.5, carga.getPeso(), 0.01);
        assertEquals("10x5x3", carga.getDimensiones());
        assertEquals("Fragil", carga.getTipo());
    }

    @Test
    public void testGetTodos() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); 
        when(mockResultSet.getInt("id")).thenReturn(1); 
        when(mockResultSet.getDouble("peso")).thenReturn(100.5);
        when(mockResultSet.getString("dimensiones")).thenReturn("10x5x3");
        when(mockResultSet.getInt("viaje")).thenReturn(1); 
        when(mockResultSet.getString("tipo")).thenReturn("Fragil");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        ArrayList<Carga> cargas = modeloCarga.getTodos();

        verify(mockStatement).executeQuery();

        assertEquals(1, cargas.size());
        Carga carga = cargas.get(0);
        assertEquals(1, carga.getId());
        assertEquals(100.5, carga.getPeso(), 0.01);
        assertEquals("10x5x3", carga.getDimensiones());
        assertEquals("Fragil", carga.getTipo());
    }
}

