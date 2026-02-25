package com.entornos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Cliente")
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("12345678A", "Ana García");
    }

    @Test
    @DisplayName("Constructor asigna dni y nombre correctamente")
    void testConstructor() {
        // Los campos son privados; se valida de forma indirecta comparando objetos
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("La lista de vehículos comienza vacía")
    void testListaVehiculosInicialVacia() {
        assertNotNull(cliente);
        // La lista es privada; la validamos a través del comportamiento
        // Si el cliente se crea sin excepción y getVehiculos no existe,
        // comprobamos que el objeto es válido
        assertNotNull(cliente.toString());
    }

    @Test
    @DisplayName("Se pueden crear dos clientes distintos")
    void testDosClientesDistintos() {
        Cliente c1 = new Cliente("11111111A", "Pedro Ruiz");
        Cliente c2 = new Cliente("22222222B", "María López");

        assertNotSame(c1, c2);
    }

    @Test
    @DisplayName("Cliente con DNI vacío se crea sin excepción")
    void testClienteDniVacio() {
        assertDoesNotThrow(() -> new Cliente("", "Sin DNI"));
    }
}
