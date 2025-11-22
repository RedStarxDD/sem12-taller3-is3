/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Grupo2;

import Base.Pedido;
import Modelo.Producto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RedStar
 */
public class PedidoPCTest {
    private Pedido pedido;
    private Producto pValido;
    
    @BeforeEach
    public void iniciar(){
        pedido=new Pedido();
        pValido=new Producto("Panetón", "1234", "Panadería", 20.0, true, true);
    }
    
    @Test
    public void productoCantidadInvalidaTest(){
        assertFalse(pedido.agregarProducto(pValido, 0));
    }
    
    @Test
    public void productoSkuDuplicadoTest(){
        pedido.agregarProducto(pValido, 10);
        assertFalse(pedido.agregarProducto(pValido, 10));
    }
    
    @Test
    public void productoAgregadoCorrectoTest(){
        assertTrue(pedido.agregarProducto(pValido, 10));
    }
    
    @Test
    public void productoConAtributosPreservadosTest(){
        pValido.setCantidad(10);
        pedido.agregarProducto(pValido, 10);
        Producto actual=pedido.getDetallesPedido().getFirst();
        assertEquals(pValido, actual);
    }
    
    //Se decidió no admitir productos inactivos
    @Test
    public void productoInactivoTest(){
        pValido.setEsActivo(false);
        assertFalse(pedido.agregarProducto(pValido, 10));
    }
    
    @Test
    public void pedidoVacioTest(){
        assertFalse(pedido.validarStock());
    }
    
    @Test
    public void pedidoConStockValidoTest(){
        pedido.agregarProducto(pValido, 10);
        assertTrue(pedido.validarStock());
    }
      
    @Test
    public void pedidoConStockLimiteTest(){
        pedido.agregarProducto(pValido, 1);
        assertTrue(pedido.validarStock());
    }    
}
