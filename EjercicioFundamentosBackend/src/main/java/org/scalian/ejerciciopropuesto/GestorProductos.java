package org.scalian.ejerciciopropuesto;

import java.util.List;

public class GestorProductos {

    public static void main(String[] args) {
        CalculadoraDescuento descuentoPrecio =
                p -> p.precio() > 100 ? p.precio() * 0.9 : p.precio();

        CalculadoraDescuento descuentotecnologia =
                p -> p.categoria().equalsIgnoreCase("tecnología") ? p.precio() * 0.95 : p.precio();

        CalculadoraDescuento descuentolibros =
                p -> p.categoria().equalsIgnoreCase("libros") ? p.precio() * 0.97 : p.precio();

        AplicadorDescuentos aplicador = new AplicadorDescuentos(
                List.of(descuentoPrecio, descuentotecnologia, descuentolibros)
        );

        List<Producto> productoList = List.of (
                new Producto("Portátil", 1000, "tecnología"),
                new Producto("Pizzas", 20, "comida"),
                new Producto("Camiseta", 12, "ropa"),
                new Producto("Auriculares", 150, "tecnología"),
                new Producto("Libro", 9, "libros"),
                new Producto("Smartphone", 700, "tecnología")
        );

        System.out.println( " --- Productos de más de 50€ ---");
         FiltroProductos.FilterPrecioMayor50(productoList)
                 .forEach(p -> System.out.println(p.nombre() + " - " + p.precio() + "€"));

        System.out.println( " --- Nombre Mayúscula ---");
        FiltroProductos.NombreMayus(productoList)
                .forEach(p -> System.out.println(p.nombre()));

        System.out.println( " --- Productos ordenados ---");
        FiltroProductos.OrdenaPrecioDesc(productoList)
                .forEach(p -> System.out.println(p.nombre() + " - " + p.precio() + "€"));

        System.out.println( " --- Descuentos ---");

        productoList.stream()
                .forEach(p -> {
                            double preciodescuento = aplicador.aplicaDescuento(p);
                            System.out.println(p.nombre() + " Precio Inical " + p.precio() + "€ -- Precio Final " + preciodescuento + " €");
                        }
                );

    }
}
