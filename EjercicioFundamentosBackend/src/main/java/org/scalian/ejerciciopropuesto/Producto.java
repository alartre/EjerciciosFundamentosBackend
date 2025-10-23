public record Producto(String nombre, double precio, String categoria) {
    public Producto {
        if(nombre.isBlank() | nombre == null){
            throw new IllegalArgumentException("El nombre no puede ser null");
        }
        if(precio < 0){
            throw new IllegalArgumentException("El precio tiene que ser mayor que 0");
        }
    }
}
