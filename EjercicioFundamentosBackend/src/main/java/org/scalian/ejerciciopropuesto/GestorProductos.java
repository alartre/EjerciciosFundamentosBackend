package main.java.org.scalian.ejerciciopropuesto;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {

    //Tendrá el main que ejecutará la aplicación
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Teclado",120,"Tecnología"));
        listaProductos.add(new Producto("Raton",60,"Tecnología"));
        listaProductos.add(new Producto("Mesa",150,"Misc"));
        listaProductos.add(new Producto("Camiseta",25,"Misc"));

        System.out.println("=====GESTOR DE PRODUCTOS=====");

        System.out.println("Productos con precio > 50€:");
        List<Producto> mayorQue50;
        mayorQue50 = FiltroProductos.getMoreThan50(listaProductos);
        mayorQue50.forEach(pr -> System.out.println("- "+ pr.nombre()+": "+ pr.precio()));
        System.out.println();

        System.out.println("Productos en mayuscula:");
        List<String> mayusculas;
        mayusculas = FiltroProductos.turnToUpperCase(listaProductos);
        mayusculas.forEach(name -> System.out.println("-"+name));
        System.out.println();

        System.out.println("Productos por precio descendendete:");
        List<Producto> sortedProds;
        sortedProds = FiltroProductos.getSortedProducts(listaProductos);
        sortedProds.forEach(pr -> System.out.println("- "+ pr.nombre()+": "+ pr.precio()));
        System.out.println();

        System.out.println("Aplicando descuentos:");
        List<Producto> discountedProds;
        discountedProds = FiltroProductos.applyAllDiscount(listaProductos);
        discountedProds.forEach(pr -> System.out.println("- "+ pr.nombre()+": "+ pr.precio()));
        System.out.println();
    }
}
