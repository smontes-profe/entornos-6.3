package com.entornos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Moto")
class MotoTest {

    @Test
    @DisplayName("Constructor asigna todos los campos - sin sidecar")
    void testConstructorSinSidecar() {
        Moto m = new Moto("M001ABC", "Honda CB500", false);

        assertEquals("M001ABC", m.matricula);
        assertEquals("Honda CB500", m.modelo);
        assertFalse(m.isTieneSidecar());
    }

    @Test
    @DisplayName("Constructor asigna todos los campos - con sidecar")
    void testConstructorConSidecar() {
        Moto m = new Moto("M002XYZ", "Ural Gear Up", true);
        assertTrue(m.isTieneSidecar());
    }

    @Test
    @DisplayName("Moto es instancia de Vehiculo (herencia)")
    void testEsVehiculo() {
        Moto m = new Moto("M003ZZZ", "Yamaha MT-07", false);
        assertInstanceOf(Vehiculo.class, m);
    }

    @Test
    @DisplayName("toString contiene matricula, modelo y tieneSidecar")
    void testToString() {
        Moto m = new Moto("M004AAA", "Kawasaki Z900", true);
        String s = m.toString();

        assertTrue(s.contains("M004AAA"));
        assertTrue(s.contains("Kawasaki Z900"));
        assertTrue(s.contains("true"));
    }
}
