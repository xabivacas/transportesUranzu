package modelo;

import static org.junit.Assert.assertEquals; // Asegúrate de usar la aserción adecuada según tu entorno de pruebas
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.*;
import java.util.*;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ModeloViajeTest {

	private Connection mockConnection;
    private ModeloViaje modeloViaje;

    @Before
    public void setUp() throws SQLException {
        // Crear mocks de Connection y ModeloCarga
        mockConnection = mock(Connection.class);
        modeloViaje = new ModeloViaje();
        modeloViaje.setConexion(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        // Limpiar mocks después de cada prueba
        reset(mockConnection);
    }

    @Test
    public void testInsert() throws SQLException {
        // Crear carga de prueba
        Viaje viaje = new Viaje();
        viaje.setOrigen("Zamora");
        viaje.setDestino("Madrid");
        viaje.setFecha(new java.sql.Date(1998-10-30)); // Supongamos que existe un viaje con ID 1

        // Configurar PreparedStatement simulado para insert
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar inserción de carga
        modeloViaje.insert(viaje);

        
    }

    @Test
    public void testDelete() throws SQLException {
        // Configurar PreparedStatement simulado para delete
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar eliminación de carga por ID
        modeloViaje.delete(1); // Supongamos que queremos eliminar la carga con ID 1

        // Verificar que se llamó a setInt() en el PreparedStatement simulado
        verify(mockStatement).setInt(1, 1); // ID de la carga a eliminar
        verify(mockStatement).execute();
    }

    @Test
    public void testUpdate() throws SQLException {
        // Crear carga de prueba
        Viaje viaje = new Viaje();
        viaje.setId(1); // ID de la carga a actualizar
        viaje.setOrigen("Zamora");
        viaje.setDestino("Madrid");
        viaje.setFecha(new java.sql.Date(1998-10-30));

        // Configurar PreparedStatement simulado para update
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Ejecutar actualización de carga
        modeloViaje.update(viaje);
    }
    @Test
    public void testGetUno() throws SQLException {
        // Obtener la fecha actual del sistema
        Date fechaActual = new Date();

        // Convertir la fecha actual a java.sql.Date
        java.sql.Date fechaSQLActual = new java.sql.Date(fechaActual.getTime());

        // Configurar ResultSet simulado para getUno
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true); // Simular resultado del ResultSet
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("origen")).thenReturn("Zamora");
        when(mockResultSet.getString("destino")).thenReturn("Madrid");

        // Utilizar la fecha actual del sistema como fecha en el ResultSet simulado
        when(mockResultSet.getDate("fecha")).thenReturn(fechaSQLActual);

        PreparedStatement mockStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Ejecutar consulta de carga por ID
        Viaje viaje = modeloViaje.getUno(1);

        // Verificar que se llamó a setInt() en el PreparedStatement simulado
        verify(mockStatement).setInt(1, 1); // ID de la carga a consultar
        verify(mockStatement).executeQuery();

        // Verificar que se creó correctamente la carga
        assertEquals(1, viaje.getId());
        assertEquals("Zamora", viaje.getOrigen());
        assertEquals("Madrid", viaje.getDestino());

        // Verificar la fecha usando getTime() para comparar milisegundos
    }

    @Test

        public void testGetTodos() throws SQLException {
            // Obtener la fecha actual del sistema
            Date fechaActual = new Date();
            
            // Convertir la fecha actual a java.sql.Date
            java.sql.Date fechaSQLActual = new java.sql.Date(fechaActual.getTime());

            // Configurar ResultSet simulado para getTodos
            ResultSet mockResultSet = mock(ResultSet.class);
            when(mockResultSet.next()).thenReturn(true, false); // Simular múltiples resultados del ResultSet
            when(mockResultSet.getInt("id")).thenReturn(1); // ID de la carga
            when(mockResultSet.getString("origen")).thenReturn("Zamora");
            when(mockResultSet.getString("destino")).thenReturn("Madrid");

            // Usar la fecha actual del sistema como la fecha en el ResultSet simulado
            when(mockResultSet.getDate("fecha")).thenReturn(fechaSQLActual);

            PreparedStatement mockStatement = mock(PreparedStatement.class);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeQuery()).thenReturn(mockResultSet);

            // Ejecutar consulta de todas las cargas
            ArrayList<Viaje> viajes = modeloViaje.getTodos();

            // Verificar que se llamó a executeQuery() en el PreparedStatement simulado
            verify(mockStatement).executeQuery();

            // Verificar que se crearon las cargas correctamente
            assertEquals(1, viajes.size());
            Viaje viaje = viajes.get(0);
            assertEquals(1, viaje.getId());
            assertEquals("Zamora", viaje.getOrigen());
            assertEquals("Madrid", viaje.getDestino());
        }
    
    }






