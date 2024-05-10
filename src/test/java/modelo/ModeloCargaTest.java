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
        // Crear mocks de Connection y ModeloCarga
        mockConnection = mock(Connection.class);
        modeloCarga = new ModeloCarga();
        modeloCarga.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        // Limpiar mocks después de cada prueba
        reset(mockConnection);
    }

    @Test
    public void testInsert() throws SQLException {
        // Crear carga de prueba
        Carga carga = new Carga();
        carga.setPeso(100.5);
        carga.setDimensiones("10x5x3");
        carga.setViaje(new Viaje()); // Supongamos que existe un viaje con ID 1
        carga.setTipo("Fragil");

        // Configurar PreparedStatement simulado para insert
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar inserción de carga
        modeloCarga.insert(carga);

        // Verificar que se llamó a setDouble(), setString() y setInt() en el PreparedStatement simulado
        verify(mockStatement).setDouble(1, 100.5);
        verify(mockStatement).setString(2, "10x5x3");
        verify(mockStatement).setInt(3, 1); // ID del viaje
        verify(mockStatement).setString(4, "Fragil");
        verify(mockStatement).execute();
    }

    @Test
    public void testDelete() throws SQLException {
        // Configurar PreparedStatement simulado para delete
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar eliminación de carga por ID
        modeloCarga.delete(1); // Supongamos que queremos eliminar la carga con ID 1

        // Verificar que se llamó a setInt() en el PreparedStatement simulado
        verify(mockStatement).setInt(1, 1); // ID de la carga a eliminar
        verify(mockStatement).execute();
    }

    @Test
    public void testUpdate() throws SQLException {
        // Crear carga de prueba
        Carga carga = new Carga();
        carga.setId(1); // ID de la carga a actualizar
        carga.setPeso(150.7);
        carga.setDimensiones("15x6x4");
        carga.setViaje(new Viaje()); // Supongamos que existe un viaje con ID 2
        carga.setTipo("Delicado");

        // Configurar PreparedStatement simulado para update
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar actualización de carga
        modeloCarga.update(carga);

        // Verificar que se llamó a setDouble(), setString() y setInt() en el PreparedStatement simulado
        verify(mockStatement).setDouble(1, 150.7);
        verify(mockStatement).setString(2, "15x6x4");
        verify(mockStatement).setInt(3, 2); // ID del nuevo viaje
        verify(mockStatement).setString(4, "Delicado");
        verify(mockStatement).setInt(5, 1); // ID de la carga a actualizar
        verify(mockStatement).execute();
    }

    @Test
    public void testGetUno() throws SQLException {
        // Configurar ResultSet simulado para getUno
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular resultado del ResultSet
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getDouble("peso")).thenReturn(100.5);
        when(mockResultSet.getString("dimensiones")).thenReturn("10x5x3");
        when(mockResultSet.getInt("viaje")).thenReturn(1); // ID del viaje
        when(mockResultSet.getString("tipo")).thenReturn("Fragil");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de carga por ID
        Carga carga = modeloCarga.getUno(1);

        // Verificar que se llamó a setInt() en el PreparedStatement simulado
        verify(mockStatement).setInt(1, 1); // ID de la carga a consultar
        verify(mockStatement).executeQuery();

        // Verificar que se creó correctamente la carga
        assertEquals(1, carga.getId());
        assertEquals(100.5, carga.getPeso(), 0.01);
        assertEquals("10x5x3", carga.getDimensiones());
        assertEquals(1, carga.getViaje().getId());
        assertEquals("Fragil", carga.getTipo());
    }

    @Test
    public void testGetTodos() throws SQLException {
        // Configurar ResultSet simulado para getTodos
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); // Simular múltiples resultados del ResultSet
        when(mockResultSet.getInt("id")).thenReturn(1); // ID de la carga
        when(mockResultSet.getDouble("peso")).thenReturn(100.5);
        when(mockResultSet.getString("dimensiones")).thenReturn("10x5x3");
        when(mockResultSet.getInt("viaje")).thenReturn(1); // ID del viaje
        when(mockResultSet.getString("tipo")).thenReturn("Fragil");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de todas las cargas
        ArrayList<Carga> cargas = modeloCarga.getTodos();

        // Verificar que se llamó a executeQuery() en el PreparedStatement simulado
        verify(mockStatement).executeQuery();

        // Verificar que se crearon las cargas correctamente
        assertEquals(1, cargas.size());
        Carga carga = cargas.get(0);
        assertEquals(1, carga.getId());
        assertEquals(100.5, carga.getPeso(), 0.01);
        assertEquals("10x5x3", carga.getDimensiones());
        assertEquals(1, carga.getViaje().getId());
        assertEquals("Fragil", carga.getTipo());
    }
}

