package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    // La precarga de los productos
    static {
        productos.add(new Producto(1001, "Dulce de Leche La Serenisima 400g", 1200.00, 5000, 0));
        productos.add(new Producto(1002, "Fideos Giacomo capelettini 500g", 2500.00, 3000, 25));
        productos.add(new Producto(1003, "Arroz Luchetti 1Kg", 1800.00, 2000, 30));
    }

    public static void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static List<Producto> getProductos() {
        return productos;
    }
}