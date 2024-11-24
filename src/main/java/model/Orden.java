package model;

public class Orden implements Comparable<Orden>{

    private String cliente;
    private String producto;
    private int cantidad;
    private boolean urgente;

    public Orden(String cliente, String producto, int cantidad, boolean urgente) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.urgente = urgente;
    }

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

    @Override
    public int compareTo(Orden o) {
        return Boolean.compare(o.urgente, this.urgente); // Prioridad a órdenes urgentes
    }

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
