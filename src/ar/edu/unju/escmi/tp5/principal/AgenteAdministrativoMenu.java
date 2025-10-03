package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;

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
                    // Llamar al metodo para Alta de Producto
                    System.out.println("Opcion de Alta de Producto seleccionada.");
                    CollectionProducto.altaProducto(scanner);
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
