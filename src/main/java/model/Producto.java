package model;

public class Producto {

	// Atributos de la clase
    private String nombre;
    private int cantidad;

    //Constructor que inicializa todos los atributos.
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Métodos getter y setter -> Métodos de acceso a los datos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Representación en formato de texto del producto. Incluye el nombre y la cantidad disponible.
    @Override
    public String toString() {
        return "Nombre = " + nombre + ", Cantidad = " + cantidad + "\n";
    }
}
