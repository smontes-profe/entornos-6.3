package com.entornos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Vehiculo (clase abstracta, testada via Coche)")
class VehiculoTest {

    private Coche coche;

    @BeforeEach
    void setUp() {
        coche = new Coche("1234ABC", "Toyota Corolla", 4);
    }

    @Test
    @DisplayName("La matricula y modelo se asignan en el constructor")
    void testConstructorBase() {
        assertEquals("1234ABC", coche.matricula);
        assertEquals("Toyota Corolla", coche.modelo);
    }

    @Test
    @DisplayName("El historial comienza vacío")
    void testHistorialInicialVacio() {
        assertNotNull(coche.historial);
        assertTrue(coche.historial.isEmpty());
    }

    @Test
    @DisplayName("Se pueden añadir reparaciones al historial")
    void testAgregarReparacionAlHistorial() {
        Reparacion r = new Reparacion(LocalDate.now(), "Cambio filtro", 40.0);
        coche.historial.add(r);

        assertEquals(1, coche.historial.size());
        assertEquals("Cambio filtro", coche.historial.get(0).getDescripcion());
    }

    @Test
    @DisplayName("El historial puede acumular múltiples reparaciones")
    void testMultiplesReparaciones() {
        coche.historial.add(new Reparacion(LocalDate.now(), "Aceite", 50.0));
        coche.historial.add(new Reparacion(LocalDate.now(), "Frenos", 150.0));
        coche.historial.add(new Reparacion(LocalDate.now(), "Ruedas", 300.0));

        assertEquals(3, coche.historial.size());
    }
}
