package modelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModeloCamionTest {

    private Connection mockConnection;
    private ModeloCamion modeloCamion;

    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        modeloCamion = new ModeloCamion();
        modeloCamion.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        reset(mockConnection);
    }

    @Test
    public void testInsertCamion() throws SQLException {
       
        Camion camion = new Camion();

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        modeloCamion.insertCamion(camion);


    }

    @Test
    public void testDeleteCamion() throws SQLException {
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        modeloCamion.deleteCamion("1010JJJ");

        verify(mockStatement).setString(1, "1010JJJ");
        verify(mockStatement).execute();
    }

    @Test
    public void testGetUno() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular resultado del ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("1010JJJ");
        when(mockResultSet.getString("marca")).thenReturn("International");
        when(mockResultSet.getString("modelo")).thenReturn("Lonestar");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        Camion camion = modeloCamion.getUno("1010JJJ");

        verify(mockStatement).setString(1, "1010JJJ");
        verify(mockStatement).executeQuery();

        assertEquals("1010JJJ", camion.getMatricula());
        assertEquals("International", camion.getMarca());
        assertEquals("Lonestar", camion.getModelo());
    }

    @Test
    public void testGetTodos() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); // Simular dos filas en el ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("1010JJJ");
        when(mockResultSet.getString("marca")).thenReturn("International");
        when(mockResultSet.getString("modelo")).thenReturn("Lonestar");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        ArrayList<Camion> camiones = modeloCamion.getTodos();

        verify(mockStatement).executeQuery();

        assertEquals("1010JJJ", camiones.get(0).getMatricula());
        assertEquals("International", camiones.get(0).getMarca());
        assertEquals("Lonestar", camiones.get(0).getModelo());

    }
}
