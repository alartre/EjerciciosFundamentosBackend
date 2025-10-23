package org.scalian.ejerciciopropuesto;

import java.util.Comparator;
import java.util.List;

public class FiltroProductos {

    public static List<Producto> FilterPrecioMayor50 ( List<Producto> productolist){
        return productolist.stream()
                .filter( p -> p.precio() > 50)
                .toList();
    }
    public static List<Producto> NombreMayus ( List<Producto> productolist){
        return productolist.stream()
                .map( p -> new Producto(p.nombre().toUpperCase(), p.precio(), p.categoria()))
                .toList();
    }
    public static List<Producto> OrdenaPrecioDesc ( List<Producto> productolist){
        return productolist.stream()
                .sorted(Comparator.comparingDouble(Producto::precio).reversed())
                .toList();
    }
}
