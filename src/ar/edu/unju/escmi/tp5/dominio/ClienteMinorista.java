package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;

public class ClienteMinorista extends Cliente {
    private int dni;
    private boolean PAMI;

    public ClienteMinorista(String nombre, String apellido, String direccion, int dni, boolean PAMI) {
        super(nombre, apellido, direccion, dni);
        this.dni = dni;
        this.PAMI = PAMI;
    }
    
    public Factura comprar(List<Producto> productos, List<Integer> cantidades) {
        Factura factura = new Factura(this);
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cant = cantidades.get(i);

            float precioUnitario = p.getPrecioUnitario();

            DetalleFactura detalle = new DetalleFactura(cant, p, precioUnitario);
            factura.agregarDetalle(detalle);
            p.ProductosComprados(cant);
        }

        factura.calcularTotal();

        if (PAMI == true) {
            double descuento = factura.getTotal() * 0.10;
            factura.setTotal(factura.getTotal() - descuento);
        }

        return factura;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean tienePAMI() {
        return PAMI;
    }

    public void setPAMI(boolean PAMI) {
        this.PAMI = PAMI;
    }
}
