package service;

import model.Producto;
import java.util.Arrays;

public class InventarioService {
    // Arreglo para el inventario de productos
    private Producto[] inventario; // Almacena los productos y sus cantidades
    public InventarioService(int capacidad) {
        this.inventario = new Producto[capacidad]; // Inicializa el inventario con la capacidad dada
    }

    public void inicializarProducto(int i, String nombre, int cantidad) {
        if (i >= 0 && i < inventario.length) {
            inventario[i] = new Producto(nombre, cantidad);
        }
    }

    public Producto[] obtenerInventario() {
        return inventario;
    }

    public boolean actualizarCantidad(String nombre, int nuevaCantidad) {
        for (Producto producto : inventario) {
            if (producto != null && producto.getNombre().equals(nombre)) {
                producto.setCantidad(nuevaCantidad);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventario:\n" + Arrays.toString(inventario);
    }
}
