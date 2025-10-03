package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    // la precarga de productos
    static {
        productos.add(new Producto(1001, "Dulce de Leche La Serenisima 400g", 1200.00f, 5000));
        productos.add(new Producto(1002, "Fideos Giacomo capelettini 500g", 2500.00f, 3000));
        productos.add(new Producto(1003, "Arroz Luchetti 1Kg", 1800.00f, 2000));
    }

    public static void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static List<Producto> getProductos() {
        return productos;
    }
}