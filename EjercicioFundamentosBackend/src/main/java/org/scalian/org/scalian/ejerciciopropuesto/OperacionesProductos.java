package org.scalian.ejerciciopropuesto;

import java.util.Comparator;
import java.util.List;

public class OperacionesProductos {

    public static List<Producto> filtrarMayor50(List<Producto> productos) {

        return productos.stream()

                .filter(p -> p.precio() > 50)

                .toList();

    }

    public static List<Producto> nombresMayus(List<Producto> productos) {

        return productos.stream()

                .map(p -> new Producto(

                        p.nombre().toUpperCase(),

                        p.precio(),

                        p.categoria()

                ))

                .toList();

    }

    public static List<Double> preciosFinales(List<Producto> productos, CalculadoraDescuento descuento) {

        AplicadorDescuentos aplicador = new AplicadorDescuentos(descuento);


        return productos.stream()

                .map(aplicador::aplicarDescuento)

                .toList();

    }

    public static void imprimirOrdenadosDesc(List<Producto> productos) {

        productos.stream()

                .sorted(Comparator.comparing(Producto::precio).reversed())

                .forEach(System.out::println);

    }

}
