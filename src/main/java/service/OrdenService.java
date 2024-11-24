package service;

import model.Orden;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class OrdenService {
    private ArrayList<Orden> listaOrdenes;
    private ArrayDeque<Orden> pilaProductos;
    private LinkedList<Orden> colaOrdenes;
    private PriorityQueue<Orden> colaPrioritaria;

    public OrdenService() {
        listaOrdenes = new ArrayList<>();
        pilaProductos = new ArrayDeque<>();
        colaOrdenes = new LinkedList<>();
        colaPrioritaria = new PriorityQueue<>();
    }

    public void agregarOrden(Orden orden) {
        listaOrdenes.add(orden);
        if (orden.isUrgente()) {
            colaPrioritaria.add(orden);
        } else {
            colaOrdenes.add(orden);
        }
    }

    public void modificarOrden(int i, Orden nuevaOrden) {
        if (i >= 0 && i < listaOrdenes.size()) {
            listaOrdenes.set(i, nuevaOrden);
        }
    }

    public void eliminarOrden(int i) {
        if (i >= 0 && i < listaOrdenes.size()) {
            listaOrdenes.remove(i);
        }
    }

    public Orden procesarOrdenRegular() {
        return colaOrdenes.poll();
    }

    public Orden procesarOrdenUrgente() {
        return colaPrioritaria.poll();
    }

    public void apilarProducto(Orden orden) {
        pilaProductos.push(orden);
    }

    public Orden desapilarProducto() {
        return pilaProductos.pop();
    }

    @Override
    public String toString() {
        return "Lista de ordenes: " + listaOrdenes;
    }
}
