package ar.edu.unju.escmi.tp5.dominio;

public class EncargadoVentas extends Empleado {

    public EncargadoVentas(String nombre, String apellido, int dni, int idEmpleado) {
        super(nombre, apellido, dni, idEmpleado);
    }

    @Override
    public void mostrarTarea() {
        System.out.println("Encargado de ventas: revisar todas las ventas y verificar stock.");
    }
}
