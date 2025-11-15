/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Logica;

import Base.Pedido;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        Producto p1=new Producto("paneton", 20.9, 2);
        Producto p2=new Producto("Arroz", 10, 1);
        List<Producto> productos=new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        
        System.out.println(Pedido.calcularTotalPedido(productos, 10));
    }
}
