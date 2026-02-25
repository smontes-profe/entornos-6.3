package com.entornos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Taller ===");

        // Crear un cliente
        Cliente cliente = new Cliente("12345678A", "Ana García");
        System.out.println("Cliente creado: " + cliente.getNombre() + " (DNI: " + cliente.getDni() + ")");

        // Crear algunos vehículos
        Coche coche1 = new Coche("1234ABC", "Renault Clio", 5);
        Coche coche2 = new Coche("5678DEF", "Seat Ibiza", 3);

        // Asociar vehículos al cliente
        cliente.getVehiculos().add(coche1);
        cliente.getVehiculos().add(coche2);

        System.out.println("\nVehículos asociados:");
        for (Vehiculo v : cliente.getVehiculos()) {
            System.out.println("- " + v.toString());
        }

        System.out.println("\n=== Ejecución finalizada con éxito ===");
    }
}
