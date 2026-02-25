package com.entornos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Cliente")
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("12345678A", "Ana García");
    }

    // ──────────────────────────────────────────────
    // Constructor
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Constructor crea un cliente no nulo")
    void testConstructorNoNulo() {
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Constructor asigna el DNI correctamente")
    void testConstructorDni() {
        assertEquals("12345678A", cliente.getDni());
    }

    @Test
    @DisplayName("Constructor asigna el nombre correctamente")
    void testConstructorNombre() {
        assertEquals("Ana García", cliente.getNombre());
    }

    @Test
    @DisplayName("Constructor inicializa la lista de vehículos vacía y no nula")
    void testConstructorListaVehiculosVacia() {
        List<Vehiculo> vehiculos = cliente.getVehiculos();
        assertNotNull(vehiculos);
        assertTrue(vehiculos.isEmpty());
    }

    // ──────────────────────────────────────────────
    // Getters
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("getDni devuelve el DNI correcto")
    void testGetDni() {
        assertEquals("12345678A", cliente.getDni());
    }

    @Test
    @DisplayName("getNombre devuelve el nombre correcto")
    void testGetNombre() {
        assertEquals("Ana García", cliente.getNombre());
    }

    @Test
    @DisplayName("getVehiculos devuelve la lista de vehículos")
    void testGetVehiculos() {
        assertNotNull(cliente.getVehiculos());
    }

    // ──────────────────────────────────────────────
    // Setters
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("setDni actualiza el DNI correctamente")
    void testSetDni() {
        cliente.setDni("87654321B");
        assertEquals("87654321B", cliente.getDni());
    }

    @Test
    @DisplayName("setNombre actualiza el nombre correctamente")
    void testSetNombre() {
        cliente.setNombre("Luis Martínez");
        assertEquals("Luis Martínez", cliente.getNombre());
    }

    @Test
    @DisplayName("setVehiculos reemplaza la lista de vehículos completa")
    void testSetVehiculos() {
        List<Vehiculo> nuevaLista = new ArrayList<>();
        nuevaLista.add(new Coche("1234ABC", "Renault Clio", 5));
        nuevaLista.add(new Coche("5678DEF", "Seat Ibiza", 3));

        cliente.setVehiculos(nuevaLista);

        assertEquals(2, cliente.getVehiculos().size());
        assertSame(nuevaLista, cliente.getVehiculos());
    }

    @Test
    @DisplayName("setVehiculos con lista vacía deja la lista vacía")
    void testSetVehiculosListaVacia() {
        cliente.setVehiculos(new ArrayList<>());
        assertTrue(cliente.getVehiculos().isEmpty());
    }

    // ──────────────────────────────────────────────
    // Lista de vehículos (manipulación directa)
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Se puede añadir un vehículo a la lista del cliente")
    void testAnadirVehiculo() {
        Vehiculo coche = new Coche("9999ZZZ", "Toyota Yaris", 5);
        cliente.getVehiculos().add(coche);

        assertEquals(1, cliente.getVehiculos().size());
        assertSame(coche, cliente.getVehiculos().get(0));
    }

    @Test
    @DisplayName("Se pueden añadir varios vehículos a la lista del cliente")
    void testAnadirVariosVehiculos() {
        cliente.getVehiculos().add(new Coche("AAA000", "Ford Focus", 5));
        cliente.getVehiculos().add(new Coche("BBB111", "Opel Astra", 3));
        cliente.getVehiculos().add(new Coche("CCC222", "BMW Serie 1", 5));

        assertEquals(3, cliente.getVehiculos().size());
    }

    // ──────────────────────────────────────────────
    // Casos límite
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("Se pueden crear dos clientes distintos independientes")
    void testDosClientesDistintos() {
        Cliente c1 = new Cliente("11111111A", "Pedro Ruiz");
        Cliente c2 = new Cliente("22222222B", "María López");

        assertNotSame(c1, c2);
        assertNotEquals(c1.getDni(), c2.getDni());
        assertNotEquals(c1.getNombre(), c2.getNombre());
    }

    @Test
    @DisplayName("Cliente con DNI vacío se crea sin excepción")
    void testClienteDniVacio() {
        assertDoesNotThrow(() -> new Cliente("", "Sin DNI"));
    }

    @Test
    @DisplayName("Cliente con nombre vacío se crea sin excepción")
    void testClienteNombreVacio() {
        assertDoesNotThrow(() -> new Cliente("00000000X", ""));
    }

    @Test
    @DisplayName("setDni con cadena vacía no lanza excepción")
    void testSetDniVacio() {
        assertDoesNotThrow(() -> cliente.setDni(""));
        assertEquals("", cliente.getDni());
    }

    @Test
    @DisplayName("setNombre con cadena vacía no lanza excepción")
    void testSetNombreVacio() {
        assertDoesNotThrow(() -> cliente.setNombre(""));
        assertEquals("", cliente.getNombre());
    }

    @Test
    @DisplayName("Las listas de vehículos de dos clientes son independientes")
    void testListasVehiculosIndependientes() {
        Cliente c1 = new Cliente("11111111A", "Pedro");
        Cliente c2 = new Cliente("22222222B", "María");

        c1.getVehiculos().add(new Coche("XXX000", "Audi A3", 5));

        assertTrue(c2.getVehiculos().isEmpty(),
                "La lista del segundo cliente no debe verse afectada por el primero");
    }
}
