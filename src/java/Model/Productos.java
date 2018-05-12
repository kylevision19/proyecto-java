package Model;

public class Productos {
    
    private int cod_producto, precio;
    private String nombre, descripcion;

    public Productos() {
    }

    public Productos(int precio, String nombre, String descripcion) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Productos(int cod_producto, int precio, String nombre, String descripcion) {
        this.cod_producto = cod_producto;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
