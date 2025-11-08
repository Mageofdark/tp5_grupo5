package ar.edu.unju.escmi.tp5.principal;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.dominio.DetalleFactura;

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
                    // Realizar Venta: validar empleado y registrar venta
                    System.out.println("Opcion de Realizar Venta seleccionada.");
                    System.out.print("Ingrese ID del empleado que realiza la venta: ");
                    int idVendedor = scanner.nextInt();

                    // buscar empleado
                    ar.edu.unju.escmi.tp5.dominio.Empleado vendedor = ar.edu.unju.escmi.tp5.collections.CollectionEmpleado.buscarEmpleado(idVendedor);
                    if (vendedor == null) {
                        System.out.println("Empleado no encontrado. No se puede realizar la venta.");
                        break;
                    }
                    System.out.println("Empleado encontrado: " + vendedor.getNombre() + " " + vendedor.getApellido());

                    // pedir datos del cliente
                    System.out.print("Ingrese DNI del cliente: ");
                    int dniCliente = scanner.nextInt();
                    ar.edu.unju.escmi.tp5.dominio.Cliente cliente = ar.edu.unju.escmi.tp5.collections.CollectionCliente.buscarCliente(dniCliente);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado. No se puede realizar la venta.");
                        break;
                    }
                    System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());

                    //crear factura
                    ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura factura = new ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura(cliente);

                    //seleccionar productos y cantidades
                    System.out.println("LISTA DE PRODUCTOS DISPONIBLES:");
                    for (ar.edu.unju.escmi.tp5.dominio.Producto p : ar.edu.unju.escmi.tp5.collections.CollectionProducto.getProductos()) {
                        System.out.println("Codigo: " + p.getCodigoProducto() + ", Nombre: " + p.getNombreProducto() + ", Precio: " + p.getPrecioUnitario() + ", Stock: " + p.getStock());
                    }
                    
                    //Seleccionar producto por codigo real
                    System.out.print("Ingrese codigo del producto a vender: ");
                    int codigoVenta = scanner.nextInt();
                    ar.edu.unju.escmi.tp5.dominio.Producto productoVendido = ar.edu.unju.escmi.tp5.collections.CollectionProducto.buscarProducto(codigoVenta); 

                    if (productoVendido == null) {
                        System.out.println("COdigo del producto invalido");
                        break;
                    }

                    //Ingresar cantidad a vender
                    System.out.print("Ingrese cantidad a vender: ");
                    int cantidadVenta = scanner.nextInt();

                    if (cantidadVenta <= 0){
                        System.out.println("Cantidad invalida para la venta.");
                        break;
                    }

                    if (cantidadVenta > productoVendido.getStock()){
                        System.out.println("No hay suficiente stock para realizar la venta.");
                        break;
                    }

                    //crear detalle de la factura
                    ar.edu.unju.escmi.tp5.dominio.DetalleFactura detalle = new DetalleFactura(cantidadVenta, productoVendido);

                    //agregar a la factura
                    factura.agregarDetalles(detalle);

                    //guardar factura en la coleccion
                    CollectionFactura.guardarFactura(factura);

                    //actualizar stock del producto
                    productoVendido.productosComprados(cantidadVenta);

                    //confirmacion de la venta
                    System.out.println("Venta realizada exitosamente por el empleado: " + vendedor.getNombre());
                    System.out.println("Detalle de la venta:");
                    System.out.println(detalle.toString());
                    System.out.println("Total de la factura: " + factura.getTotal());
                    /* System.out.println("Ingrese codigo del producto a vender: ");
                    int codigoVenta = scanner.nextInt();
                    if (codigoVenta < 1 || codigoVenta > ar.edu.unju.escmi.tp5.collections.CollectionProducto.getProductos().size()) {
                        System.out.println("Codigo de producto invalido.");
                    } else {
                        ar.edu.unju.escmi.tp5.dominio.Producto productoVendido = ar.edu.unju.escmi.tp5.collections.CollectionProducto.buscarProducto(codigoVenta);
                        System.out.print("Ingrese cantidad a vender: ");
                        int cantidadVenta = scanner.nextInt();
                        if (cantidadVenta > productoVendido.getStock()) {
                            System.out.println("No hay suficiente stock para realizar la venta.");
                        } else if (cantidadVenta <= 0){
                            System.out.println("Cantidad invalida para la venta.");
                        } else {

                            //crear detalle de la factura
                            ar.edu.unju.escmi.tp5.dominio.DetalleFactura detalle = new DetalleFactura(cantidadVenta, productoVendido);

                            //agregar a la factura
                            factura.agregarDetalles(detalle);

                            //guardar factura en la coleccion
                            CollectionFactura.guardarFactura(factura);
                            //actualizar stock del producto
                            productoVendido.productosComprados(cantidadVenta);
                            System.out.println("Venta realizada exitosamente por el empleado: " + vendedor.getNombre());
                            System.out.println("Detalle de la venta:");
                            System.out.println(detalle.toString());
                            }
                    }*/
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
