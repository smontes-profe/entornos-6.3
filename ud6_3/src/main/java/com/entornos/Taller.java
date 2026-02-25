package com.entornos;

/**
 * Clase Taller que coordina las reparaciones.
 * Relación: Dependencia con Mecanico (lo usa puntualmente).
 */
public class Taller {

    /**
     * Asigna una reparación a un mecánico para que la realice sobre un vehículo.
     *
     * @param m el mecánico que realizará la reparación
     * @param v el vehículo que será reparado
     */
    public void asignarReparacion(Mecanico m, Vehiculo v) {
        System.out.println("Taller: asignando reparación del vehículo " + v.modelo
                + " al mecánico " + m.getIdEmpleado());
        m.reparar(v);
    }
}
