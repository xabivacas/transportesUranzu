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
        // Crear mocks de Connection y ModeloCamion
        mockConnection = mock(Connection.class);
        modeloCamion = new ModeloCamion();
        modeloCamion.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        // Limpiar mocks después de cada prueba
        reset(mockConnection);
    }

    @Test
    public void testInsertCamion() throws SQLException {
       
        Camion camion = new Camion();

        // Configurar PreparedStatement simulado para insertCamion
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar inserción de camión
        modeloCamion.insertCamion(camion);


    }

    @Test
    public void testDeleteCamion() throws SQLException {
        // Configurar PreparedStatement simulado para deleteCamion
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar eliminación de camión
        modeloCamion.deleteCamion("1010JJJ");

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "1010JJJ");
        verify(mockStatement).execute();
    }

    @Test
    public void testGetUno() throws SQLException {
        // Configurar ResultSet simulado para getUno
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular resultado del ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("1010JJJ");
        when(mockResultSet.getString("marca")).thenReturn("International");
        when(mockResultSet.getString("modelo")).thenReturn("Lonestar");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de camión por matrícula
        Camion camion = modeloCamion.getUno("1010JJJ");

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "1010JJJ");
        verify(mockStatement).executeQuery();

        // Verificar que se creó correctamente el objeto Camion
        assertEquals("1010JJJ", camion.getMatricula());
        assertEquals("International", camion.getMarca());
        assertEquals("Lonestar", camion.getModelo());
    }

    @Test
    public void testGetTodos() throws SQLException {
        // Configurar ResultSet simulado para getTodos
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); // Simular dos filas en el ResultSet
        when(mockResultSet.getString("matricula")).thenReturn("1010JJJ");
        when(mockResultSet.getString("marca")).thenReturn("International");
        when(mockResultSet.getString("modelo")).thenReturn("Lonestar");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de todos los camiones
        ArrayList<Camion> camiones = modeloCamion.getTodos();

        // Verificar que se llamó a executeQuery() en el PreparedStatement simulado
        verify(mockStatement).executeQuery();

        // Verificar la lista de camiones obtenida
        assertEquals("1010JJJ", camiones.get(0).getMatricula());
        assertEquals("International", camiones.get(0).getMarca());
        assertEquals("Lonestar", camiones.get(0).getModelo());

    }
}
