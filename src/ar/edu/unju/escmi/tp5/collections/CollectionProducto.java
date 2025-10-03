package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Producto;
import java.util.Scanner;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    // la precarga de productos
    static {
        productos.add(new Producto(1001, "Dulce de Leche La Serenisima 400g", 1200.00f, 5000));
        productos.add(new Producto(1002, "Fideos Giacomo capelettini 500g", 2500.00f, 3000));
        productos.add(new Producto(1003, "Arroz Luchetti 1Kg", 1800.00f, 2000));
    }

    public static void altaProducto(Scanner scanner){
        System.out.println("Ingrese codigo del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva linea

        //Verificar si el producto ya existe
        if(buscarProducto(codigo) != null){
            System.out.println("El producto con codigo " + codigo + " ya existe.");
            return;
        }
        System.out.println("Ingrese nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese precio del producto: ");
        float precioUnitario = scanner.nextFloat();
        System.out.println("Ingrese stock del producto: ");
        int stock = scanner.nextInt();
        System.out.println("Ingrese codigo del producto: ");
        int codigoProducto = scanner.nextInt();


        Producto nuevoProducto = new Producto(codigoProducto, nombreProducto, precioUnitario, stock);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado exitosamente.");
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