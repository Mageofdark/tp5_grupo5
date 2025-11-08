package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura;

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
                    
                    EncabezadoFactura facturaEncontrada = ar.edu.unju.escmi.tp5.collections.CollectionFactura.buscarFactura(numeroFactura);
                    if (facturaEncontrada == null){
                        System.out.println("no existe factura con ese numero.");
                    } else {
                        System.out.println("Factura N° " + facturaEncontrada.getNumero());
                        System.out.println("Fecha: " + facturaEncontrada.getFecha());
                        System.out.println("Cliente: " + facturaEncontrada.getCliente().getNombre());
                        for (ar.edu.unju.escmi.tp5.dominio.DetalleFactura detalle : facturaEncontrada.getDetalles()){
                            System.out.println(" - Producto: " + detalle.getProducto().getNombreProducto() + ", Cantidad: " + detalle.getCantidad() + ", Importe: " + detalle.getImporte());
                        }
                        System.out.println("Total: " + facturaEncontrada.getTotal());
                    }
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
