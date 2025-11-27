package org.scalian.ejerciciopropuesto;

public class Descuentos {

    public static CalculadoraDescuento descuentoMayor100 = p -> p.precio() > 100 ? p.precio() * 0.9 : p.precio();

    public static CalculadoraDescuento descuentoTecnologia =
            p -> p.categoria().equalsIgnoreCase("tecnología")
                    ? p.precio() * 0.95
                    : p.precio();
}
