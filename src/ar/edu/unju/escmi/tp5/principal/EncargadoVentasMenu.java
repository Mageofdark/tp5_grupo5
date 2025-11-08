package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class EncargadoVentasMenu {
    public static void mostrarMenu(java.util.Scanner scanner) {
        System.out.print("Ingrese ID del encargado de ventas: ");
        int idEmpleado = scanner.nextInt();
        ar.edu.unju.escmi.tp5.dominio.Empleado empleado = ar.edu.unju.escmi.tp5.collections.CollectionEmpleado.buscarEmpleado(idEmpleado);
        if (empleado == null || !(empleado instanceof ar.edu.unju.escmi.tp5.dominio.EncargadoVentas)) {
            System.out.println("Empleado no encontrado o no es Encargado de Ventas. Acceso denegado.");
            return;
        }

        System.out.println("Encargado de ventas autenticado: " + empleado.getNombre() + " " + empleado.getApellido());
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
                    System.out.println("LISTADO DE TODAS LAS VENTAS");
                    if (CollectionFactura.getFacturas().isEmpty()){
                        System.out.println("No hay ventas registradas. ");
                    } else {
                        for (ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura factura : CollectionFactura.getFacturas()) {
                            System.out.println(factura);
                        }
                    }

                    break;

                case 2:
                    System.out.println("Opcion de Mostrar el total de todas las ventas seleccionada.");
                    System.out.println("El total de todas las ventas es: $" + ar.edu.unju.escmi.tp5.collections.CollectionFactura.calcularTotalVentas());
                    break;

                case 3:
                    System.out.println("Opcion de Verificcar stock de un producto seleccionada.");
                    System.out.print("Ingrese codigo del producto a verificar: ");
                    int codigoProducto = scanner.nextInt();
                    ar.edu.unju.escmi.tp5.dominio.Producto p = ar.edu.unju.escmi.tp5.collections.CollectionProducto.buscarProducto(codigoProducto);
                    if (p != null) {
                        System.out.println("Producto encontrado: " + p.getNombreProducto() + " | Stock: " + p.getStock());
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
