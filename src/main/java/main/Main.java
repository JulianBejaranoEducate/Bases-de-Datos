package main;

import model.Orden;
//import model.Producto;
import service.InventarioService;
import service.OrdenService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	// Configuración de entrada desde el teclado
        Scanner scanner = new Scanner(System.in);
     // Inicialización de servicios necesarios
        InventarioService inventarioService = new InventarioService(5);
        OrdenService ordenService = new OrdenService();

        // Inicializamos el inventario con algunos productos
        inventarioService.inicializarProducto(0, "Laptop", 50);
        inventarioService.inicializarProducto(1, "SmartTV", 30);
        inventarioService.inicializarProducto(2, "SmartWatch", 35);
        inventarioService.inicializarProducto(3, "SmartPhone", 45);
        inventarioService.inicializarProducto(4, "HeadPhones", 60);

        int opcion;
        do {
        	// Menú principal
            System.out.println("\n--- IMPLEMENTACION DE SISTEMA ---\n");
            System.out.println("1. Gestionar Inventario");
            System.out.println("2. Gestionar Ordenes");
            System.out.println("3. Procesar Ordenes");
            System.out.println("4. Salir");
            System.out.print("Por favor, selecciona una opcion para continuar: ");
            opcion = scanner.nextInt();

         // Procesamiento de la opción seleccionada
            switch (opcion) {
                case 1:
                    gestionarInventario(inventarioService, scanner);
                    break;
                case 2:
                    gestionarOrdenes(ordenService, scanner);
                    break;
                case 3:
                    procesarOrdenes(ordenService, scanner);
                    break;
                case 4:
                    System.out.println("¡Saliendo del sistema! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 4); // Repetir mientras no se elija salir
    }

    private static void gestionarInventario(InventarioService inventarioService, Scanner scanner) {
    	// Mostrar inventario actual y permitir la actualización de productos
        System.out.println("\n--- GESTION DE INVENTARIO ---\n");
        System.out.println(inventarioService); // Mostrar inventario actual
        
     // Solicitar datos del producto a actualizar
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la nueva cantidad: ");
        int cantidad = scanner.nextInt();
     // Actualización de cantidad en el inventario
        if (inventarioService.actualizarCantidad(nombre, cantidad)) {
            System.out.println("La cantidad ha sido actualizada correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void gestionarOrdenes(OrdenService ordenService, Scanner scanner) {
    	// Gestión de órdenes: agregar, modificar, eliminar o mostrar
        System.out.println("\n--- GESTION DE ORDENES ---\n");
        System.out.println("1. Agregar una orden");
        System.out.println("2. Modificar una orden");
        System.out.println("3. Eliminar una orden");
        System.out.println("4. Mostrar las ordenes");
        System.out.print("Por favor, selecciona una opcion para continuar: ");
        int opcion = scanner.nextInt();
        
     // Procesar opciones de gestión de órdenes
        switch (opcion) {
            case 1:
            	// Agregar una nueva orden
                System.out.print("Ingrese el nombre del cliente: ");
                String cliente = scanner.next();
                System.out.print("Ingrese el producto solicitado: ");
                String producto = scanner.next();
                System.out.print("Ingrese la cantidad solicitada: ");
                int cantidad = scanner.nextInt();
                System.out.print("¿Es urgente? (true/false): ");
                boolean urgente = scanner.nextBoolean();
                Orden orden = new Orden(cliente, producto, cantidad, urgente);
                ordenService.agregarOrden(orden);
                System.out.println("La orden has sido agregada correctamente.");
                break;
            case 2:
            	// Modificar una orden existente
                System.out.print("Ingrese el indice de la orden a modificar: ");
                int indexModificar = scanner.nextInt();
                System.out.print("Ingrese el nombre del cliente: ");
                cliente = scanner.next();
                System.out.print("Ingrese el producto solicitado: ");
                producto = scanner.next();
                System.out.print("Ingrese la cantidad solicitada: ");
                cantidad = scanner.nextInt();
                System.out.print("¿Es urgente? (true/false): ");
                urgente = scanner.nextBoolean();
                Orden nuevaOrden = new Orden(cliente, producto, cantidad, urgente);
                ordenService.modificarOrden(indexModificar, nuevaOrden);
                System.out.println("La orden ha sido modificada correctamente.");
                break;
            case 3:
            	// Eliminar una orden
                System.out.print("Ingrese el indice de la orden a eliminar: ");
                int indexEliminar = scanner.nextInt();
                ordenService.eliminarOrden(indexEliminar);
                System.out.println("La orden ha sido eliminada correctamente.");
                break;
            case 4:
            	// Mostrar todas las órdenes
                System.out.println("Ordenes registradas: " + ordenService);
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static void procesarOrdenes(OrdenService ordenService, Scanner scanner) {
    	// Procesamiento de órdenes: regulares o urgentes, apilar/desapilar productos
        System.out.println("\n--- PROCESAMIENTO DE ORDENES ---\n");
        System.out.println("1. Procesar Orden Regular");
        System.out.println("2. Procesar Orden Urgente");
        System.out.println("3. Apilar Producto");
        System.out.println("4. Desapilar Producto");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
            	// Procesar una orden regular
                Orden ordenRegular = ordenService.procesarOrdenRegular();
                System.out.println("Orden Regular Procesada: " + ordenRegular);
                break;
            case 2:
            	// Procesar una orden urgente
                Orden ordenUrgente = ordenService.procesarOrdenUrgente();
                System.out.println("Orden Urgente Procesada: " + ordenUrgente);
                break;
            case 3:
            	// Apilar un producto en el inventario
                System.out.print("Ingrese el nombre del cliente: ");
                String cliente = scanner.next();
                System.out.print("Ingrese el producto solicitado: ");
                String producto = scanner.next();
                System.out.print("Ingrese la cantidad solicitada: ");
                int cantidad = scanner.nextInt();
                System.out.print("¿Es urgente? (true/false): ");
                boolean urgente = scanner.nextBoolean();
                Orden nuevaOrden = new Orden(cliente, producto, cantidad, urgente);
                ordenService.apilarProducto(nuevaOrden);
                System.out.println("El producto ha sido apilado correctamente.");
                break;
            case 4:
            	// Desapilar un producto del inventario
                Orden desapilado = ordenService.desapilarProducto();
                System.out.println("Producto desapilado: " + desapilado);
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
}
