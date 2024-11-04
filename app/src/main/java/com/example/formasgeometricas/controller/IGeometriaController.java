package com.example.formasgeometricas.controller;

public interface IGeometriaController<T> {
    float calcularArea(T figura);
    float calcularPerimetro(T figura);
}