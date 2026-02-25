package com.entornos;

/**
 * Interfaz que define el contrato de un especialista en reparaciones.
 * Relación: Mecanico la implementa (Realización).
 */
public interface Especialista {
    void reparar(Vehiculo v);
}
