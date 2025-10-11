package ar.edu.unju.escmi.tp5.dominio;

public class AgenteAdministrativo extends Empleado {

    public AgenteAdministrativo(String nombre, String apellido, int dni, int idEmpleado) {
        super(nombre, apellido, dni, idEmpleado);
    }

    @Override
    public void mostrarTarea() {
        System.out.println("Agente administrativo: carga productos en stock y realiza ventas.");
    }

    // Agregar stock a un producto
    public void agregarStock(ar.edu.unju.escmi.tp5.dominio.Producto producto, int cantidad) {
        producto.setStock(producto.getStock() + cantidad);
    }

    // Realizar venta: implementacion simplificada/placeholder
    public void realizarVenta() {
        // placeholder: la lógica completa de venta se maneja desde los menús y colecciones
        System.out.println("Realizar venta (placeholder) - use el menu para operar");
    }
}
