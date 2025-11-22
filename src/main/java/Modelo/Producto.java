/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Producto {
    private String nombre, sku, categoria;
    private double precio;
    private int cantidad;
    private boolean esActivo, descuentoAplicable;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String nombre, String sku, String categoria, double precio, boolean esActivo, boolean descuentoAplicable) {
        this.nombre = nombre;
        this.sku = sku;
        this.categoria = categoria;
        this.precio = precio;
        this.esActivo = esActivo;
        this.descuentoAplicable = descuentoAplicable;
    }

    public Producto(String nombre, String sku, String categoria, double precio, int cantidad, boolean esActivo, boolean descuentoAplicable) {
        this.nombre = nombre;
        this.sku = sku;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.esActivo = esActivo;
        this.descuentoAplicable = descuentoAplicable;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio>=0){
            this.precio = precio;  
        }else{
            throw new IllegalArgumentException("Precio inválido");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad=cantidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public boolean isDescuentoAplicable() {
        return descuentoAplicable;
    }

    public void setDescuentoAplicable(boolean descuentoAplicable) {
        this.descuentoAplicable = descuentoAplicable;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.sku);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.sku, other.sku);
    }
    
    
}
