package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Ingresar como Agente Administrativo");
            System.out.println("2. Ingresar como Cliente");
            System.out.println("3. Ingresar como Encargado de Ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamar al metodo para Agente Administrativo
                    System.out.println("Ingresando como Agente Administrativo...");
                    AgenteAdministrativoMenu.mostrarMenu(scanner);
                    break;

                case 2:
                    // Llamar al metodo para Cliente
                    System.out.println("Ingresando como Cliente...");
                    ClienteMenu.mostrarMenu(scanner);
                    break;

                case 3:
                    // Llamar al metodo para Encargado de Ventas
                    System.out.println("Ingresando como Encargado de Ventas...");
                    EncargadoVentasMenu.mostrarMenu(scanner);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema. Hasta luego!");
                    break;
                
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);

    };

};