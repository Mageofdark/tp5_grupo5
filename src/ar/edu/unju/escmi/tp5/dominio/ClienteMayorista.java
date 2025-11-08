package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;

public class ClienteMayorista extends Cliente {
    private int codigoCliente;

    public ClienteMayorista(String nombre, String apellido, String direccion, int dni, int codigoCliente) {
        super(nombre, apellido, direccion, dni);
        this.codigoCliente = codigoCliente;
    }
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public EncabezadoFactura comprar(List<Producto> productos, List<Integer> cantidades) {
        EncabezadoFactura factura = new EncabezadoFactura(this);
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cant = cantidades.get(i);

        
            float precioUnitario = p.getPrecioUnitario();
            if (cant % 10 == 0) {
                precioUnitario = precioUnitario / 2;
            }

            DetalleFactura detalle = new DetalleFactura(cant, p);
            factura.agregarDetalles(detalle);
            p.productosComprados(cant);
        }
        factura.calcularTotal();
        return factura;
    } 

    @Override
    public ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura buscarFactura(int numero) {
        return ar.edu.unju.escmi.tp5.dominio.CollectionFacturas.buscarFactura(numero);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente: " + nombre + " " + apellido + " | DNI: " + dni + " | Direccion: " + direccion + "Codigo cliente mayorista: " + codigoCliente);
    }
}
