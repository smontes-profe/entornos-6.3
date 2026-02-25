package com.entornos;

/**
 * Subclase de Vehiculo que representa una moto.
 * Relación: Herencia de Vehiculo.
 */
public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String matricula, String modelo, boolean tieneSidecar) {
        super(matricula, modelo);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    @Override
    public String toString() {
        return "Moto{matricula='" + matricula + "', modelo='" + modelo + "', tieneSidecar=" + tieneSidecar + '}';
    }
}
