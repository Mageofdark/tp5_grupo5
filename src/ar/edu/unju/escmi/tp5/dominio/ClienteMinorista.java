package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;

public class ClienteMinorista extends Cliente {
    private boolean tienePAMI;

    public ClienteMinorista(String nombre, String apellido, String direccion, int dni, boolean tienePAMI) {
        super(nombre, apellido, direccion, dni);
        this.tienePAMI = tienePAMI;
    }
    
    @Override
    public EncabezadoFactura comprar(List<Producto> productos, List<Integer> cantidades) {
        EncabezadoFactura factura = new EncabezadoFactura(this);
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cant = cantidades.get(i);

            DetalleFactura detalle = new DetalleFactura(cant, p);
            factura.agregarDetalles(detalle);
            p.productosComprados(cant);
        }

        factura.calcularTotal();

        if (tienePAMI == true) {
            double descuento = factura.getTotal() * 0.10;
            factura.setTotal(factura.getTotal() - descuento);
        }

        return factura;
    }

    @Override
    public ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura buscarFactura(int numero) {
        return ar.edu.unju.escmi.tp5.dominio.CollectionFacturas.buscarFactura(numero);
    }

    public boolean getTienePAMI() {
        return tienePAMI;
    }

    public void setTienePAMI(boolean tienePAMI) {
        this.tienePAMI = tienePAMI;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente: " + nombre + " " + apellido + " | DNI: " + dni + " | Direccion: " + direccion + "PAMI: " + tienePAMI);
    }
}
