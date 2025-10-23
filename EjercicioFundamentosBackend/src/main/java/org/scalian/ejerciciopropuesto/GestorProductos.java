import java.util.List;

public class GestorProductos {
    public static void main(String[] args) {

        Producto p1 = new Producto("Teclado", 120.0, "tecnología");
        Producto p2 = new Producto("Camiseta", 25.0, "ropa");
        Producto p3 = new Producto("Ratón", 60.0, "tecnología");
        Producto p4 = new Producto("Mesa", 150.0, "muebles");

        List<Producto> listaProductos = List.of(
               p1,
               p2,
               p3,
               p4
        );

        List<CalculadoraDescuento> descuentos = List.of(
                Descuentos.porCategoria,
                Descuentos.porPrecio
        );

        FiltroProductos filtros = new FiltroProductos();

        System.out.println("===GESTOR DE PRODUCTO===\n");
        System.out.println("Productos con precio > 50€:");
        filtros.filtrarPorPrecioMayorQue(listaProductos, 50)
                .forEach(p -> System.out.printf("- %s: %.1f€%n", p.nombre(), p.precio()));

        System.out.println("\nProductos con nombres en mayúsculas:");
        filtros.nombresEnMayusculas(listaProductos)
                .forEach(s -> System.out.println("- " + s));

        System.out.println("\nProductos ordenados por precio (descendente)");
        filtros.ordenarPorPrecioDesc(listaProductos)
                .forEach(p -> System.out.printf("- %s: %.1f€%n", p.nombre(), p.precio()));

        System.out.println("\nAplicando descuentos...");
        AplicadorDescuentos aplicarDescuento = new AplicadorDescuentos(descuentos);
        listaProductos.forEach(p -> {
            double precioFinal = aplicarDescuento.AplicarDescuentosSecuencial(p);
            System.out.printf("%s (%s): %.2f€ → %.2f€%n", p.nombre(), p.categoria(), p.precio(), precioFinal);
        });
        }
    }