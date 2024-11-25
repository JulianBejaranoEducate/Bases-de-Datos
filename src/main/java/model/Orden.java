package model;

public class Orden implements Comparable<Orden>{
	// Atributos de la clase
    private String cliente; // Nombre del cliente que realiza la orden
    private String producto; // Producto solicitado en la orden
    private int cantidad; // Cantidad del producto solicitado
    private boolean urgente; // Indica si la orden es urgente

    //Constructor que inicializa todos los atributos de la orden.
    public Orden(String cliente, String producto, int cantidad, boolean urgente) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.urgente = urgente;
    }

 // Métodos getter y setter -> Métodos de acceso a los datos
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    //Método para comparar las órdenes según su urgencia. Las órdenes urgentes tienen mayor prioridad.
    @Override
    public int compareTo(Orden o) {
    	// Ordenar de forma descendente por urgencia (true primero)
        return Boolean.compare(o.urgente, this.urgente); // Prioridad a órdenes urgentes
    }

    //Representación en formato de texto de la orden. Incluye todos los atributos relevantes.
    @Override
    public String toString() {
        return "Orden{"
                + "cliente='" + cliente + '\''
                + ", producto='" + producto + '\''
                + ", cantidad=" + cantidad
                + ", urgente=" + urgente
                + '}';
    }
}
