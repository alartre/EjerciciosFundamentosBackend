package org.scalian.ejerciciopropuesto;

public record Producto(String nombre, double precio, String categoria){
    public Producto {
        if (nombre ==null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (precio<=0){
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
    }
}
