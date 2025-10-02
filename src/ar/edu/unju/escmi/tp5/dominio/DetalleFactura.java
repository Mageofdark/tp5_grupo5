package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
    private int cantidad;
    private Producto producto;
    private float precioUnitario;
    private float importe;

    public DetalleFactura(int cantidad, Producto producto, float precioUnitario2) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = precioUnitario2;
        this.importe = cantidad * precioUnitario;
    }

    public float getImporte() {
        return importe;
    }

    public String mostrarDetalleFactura() {
        return "Producto: " + producto.getNombreProducto() +
               ", Cantidad: " + cantidad +
               ", Precio Unitario: " + precioUnitario +
               ", Importe: " + importe;
    }
}
