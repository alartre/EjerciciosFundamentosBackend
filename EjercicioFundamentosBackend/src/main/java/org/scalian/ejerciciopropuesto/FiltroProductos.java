package main.java.org.scalian.ejerciciopropuesto;

import main.java.org.scalian.ejerciciopropuesto.Producto;

import java.util.Comparator;
import java.util.List;

public class FiltroProductos {
    /**
     * Metodo para aplicar descuento sobre un precio dado
     * @param producto El producto a aplicar
     * @param newPrecio Precio nuevo del producto
     * @return El precio con el descuento aplciado
     */
    public static Producto AplicaDescuento (Producto producto, double newPrecio)
    {
        return new Producto(producto.nombre(), newPrecio, producto.categoria());
    }

    public static List<Producto> applyAllDiscount(List<Producto> products)
    {
        CalculadoraDescuento masDe100 = (product) -> {
            if(product.precio()>100) return product.precio()-(product.precio()*0.1);
            else return product.precio();
        };
        CalculadoraDescuento tecnoCat = (product) -> {
            if(product.categoria().equals("Tecnología"))
            {
                return product.precio()-(product.precio()*0.05);
            }
            else return product.precio();
        };
        return products.stream().
                map(p -> {
                    double precioConDescuento = masDe100.nuevoPrecio(p);
                    precioConDescuento = tecnoCat.nuevoPrecio(new Producto(p.nombre(), precioConDescuento, p.categoria()));
                    return AplicadorDescuentos.AplicaDescuento(p, precioConDescuento);
                })
                .toList();
    }

    public static List<Producto> getMoreThan50(List<Producto> products)
    {
        return products.stream().filter(x -> x.precio()>50).toList();
    }

    public static List<Producto> getSortedProducts(List<Producto> products)
    {
        return products.stream().
                sorted(Comparator.comparingDouble(Producto::precio).reversed())
                .toList();
    }

    public static List<String> turnToUpperCase(List<Producto> products)
    {
        return products.stream().map(Producto::nombre).map(String::toUpperCase).toList();
    }
}
