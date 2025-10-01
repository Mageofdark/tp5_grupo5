package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura;

public class CollectionFactura {
    public static List<EncabezadoFactura> facturas = new ArrayList<>();

    public static void guardarFactura(EncabezadoFactura factura) {
        facturas.add(factura);
    }

    public static EncabezadoFactura buscarFactura(int numero) {
        for (EncabezadoFactura f : facturas) {
            if (f.getNumero() == numero) {
                return f;
            }
        }
        return null;
    }

    public static List<EncabezadoFactura> getFacturas() {
        return facturas;
    }
}