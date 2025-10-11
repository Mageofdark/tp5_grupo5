package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class AgenteAdministrativoMenu {
    public static void mostrarMenu(java.util.Scanner scanner) {
        int opcion;
        do {
            System.out.println("===== MENU AGENTE ADMINISTRATIVO =====");
            System.out.println("1. Alta de Producto");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Alta de Producto: validar empleado y pedir datos
                    System.out.println("Opcion de Alta de Producto seleccionada.");
                    System.out.print("Ingrese ID del empleado que realiza la operacion: ");
                    int idEmpleado = scanner.nextInt();
                    // buscar empleado
                    ar.edu.unju.escmi.tp5.dominio.Empleado empleado = ar.edu.unju.escmi.tp5.collections.CollectionEmpleado.buscarEmpleado(idEmpleado);
                    if (empleado == null) {
                        System.out.println("Empleado no encontrado. No se puede realizar el alta.");
                        break;
                    }
                    System.out.println("Empleado encontrado: " + empleado.getNombre() + " " + empleado.getApellido());
                    // pedir datos del producto
                    System.out.print("Ingrese codigo del producto: ");
                    int codigoProducto = scanner.nextInt();
                    scanner.nextLine();
                    if (ar.edu.unju.escmi.tp5.collections.CollectionProducto.buscarProducto(codigoProducto) != null) {
                        System.out.println("El producto con codigo " + codigoProducto + " ya existe.");
                        break;
                    }
                    System.out.print("Ingrese nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese precio del producto: ");
                    float precioUnitario = scanner.nextFloat();
                    System.out.print("Ingrese stock del producto: ");
                    int stock = scanner.nextInt();

                    ar.edu.unju.escmi.tp5.dominio.Producto nuevoProducto = new ar.edu.unju.escmi.tp5.dominio.Producto(codigoProducto, nombreProducto, precioUnitario, stock);
                    ar.edu.unju.escmi.tp5.collections.CollectionProducto.guardarProducto(nuevoProducto);
                    System.out.println("Producto agregado exitosamente por el empleado: " + empleado.getNombre());
                    break;

                case 2:
                    // Llamar al metodo para Realizar Venta
                    System.out.println("Opcion de Realizar Venta seleccionada.");
                    CollectionFactura.guardarFactura(null);
                    break;

                case 3:
                    System.out.println("Volviendo al Menu Principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
}
