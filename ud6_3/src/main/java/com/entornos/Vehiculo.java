package com.entornos;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    protected String matricula;
    protected String modelo;
    protected List<Reparacion> historial; // Composición: se gestiona aquí

    public Vehiculo(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.historial = new ArrayList<>();
    }
}