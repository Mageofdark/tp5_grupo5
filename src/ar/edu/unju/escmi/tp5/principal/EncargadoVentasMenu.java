package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class EncargadoVentasMenu {
    public static void mostrarMenu(java.util.Scanner scanner) {
        int opcion;
        do {
            System.out.println("===== MENU ENCARGADO DE VENTAS =====");
            System.out.println("1. Mostrar las ventas");
            System.out.println("2. Mostrar el total de todas las ventas (sumatoria de todas las ventas en $)");
            System.out.println("3. Verificar stock de un producto (ingresar codigo) ");
            System.out.println("4. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamar al metodo para Mostrar las ventas
                    System.out.println("Opcion de Mostrar las ventas seleccionada.");
                    CollectionFactura.getFacturas();
                    System.out.println("Las ventas realizadas son: " + CollectionFactura.getFacturas());
                    break;

                case 2:
                    // Llamar al metodo para Mostrar el total de todas las ventas
                    System.out.println("Opcion de Mostrar el total de todas las ventas seleccionada.");
                    CollectionFactura.calcularTotalVentas();
                    System.out.println("El total de todas las ventas es: $" + CollectionFactura.calcularTotalVentas());
                    break;

                case 3:
                    // Llamar al metodo para Verificcar stock de un producto
                    System.out.println("Opcion de Verificcar stock de un producto seleccionada.");
                    System.out.println("Ingrese codigo del producto a verificar: ");
                    int codigoProducto = scanner.nextInt();
                    CollectionProducto.buscarProducto(codigoProducto);
                    if (CollectionProducto.buscarProducto(codigoProducto) != null) {
                        System.out.println("Producto encontrado: " + CollectionProducto.buscarProducto(codigoProducto));
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al Menu Principal...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 4);
    }
    
}
