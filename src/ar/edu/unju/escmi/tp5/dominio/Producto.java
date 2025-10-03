package ar.edu.unju.escmi.tp5.dominio;

public class Producto { 
    private int codigoProducto;
     private String nombreProducto; 
     private float precioUnitario; 
     private int stock; 

    public Producto(int codigoProducto, String nombreProducto, float precioUnitario, int stock) { 
        this.codigoProducto = codigoProducto; 
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario; 
        this.stock = stock;

    } 
        
    public void ProductosComprados(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad; 
            System.out.println("Se han vendido " + cantidad + " unidades del producto " + nombreProducto); 
            } else { System.out.println("No queda Stock del producto " + nombreProducto);
            }
    }
             
    public int getCodigoProducto() { 
        return codigoProducto;
    }
             
    public String getNombreProducto() {
        return nombreProducto;
    }
                 
    public float getPrecioUnitario() {
        return precioUnitario;
    } 
                     
    public int getStock() {
        return stock; 
    }
                        
    public void setStock(int stock) {
        this.stock = stock;
    } 

 }