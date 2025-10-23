import java.util.List;

public class AplicadorDescuentos {
    private final List<CalculadoraDescuento> estrategias;

    public AplicadorDescuentos(List<CalculadoraDescuento> estrategias){
        this.estrategias = estrategias;
    }

    double AplicarDescuentosSecuencial(Producto producto) {
        double precioActual = producto.precio();
        for (CalculadoraDescuento estrategia : estrategias) {
            Producto P = new Producto(producto.nombre(), precioActual, producto.categoria());
            precioActual = estrategia.calcularDescuento(P);
        }

        return precioActual;
    }

}
