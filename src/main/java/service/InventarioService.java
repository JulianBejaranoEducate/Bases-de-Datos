package service;

import model.Producto;
import java.util.Arrays;

public class InventarioService {
    // Arreglo para el inventario de productos 
    private Producto[] inventario; // Almacena los productos y sus cantidades
  
    public InventarioService(int capacidad) {
        this.inventario = new Producto[capacidad]; // Inicializa el inventario con la capacidad dada
    }

  //Inicializa un producto en una posición específica del inventario.
    public void inicializarProducto(int i, String nombre, int cantidad) {
    	// Verifica que el índice esté dentro del rango válido
        if (i >= 0 && i < inventario.length) {
            inventario[i] = new Producto(nombre, cantidad);
        }
    }

    //Devuelve el inventario completo como un arreglo de productos.
    public Producto[] obtenerInventario() {
        return inventario;
    }
    
    //Actualiza la cantidad. Busca el producto y cambia su cantidad si lo encuentra.
    public boolean actualizarCantidad(String nombre, int nuevaCantidad) {
    	// Recorre el inventario
        for (Producto producto : inventario) {
            if (producto != null && producto.getNombre().equals(nombre)) {
                producto.setCantidad(nuevaCantidad);
                return true;
            }
        }
        return false;
    }

    //Representación en formato de texto del inventario. Incluye los productos y sus cantidades.
    @Override
    public String toString() {
        return "Inventario:\n" + Arrays.toString(inventario);
    }
}
