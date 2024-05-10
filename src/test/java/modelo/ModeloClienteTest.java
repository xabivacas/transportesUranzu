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

public class ModeloClienteTest {

    private Connection mockConnection;
    private ModeloCliente modeloCliente;

    @Before
    public void setUp() throws SQLException {
        // Crear mocks de Connection y ModeloCliente
        mockConnection = mock(Connection.class);
        modeloCliente = new ModeloCliente();
        modeloCliente.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        // Limpiar mocks después de cada prueba
        reset(mockConnection);
    }

    @Test
    public void testInsert() throws SQLException {
        // Crear cliente de prueba
        Cliente cliente = new Cliente();
        cliente.setCif("12345678A");
        cliente.setNombre("Juan Pérez");
        cliente.setDireccion("Calle Principal, 123");

        // Configurar PreparedStatement simulado para insert
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar inserción de cliente
        modeloCliente.insert(cliente);

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "12345678A");
        verify(mockStatement).setString(2, "Juan Pérez");
        verify(mockStatement).setString(3, "Calle Principal, 123");
        verify(mockStatement).execute();
    }

    @Test
    public void testDelete() throws SQLException {
        // Configurar PreparedStatement simulado para delete
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar eliminación de cliente por CIF
        modeloCliente.delete("12345678A");

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "12345678A");
        verify(mockStatement).execute();
    }

    @Test
    public void testUpdate() throws SQLException {
        // Crear cliente de prueba
        Cliente cliente = new Cliente();
        cliente.setCif("12345678A");
        cliente.setNombre("Juan Pérez");
        cliente.setDireccion("Calle Principal, 123");

        // Configurar PreparedStatement simulado para update
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar actualización de cliente
        modeloCliente.update(cliente);

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "Juan Pérez");
        verify(mockStatement).setString(2, "Calle Principal, 123");
        verify(mockStatement).setString(3, "12345678A");
        verify(mockStatement).execute();
    }

    @Test
    public void testGetUno() throws SQLException {
        // Configurar ResultSet simulado para getUno
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular resultado del ResultSet
        when(mockResultSet.getString("cif")).thenReturn("12345678A");
        when(mockResultSet.getString("nombre")).thenReturn("Juan Pérez");
        when(mockResultSet.getString("direccion")).thenReturn("Calle Principal, 123");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de cliente por CIF
        Cliente cliente = modeloCliente.getUno("12345678A");

        // Verificar que se llamó a setString() en el PreparedStatement simulado
        verify(mockStatement).setString(1, "12345678A");
        verify(mockStatement).executeQuery();

        // Verificar que se creó correctamente el cliente
        assertEquals("12345678A", cliente.getCif());
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("Calle Principal, 123", cliente.getDireccion());
    }

    @Test
    public void testGetTodos() throws SQLException {
        // Configurar ResultSet simulado para getTodos
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); // Simular múltiples resultados del ResultSet
        when(mockResultSet.getString("cif")).thenReturn("12345678A"); // CIF del cliente
        when(mockResultSet.getString("nombre")).thenReturn("Juan Pérez");
        when(mockResultSet.getString("direccion")).thenReturn("Calle Principal, 123");

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de todos los clientes
        ArrayList<Cliente> clientes = modeloCliente.getTodos();

        // Verificar que se llamó a executeQuery() en el PreparedStatement simulado
        verify(mockStatement).executeQuery();

        // Verificar que se crearon los clientes correctamente
        assertEquals(1, clientes.size());
        Cliente cliente = clientes.get(0);
        assertEquals("12345678A", cliente.getCif());
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("Calle Principal, 123", cliente.getDireccion());
    }
}

