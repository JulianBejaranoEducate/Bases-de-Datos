package service;

import model.Orden;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class OrdenService {
	// Declaracion de estructuras de datos para manejar las órdenes
    private ArrayList<Orden> listaOrdenes;
    private ArrayDeque<Orden> pilaProductos;
    private LinkedList<Orden> colaOrdenes;
    private PriorityQueue<Orden> colaPrioritaria;

    //Constructor que inicializa las estructuras de datos declaradas.
    public OrdenService() {
        listaOrdenes = new ArrayList<>();
        pilaProductos = new ArrayDeque<>();
        colaOrdenes = new LinkedList<>();
        colaPrioritaria = new PriorityQueue<>();
    }

    //Constructor que inicializa las estructuras de datos necesarias.
    public void agregarOrden(Orden orden) {
        listaOrdenes.add(orden); // Añade la orden a la lista principal.
        if (orden.isUrgente()) {
            colaPrioritaria.add(orden); // Si es urgente, se añade a la cola prioritaria.
        } else {
            colaOrdenes.add(orden); // Si no, se añade a la cola regular.
        }
    }

    //Modifica una orden existente en la lista principal.
    public void modificarOrden(int i, Orden nuevaOrden) {
        if (i >= 0 && i < listaOrdenes.size()) {
            listaOrdenes.set(i, nuevaOrden); 
        }
    }

    //Elimina una orden de la lista principal.
    public void eliminarOrden(int i) {
        if (i >= 0 && i < listaOrdenes.size()) {
            listaOrdenes.remove(i);
        }
    }

    public Orden procesarOrdenRegular() {
        return colaOrdenes.poll(); // Extrae la orden regular más antigua.
    }

    public Orden procesarOrdenUrgente() {
        return colaPrioritaria.poll(); // Toma la orden urgente con mayor prioridad.
    }

    public void apilarProducto(Orden orden) {
        pilaProductos.push(orden); // Añade la orden al tope de la pila.
    }

    public Orden desapilarProducto() {
        return pilaProductos.pop(); // Remueve y retorna la orden en el tope de la pila.
    }

    //Representación de las órdenes registradas en la lista principal.
    @Override
    public String toString() {
        return "Lista de ordenes: " + listaOrdenes;
    }
}
