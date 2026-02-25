package com.entornos;

import java.time.LocalDate;

/**
 * Representa una reparación realizada sobre un vehículo.
 * Relación: Composición con Vehiculo (ciclo de vida ligado al vehículo).
 */
public class Reparacion {
    private LocalDate fecha;
    private String descripcion;
    private double coste;

    public Reparacion(LocalDate fecha, String descripcion, double coste) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.coste = coste;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "Reparacion{fecha=" + fecha + ", descripcion='" + descripcion + "', coste=" + coste + '}';
    }
}
