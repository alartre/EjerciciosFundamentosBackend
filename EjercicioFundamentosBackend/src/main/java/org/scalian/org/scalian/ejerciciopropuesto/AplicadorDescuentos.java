package org.scalian.ejerciciopropuesto;

public class AplicadorDescuentos {

    private CalculadoraDescuento calculadora;

    public AplicadorDescuentos(CalculadoraDescuento calculadora) {
        this.calculadora = calculadora;
    }

    public double aplicarDescuento(Producto producto) {
        return calculadora.aplicar(producto);
    }
}