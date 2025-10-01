package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionStock {

    public static boolean actualizarStock(int codigo, int cantidad) {
        Producto producto = CollectionProducto.buscarProducto(codigo);
        if (producto != null && producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            return true;
        }
        return false;
    }
}