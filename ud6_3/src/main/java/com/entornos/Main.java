package com.entornos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("=== Sistema de Gestión de Taller ===");

        // Crear un cliente
        Cliente cliente = new Cliente("12345678A", "Ana García");
        logger.info("Cliente creado: {} (DNI: {})", cliente.getNombre(), cliente.getDni());

        // Crear algunos vehículos
        Coche coche1 = new Coche("1234ABC", "Renault Clio", 5);
        Coche coche2 = new Coche("5678DEF", "Seat Ibiza", 3);

        // Asociar vehículos al cliente
        cliente.getVehiculos().add(coche1);
        cliente.getVehiculos().add(coche2);

        logger.info("Vehículos asociados:");
        for (Vehiculo v : cliente.getVehiculos()) {
            logger.info("- {}", v);
        }

        logger.info("=== Ejecución finalizada con éxito ===");
    }
}
