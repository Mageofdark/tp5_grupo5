package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncabezadoFactura {
    private int numero;
    private Cliente cliente;
    private LocalDate fecha;
    private List<DetalleFactura> detalles;
    private double total;

    // el constructor
    public EncabezadoFactura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    // el metodo para agregar detalles a la factura
    public void agregarDetalle(DetalleFactura detalle) {
        detalles.add(detalle);
        calcularTotal();
    }

    // el metodo para calcular total de la factura
    public void calcularTotal() {
        double suma = 0;
        for (DetalleFactura d : detalles) {
            suma += d.getImporte();
        }
        this.total = suma;
    }

    // los getters y setters
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
