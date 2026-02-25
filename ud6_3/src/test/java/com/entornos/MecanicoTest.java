package com.entornos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Mecanico")
class MecanicoTest {

    private Mecanico mecanico;
    private Coche coche;

    @BeforeEach
    void setUp() {
        mecanico = new Mecanico("EMP-001");
        coche = new Coche("9999ZZZ", "Ford Focus", 4);
    }

    @Test
    @DisplayName("Constructor asigna el idEmpleado")
    void testConstructor() {
        assertEquals("EMP-001", mecanico.getIdEmpleado());
    }

    @Test
    @DisplayName("Mecanico implementa Especialista")
    void testImplementaEspecialista() {
        assertInstanceOf(Especialista.class, mecanico);
    }

    @Test
    @DisplayName("reparar añade una entrada al historial del vehículo")
    void testRepararAniadeAlHistorial() {
        assertTrue(coche.historial.isEmpty());

        mecanico.reparar(coche);

        assertEquals(1, coche.historial.size());
    }

    @Test
    @DisplayName("reparar dos veces añade dos entradas al historial")
    void testRepararVariasVeces() {
        mecanico.reparar(coche);
        mecanico.reparar(coche);

        assertEquals(2, coche.historial.size());
    }

    @Test
    @DisplayName("La reparación registrada tiene la fecha de hoy")
    void testReparacionTieneFechaHoy() {
        mecanico.reparar(coche);

        java.time.LocalDate hoy = java.time.LocalDate.now();
        assertEquals(hoy, coche.historial.get(0).getFecha());
    }

    @Test
    @DisplayName("reparar funciona también sobre una Moto")
    void testRepararMoto() {
        Moto moto = new Moto("M999ZZZ", "Ducati Monster", false);
        mecanico.reparar(moto);

        assertEquals(1, moto.historial.size());
    }

    @Test
    @DisplayName("toString incluye el idEmpleado")
    void testToString() {
        assertTrue(mecanico.toString().contains("EMP-001"));
    }
}
