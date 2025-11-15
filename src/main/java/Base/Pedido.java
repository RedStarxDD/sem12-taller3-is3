/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author user
 */
public class Pedido {
    public static double calcularTotalPedido(List<Producto> productos, double descuento) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }
        double subtotal = productos.stream()
            .mapToDouble(p -> p.getPrecio() * p.getCantidad())
            .sum();
        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }
            return subtotal - (subtotal * (descuento / 100));
    }
}