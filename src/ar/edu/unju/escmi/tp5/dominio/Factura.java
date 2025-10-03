package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Factura {
    private static int contadorFacturas = 0;
    private int numeroFactura;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalles;
    private double total;

    public Factura(Cliente cliente) {
        Factura.contadorFacturas++;
        this.numeroFactura = contadorFacturas;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleFactura detalle) {
        this.detalles.add(detalle);
    }

    public void calcularTotal() {
        this.total = 0;
        for (DetalleFactura detalle : detalles) {
            this.total += detalle.getImporte();
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String mostrarFactura(){
        return "\nFactura N°: " + numeroFactura +
               "\nFecha: " + fecha +
               "\nCliente: " + cliente.getApellido() + " " + cliente.getNombre() +
               "\nTotal: " + total;
    }
}