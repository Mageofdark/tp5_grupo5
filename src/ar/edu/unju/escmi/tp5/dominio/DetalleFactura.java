package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
    private int cantidad;
    private Producto producto;
    private double precioUnitario;
    private double importe;

    public DetalleFactura(int cantidad, Producto producto, double precioUnitario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.importe = cantidad * precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getImporte() {
        return importe;
    }

    // aqui lo que hizimos es sobreescribir los toString para mostrar detalle
    @Override
    public String toString() {
        return "Producto: " + producto.getNombreProducto() +
               " | Cantidad: " + cantidad +
               " | Precio Unitario: " + precioUnitario +
               " | Importe: " + importe;
    }
}

