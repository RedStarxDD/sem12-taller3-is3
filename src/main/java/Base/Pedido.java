/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import Grupo2.ServicioGrupo2;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Pedido {
    private List<Producto> detallesPedido=new ArrayList<>();
    
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
    
    public static double calcularTotalPedidoIntegrado(List<Producto> productos, double descuento, String cliente) {
        double total;
        
        if(!ServicioGrupo2.validarDescuento(descuento)){
            throw new IllegalArgumentException("Error: Descuento fuera del límite");
        }
        
        if(!ServicioGrupo2.validarCliente(cliente)){
            throw new IllegalArgumentException("Error: Cliente vacío");
        }
        
        if(!ServicioGrupo2.verificarStock(productos)){
            throw new IllegalArgumentException("Error: Producto con cantidad inválida");
        }
        
        try {
            total = calcularTotalPedido(productos, descuento);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error en función base");            
        }
        
        return ServicioGrupo2.calcularIGV(total);
    }
    
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            System.err.println("Error: La cantidad a agregar debe ser positiva.");
            return false;
        }
        
        if(!producto.isEsActivo()){
            System.err.println("Producto inactivo");
            return false;
        }
        
        // Busca si el producto ya existe en la lista 
        boolean productoYaExiste=false;
        if(!detallesPedido.isEmpty()) productoYaExiste = detallesPedido.stream()
                .anyMatch(p -> p.getNombre().equals(producto.getNombre()));
        if (productoYaExiste) {
            return false; // Falla porque ya existe 
        } else {
        // Creamos una nueva instancia con la cantidad especificada y la añadimos a la lista 
            detallesPedido.add(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
            return true;
        }
    }

    public boolean validarStock() {
        if(detallesPedido.isEmpty()){
            return false;
        }
        
        for (Producto p : detallesPedido) {
            if (p.getCantidad() <= 0) {
                return false;
            }
        }
        return true;
    }

    public List<Producto> getDetallesPedido() {
        return detallesPedido;
    }
    
    
}