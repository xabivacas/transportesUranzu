package modelo;

import modelo.Camion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloCamioneroTest {


    private ModeloCamion modeloCamion;
    private Connection mockConnection;

    @Before
    public void setUp() {
        mockConnection = Mockito.mock(Connection.class);
        modeloCamion = new ModeloCamion();
        modeloCamion.setConexion(mockConnection);
    }

    @Test
     public void testGetTodos() throws SQLException {
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, true, false); // Simular dos filas en ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("111", "222");
        when(mockResultSet.getString("marca")).thenReturn("Ford", "Chevrolet");
        when(mockResultSet.getString("modelo")).thenReturn("Fiesta", "Cruze");

        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockStatement);

        ArrayList<Camion> camiones = modeloCamion.getTodos();

        assertEquals(2, camiones.size());
        assertEquals("111", camiones.get(0).getMatricula());
        assertEquals("Ford", camiones.get(0).getMarca());
        assertEquals("Fiesta", camiones.get(0).getModelo());
        assertEquals("222", camiones.get(1).getMatricula());
        assertEquals("Chevrolet", camiones.get(1).getMarca());
        assertEquals("Cruze", camiones.get(1).getModelo());
        
    }

    @Test
     public void testGetUno() throws SQLException {
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular una fila en ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("111");
        when(mockResultSet.getString("marca")).thenReturn("Ford");
        when(mockResultSet.getString("modelo")).thenReturn("Fiesta");

        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockStatement);

        Camion camion = modeloCamion.getUno("111");

        assertEquals("111", camion.getMatricula());
        assertEquals("Ford", camion.getMarca());
        assertEquals("Fiesta", camion.getModelo());
    }

}
