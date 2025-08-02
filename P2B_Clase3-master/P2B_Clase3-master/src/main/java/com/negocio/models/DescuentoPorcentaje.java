package com.negocio.models;

public class DescuentoPorcentaje implements DescuentoAplicable {
    private double porcentaje;
    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    @Override
    public double aplicarDescuento(double total) {
        double montoDescuento = total*porcentaje / 100;
                return total -  montoDescuento;
    }
}
