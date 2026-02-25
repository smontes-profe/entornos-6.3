package com.entornos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Coche")
class CocheTest {

    @Test
    @DisplayName("Constructor asigna todos los campos")
    void testConstructor() {
        Coche c = new Coche("5678XYZ", "Seat Ibiza", 5);

        assertEquals("5678XYZ", c.matricula);
        assertEquals("Seat Ibiza", c.modelo);
        assertEquals(5, c.getNumPuertas());
    }

    @Test
    @DisplayName("Coche con 2 puertas (cupé)")
    void testCocheDossPuertas() {
        Coche c = new Coche("9999ZZZ", "Toyota GR86", 2);
        assertEquals(2, c.getNumPuertas());
    }

    @Test
    @DisplayName("Coche es instancia de Vehiculo (herencia)")
    void testEsVehiculo() {
        Coche c = new Coche("0000AAA", "Honda Civic", 4);
        assertInstanceOf(Vehiculo.class, c);
    }

    @Test
    @DisplayName("toString contiene matricula, modelo y numPuertas")
    void testToString() {
        Coche c = new Coche("1111BBB", "Renault Clio", 5);
        String s = c.toString();

        assertTrue(s.contains("1111BBB"));
        assertTrue(s.contains("Renault Clio"));
        assertTrue(s.contains("5"));
    }
}
