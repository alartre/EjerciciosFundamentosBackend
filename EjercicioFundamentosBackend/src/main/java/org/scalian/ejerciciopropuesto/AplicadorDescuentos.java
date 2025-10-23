package org.scalian.ejerciciopropuesto;

import java.util.List;
public class AplicadorDescuentos {
    private final List<CalculadoraDescuento> estrategias;

    public AplicadorDescuentos( List<CalculadoraDescuento> estrategias){
        this.estrategias = List.copyOf(estrategias);
    }

    public double aplicaDescuento(Producto producto){
        //si no tiene descuento, inicializo con precio inicial
        double preciofin = producto.precio();
        for ( CalculadoraDescuento estrategias : estrategias){
            preciofin = estrategias.calcular(new Producto(producto.nombre(), preciofin, producto.categoria()));
        }

        return preciofin;
    }
}
