package com.entornos;

import java.time.LocalDate;

/**
 * Mecánico que implementa la interfaz Especialista.
 * Relación: Realización de Especialista.
 */
public class Mecanico implements Especialista {
    private String idEmpleado;

    public Mecanico(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Realiza una reparación sobre el vehículo indicado y
     * la añade al historial de ese vehículo.
     */
    @Override
    public void reparar(Vehiculo v) {
        Reparacion reparacion = new Reparacion(
                LocalDate.now(),
                "Reparación por mecánico " + idEmpleado,
                0.0);
        v.historial.add(reparacion);
        System.out.println("Mecánico " + idEmpleado + " ha reparado: " + v.modelo);
    }

    @Override
    public String toString() {
        return "Mecanico{idEmpleado='" + idEmpleado + "'}";
    }
}
