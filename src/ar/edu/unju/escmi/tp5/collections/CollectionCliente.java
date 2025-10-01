package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayorista;
import ar.edu.unju.escmi.tp5.dominio.ClienteMinorista;

public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    // Precarga de clientes
    static {
        clientes.add(new ClienteMayorista("Matias", "Velazquez", "Ciudad de Nieva 000", 12345678, 1001));
        clientes.add(new ClienteMayorista("Enrique", "Real", "Belgrano 111", 87654321, 1002));
        clientes.add(new ClienteMinorista("Ignacio", "Huanca", "San Martín 222", 33445566, true));
        clientes.add(new ClienteMinorista("Lucas", "Figueroa", "Alto Comedero 333", 11223344, false));
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static Cliente buscarCliente(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) {
                return c;
            }
        }
        return null;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}