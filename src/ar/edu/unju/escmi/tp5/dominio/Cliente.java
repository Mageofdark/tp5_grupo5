package ar.edu.unju.escmi.tp5.dominio;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;

    public Cliente(String nombre, String apellido, String direccion, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    }

     // metodo abstracto para cada subclase implementa su lógica de compra
    public abstract Factura comprar(List<Producto> productos, List<Integer> cantidades);

    // Buscar factura por numero (delegar a CollectionFactura)
    public ar.edu.unju.escmi.tp5.dominio.EncabezadoFactura buscarFactura(int numero) {
        return ar.edu.unju.escmi.tp5.collections.CollectionFactura.buscarFactura(numero);
    }

    // Mostrar datos basicos del cliente
    public void mostrarDatos() {
        System.out.println("Cliente: " + nombre + " " + apellido + " | DNI: " + dni + " | Direccion: " + direccion);
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {   
        return dni;
    }

    public void setDni(int dni) {  
        this.dni = dni;
    }
}