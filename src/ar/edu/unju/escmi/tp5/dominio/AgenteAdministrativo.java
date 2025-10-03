package ar.edu.unju.escmi.tp5.dominio;

public class AgenteAdministrativo extends Empleado {

    public AgenteAdministrativo(String nombre, String apellido, int dni, int idEmpleado) {
        super(nombre, apellido, dni, idEmpleado);
    }

    @Override
    public void mostrarTarea() {
        System.out.println("Agente administrativo: carga productos en stock y realiza ventas.");
    }
}
