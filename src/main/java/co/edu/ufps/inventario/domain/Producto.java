package co.edu.ufps.inventario.domain;
public record Producto(String nombre,TipoProducto tipo,int stock,int stockMinimo) { }
