public class Descuentos {
    public static final CalculadoraDescuento porPrecio = product -> {
        if(product.precio() > 100){
            return product.precio() * 0.9;
        }
        return product.precio();
    };

    public static final CalculadoraDescuento porCategoria = product -> {
        if("tecnología".equalsIgnoreCase(product.categoria())){
            return product.precio() * 0.95;
        }
        return product.precio();
    };
}
