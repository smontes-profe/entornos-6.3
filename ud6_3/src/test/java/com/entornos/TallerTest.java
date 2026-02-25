package com.entornos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de Taller")
class TallerTest {

    private Taller taller;
    private Mecanico mecanico;
    private Coche coche;

    @BeforeEach
    void setUp() {
        taller = new Taller();
        mecanico = new Mecanico("EMP-007");
        coche = new Coche("4444DDD", "BMW Serie 3", 4);
    }

    @Test
    @DisplayName("asignarReparacion delega en el mecánico y añade al historial")
    void testAsignarReparacionAniadeAlHistorial() {
        assertTrue(coche.historial.isEmpty());

        taller.asignarReparacion(mecanico, coche);

        assertEquals(1, coche.historial.size());
    }

    @Test
    @DisplayName("Asignar dos reparaciones acumula dos entradas en el historial")
    void testDosReparaciones() {
        taller.asignarReparacion(mecanico, coche);
        taller.asignarReparacion(mecanico, coche);

        assertEquals(2, coche.historial.size());
    }

    @Test
    @DisplayName("asignarReparacion funciona con una Moto")
    void testAsignarReparacionAMoto() {
        Moto moto = new Moto("M555EEE", "Triumph Tiger", false);

        taller.asignarReparacion(mecanico, moto);

        assertEquals(1, moto.historial.size());
    }

    @Test
    @DisplayName("Distintos mecánicos pueden reparar el mismo vehículo")
    void testDistintosMecanicos() {
        Mecanico otro = new Mecanico("EMP-999");

        taller.asignarReparacion(mecanico, coche);
        taller.asignarReparacion(otro, coche);

        assertEquals(2, coche.historial.size());
    }
}
