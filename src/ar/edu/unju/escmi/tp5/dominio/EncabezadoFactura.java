package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public class EncabezadoFactura {
    private int numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalles;
    private double total;

    // Constructor
    public EncabezadoFactura(Cliente cliente) {
        this.numero = CollectionFactura.facturas.size();
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    // Agregar detalle y recalcular total
    public void agregarDetalles(DetalleFactura detalle) {
        this.detalles.add(detalle);
        calcularTotal();
    }

    // Calcular total
    public void calcularTotal() {
        double suma = 0;
        for (DetalleFactura detalle : detalles) {
            suma += detalle.getImporte();
        }
        this.total = suma;
    }

    // Getters y setters
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

    public void setTotal(double total) {
        this.total = total;
    }

    // Método futuro (placeholder)
    public static EncabezadoFactura buscarFactura(int numero) {
        throw new UnsupportedOperationException("Método 'buscarFactura' no implementado");
    }
}
