package com.example.formasgeometricas.controller;


import com.example.formasgeometricas.model.Circulo;

public class CirculoController implements IGeometriaController<Circulo>{
    @Override
    public float calcularArea(Circulo circulo) {
        return (float) (Math.PI * Math.pow(circulo.getRaio(), 2));
    }

    @Override
    public float calcularPerimetro(Circulo circulo) {
        return 2 * (float) (Math.PI * circulo.getRaio());
    }
}
