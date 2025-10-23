import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroProductos {

    public List<Producto> filtrarPorPrecioMayorQue(List<Producto> productos, double limite) {
        return productos.stream()
                .filter(p -> p.precio() > limite)
                .collect(Collectors.toList());
    }

    public List<String> nombresEnMayusculas(List<Producto> productos) {
        return productos.stream()
                .map(p -> p.nombre().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Producto> ordenarPorPrecioDesc(List<Producto> productos) {
        return productos.stream()
                .sorted(Comparator.comparing(Producto::precio).reversed())
                .collect(Collectors.toList());
    }
}