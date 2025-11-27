package org.scalian;

import org.scalian.ejerciciopropuesto.AplicadorDescuentos;
import org.scalian.ejerciciopropuesto.CalculadoraDescuento;
import org.scalian.ejerciciopropuesto.Producto;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Producto> productos = List.of(
                new Producto("Teclado", 120.0, "tecnología"),
                new Producto("Camiseta", 25.0, "ropa"),
                new Producto("Ratón", 60.0, "tecnología"),
                new Producto("Mesa", 150.0, "muebles")
        );

        CalculadoraDescuento descuentoMayor100 =
                p -> p.precio() > 100 ? p.precio() * 0.90 : p.precio();

        CalculadoraDescuento descuentoTecnologia =
                p -> p.categoria().equalsIgnoreCase("tecnología")
                        ? p.precio() * 0.95
                        : p.precio();

        AplicadorDescuentos aplicadorMayor100 = new AplicadorDescuentos(descuentoMayor100);
        AplicadorDescuentos aplicadorTecnologia = new AplicadorDescuentos(descuentoTecnologia);

        System.out.println("=== GESTOR DE PRODUCTOS ===");
        System.out.println();


        System.out.println("Productos con precio > 50€:");
        System.out.println();

        productos.stream()
                .filter(p -> p.precio() > 50)
                .forEach(p -> {
                    System.out.println("- " + p.nombre() + ": " + p.precio() + "€");
                    System.out.println();
                });

        System.out.println("Productos con nombres en mayúsculas:");
        System.out.println();

        productos.stream()
                .map(p -> p.nombre().toUpperCase())
                .forEach(nombre -> {
                    System.out.println("- " + nombre);
                    System.out.println();
                });

        System.out.println("Productos ordenados por precio (descendente):");
        System.out.println();

        productos.stream()
                .sorted(Comparator.comparing(Producto::precio).reversed())
                .forEach(p -> {
                    System.out.println("- " + p.nombre() + ": " + p.precio() + "€");
                    System.out.println();
                });

        System.out.println("Aplicando descuentos...");
        System.out.println();

        productos.forEach(p -> {

            double precioTrasMayor100 = aplicadorMayor100.aplicarDescuento(p);

            Producto productoTrasMayor100 = new Producto(
                    p.nombre(),
                    precioTrasMayor100,
                    p.categoria()
            );


            double precioFinal = aplicadorTecnologia.aplicarDescuento(productoTrasMayor100);

            System.out.printf("%s (%s): %.2f€ → %.2f€%n",
                    p.nombre(),
                    p.categoria(),
                    p.precio(),
                    precioFinal);
            System.out.println();
        });
    }
}