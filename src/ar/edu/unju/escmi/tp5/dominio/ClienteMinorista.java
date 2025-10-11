package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;

public class ClienteMinorista extends Cliente {
    private boolean PAMI;

    public ClienteMinorista(String nombre, String apellido, String direccion, int dni, boolean PAMI) {
        super(nombre, apellido, direccion, dni);
        this.PAMI = PAMI;
    }
    
    @Override
    public Factura comprar(List<Producto> productos, List<Integer> cantidades) {
        Factura factura = new Factura(this);
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            int cant = cantidades.get(i);

            DetalleFactura detalle = new DetalleFactura(cant, p);
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



    public boolean tienePAMI() {
        return PAMI;
    }

    public void setPAMI(boolean PAMI) {
        this.PAMI = PAMI;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("PAMI: " + PAMI);
    }
}
