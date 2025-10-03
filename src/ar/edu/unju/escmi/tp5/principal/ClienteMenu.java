package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class ClienteMenu {
    public static void mostrarMenu(java.util.Scanner scanner) {
        int opcion;
        do {
            System.out.println("===== MENU CLIENTE =====");
            System.out.println("1. Buscar Factura");
            System.out.println("2. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamar al metodo para Buscar Factura
                    System.out.println("Ingrese numero de factura a buscar: ");
                    int numeroFactura = scanner.nextInt();
                   CollectionFactura.buscarFactura(numeroFactura);
                    // Simulacion de busqueda
                    System.out.println("Buscando factura numero: " + numeroFactura);

                    if (CollectionFactura.buscarFactura(numeroFactura) != null) {
                        System.out.println("Factura encontrada: " + CollectionFactura.buscarFactura(numeroFactura));
                    } else {
                        System.out.println("Factura no encontrada.");
                    }
                    break;

                case 2:
                    System.out.println("Volviendo al Menu Principal...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 2);
    }
}
