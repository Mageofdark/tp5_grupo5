package ar.edu.unju.escmi.tp5.dominio;

public class EncargadoVentas extends Empleado {

    public EncargadoVentas(String nombre, String apellido, int dni, int idEmpleado) {
        super(nombre, apellido, dni, idEmpleado);
    }

    @Override
    public void mostrarTarea() {
        System.out.println("Encargado de ventas: revisar todas las ventas y verificar stock.");
    }

    // Mostrar las ventas - delega a CollectionFactura
    public void mostrarVentas() {
        System.out.println("Ventas registradas: " + ar.edu.unju.escmi.tp5.collections.CollectionFactura.getFacturas());
    }

    // Mostrar total de ventas
    public double mostrarTotalVentas() {
        return ar.edu.unju.escmi.tp5.collections.CollectionFactura.calcularTotalVentas();
    }

    // Verificar stock de un producto por codigo
    public boolean verificarStock(int codigoProducto) {
        ar.edu.unju.escmi.tp5.dominio.Producto p = ar.edu.unju.escmi.tp5.collections.CollectionProducto.buscarProducto(codigoProducto);
        return p != null && p.getStock() > 0;
    }
}
