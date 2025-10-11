package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Empleado;
import ar.edu.unju.escmi.tp5.dominio.EncargadoVentas;
import java.util.ArrayList;
import java.util.List;

public class CollectionEmpleado {
    public static List<Empleado> empleados = new ArrayList<>();

    // La precarga de los empleados
    static {
        empleados.add(new EncargadoVentas("Raul", "Gutierrez", 44556677, 1));
        empleados.add(new AgenteAdministrativo("Juan", "Segobia", 77889900, 2));
    }

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static Empleado buscarEmpleado(int idEmpleado) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado() == idEmpleado) {
                return e;
            }
        }
        return null;
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }
}