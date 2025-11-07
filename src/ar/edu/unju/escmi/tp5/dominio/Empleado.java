package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected int dni;
    protected int idEmpleado;

    public Empleado(String nombre, String apellido, int dni, int idEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idEmpleado = idEmpleado;
    }
// este es un metodo que puede redifinir las subclases por si acaso
    public abstract void mostrarTarea();

    // los getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
