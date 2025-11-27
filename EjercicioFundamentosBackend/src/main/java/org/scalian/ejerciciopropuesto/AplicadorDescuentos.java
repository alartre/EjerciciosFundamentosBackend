package main.java.org.scalian.ejerciciopropuesto;

public class AplicadorDescuentos {
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
}
