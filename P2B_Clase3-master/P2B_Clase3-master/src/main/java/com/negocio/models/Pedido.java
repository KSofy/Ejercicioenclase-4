package com.negocio.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private List<DetallePedido> detalles;
    private LocalDateTime fecha;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.detalles = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void agregarProducto(Producto producto, int cantidad) {
        detalles.add(new DetallePedido(producto, cantidad));
        calcularTotal();
    }

    // ERROR 5: Cálculo incorrecto del total (suma precios sin considerar cantidades)
    private void calcularTotal() {
        total = 0;
        for (DetallePedido detalle : detalles) {
            total += detalle.getSubtotal(); // Suma solo el precio, no considera cantidad
        }
    }

    // ERROR 6: Método que puede causar IndexOutOfBoundsException
    public Producto obtenerPrimerProducto() {
        if (productos.isEmpty()) {
            return null;
        }
        return productos.get(0);

    }

    // ERROR 7: Descuento mal aplicado
    public void aplicarDescuento(DescuentoAplicable descuento) {
        this.total = descuento.aplicarDescuento(total);
    }


    // Getters
    public int getId() { return id; }
    public List<Producto> getProductos() { return productos; }
    public LocalDateTime getFecha() { return fecha; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        int cantidadProductos = (productos != null) ? productos.size() : 0;
        String nombreCliente = (cliente != null) ? cliente.getNombre() : "Sin cliente";
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + nombreCliente +
                ", productos=" + productos.size() +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
