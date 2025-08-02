package com.negocio.models;

// ERROR 1: Atributos públicos (Mala práctica de encapsulamiento)
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    // ERROR 2: Constructor sin validaciones
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        if (stock < 0) {
            throw new IllegalArgumentException("El Stock es Negativo :(");
        }
        this.stock = stock;
        this.precio = precio;
    }

    // ERROR 3: Método que permite stock negativo
    public void reducirStock(int cantidad) {
        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser positiva:(");
        }
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("El stock es insuficiente:(");
        }
    }

    // ERROR 4: Método con lógica incorrecta
    public boolean hayStock(int cantidad) {
        return stock >= cantidad; // Debería ser >= para permitir exactamente la cantidad
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public int getStock() {
        return stock;
    }
}
