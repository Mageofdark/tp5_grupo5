package ar.edu.unju.escmi.tp5.principal;


public class ClienteMenu {
    public static void mostrarMenu(java.util.Scanner scanner) {
        System.out.print("Ingrese su DNI para continuar: ");
        int dni = scanner.nextInt();
        ar.edu.unju.escmi.tp5.dominio.Cliente cliente = ar.edu.unju.escmi.tp5.collections.CollectionCliente.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Volviendo al menu principal.");
            return;
        }
        System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApellido());

        int opcion;
        do {
            System.out.println("===== MENU CLIENTE =====");
            System.out.println("1. Buscar Factura");
            System.out.println("2. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese numero de factura a buscar: ");
                    int numeroFactura = scanner.nextInt();
                    System.out.println("Buscando factura numero: " + numeroFactura);
                    if (ar.edu.unju.escmi.tp5.collections.CollectionFactura.buscarFactura(numeroFactura) != null) {
                        System.out.println("Factura encontrada: " + ar.edu.unju.escmi.tp5.collections.CollectionFactura.buscarFactura(numeroFactura));
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
