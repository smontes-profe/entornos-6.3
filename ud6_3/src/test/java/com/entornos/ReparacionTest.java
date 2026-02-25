package com.entornos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Reparacion")
class ReparacionTest {

    @Test
    @DisplayName("Constructor asigna los campos correctamente")
    void testConstructorYGetters() {
        LocalDate fecha = LocalDate.of(2024, 3, 15);
        Reparacion r = new Reparacion(fecha, "Cambio de aceite", 75.50);

        assertEquals(fecha, r.getFecha());
        assertEquals("Cambio de aceite", r.getDescripcion());
        assertEquals(75.50, r.getCoste(), 0.001);
    }

    @Test
    @DisplayName("El coste puede ser cero")
    void testCosteCero() {
        Reparacion r = new Reparacion(LocalDate.now(), "Revisión", 0.0);
        assertEquals(0.0, r.getCoste(), 0.001);
    }

    @Test
    @DisplayName("toString contiene los datos de la reparacion")
    void testToString() {
        LocalDate fecha = LocalDate.of(2024, 6, 1);
        Reparacion r = new Reparacion(fecha, "Frenos", 120.0);
        String resultado = r.toString();

        assertTrue(resultado.contains("2024-06-01"));
        assertTrue(resultado.contains("Frenos"));
        assertTrue(resultado.contains("120.0"));
    }

    @Test
    @DisplayName("Dos reparaciones con misma fecha son independientes")
    void testReparacionesIndependientes() {
        LocalDate hoy = LocalDate.now();
        Reparacion r1 = new Reparacion(hoy, "Ruedas", 200.0);
        Reparacion r2 = new Reparacion(hoy, "Motor", 500.0);

        assertNotEquals(r1.getDescripcion(), r2.getDescripcion());
        assertNotEquals(r1.getCoste(), r2.getCoste(), 0.001);
    }
}
