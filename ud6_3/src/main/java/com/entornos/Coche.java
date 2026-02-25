package com.entornos;

/**
 * Subclase de Vehiculo que representa un coche.
 * Relación: Herencia de Vehiculo.
 */
public class Coche extends Vehiculo {
    private int numPuertas;

    public Coche(String matricula, String modelo, int numPuertas) {
        super(matricula, modelo);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    @Override
    public String toString() {
        return "Coche{matricula='" + matricula + "', modelo='" + modelo + "', numPuertas=" + numPuertas + '}';
    }
}
