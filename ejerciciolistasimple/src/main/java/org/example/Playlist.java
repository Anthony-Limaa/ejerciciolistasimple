package org.example;
import java.util.Scanner;
public class Playlist {
    private nodo cabeza;

    // Método para agregar una canción al final de la playlist
    public void agregarCancion(String nombreCancion, String artista, String genero, int duracion) {
        nodo nuevaCancion = new nodo(nombreCancion, artista, genero, duracion);
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaCancion;
        }
    }

    // Método para imprimir la playlist completa.
    public void imprimirPlaylist() {
        nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombreCancion + ", Artista: " + actual.artista + ", Género: " + actual.genero + ", Duración: " + actual.duracion + " segundos");
            actual = actual.siguiente;
        }
    }

    // Método para eliminar una canción específica de la playlist por su nombre
    public void eliminarCancion(String nombreCancion) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.nombreCancion.equals(nombreCancion)) {
            cabeza = cabeza.siguiente;
            return;
        }
        nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.nombreCancion.equals(nombreCancion)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    // Método para insertar una nueva canción en una posición específica
    public void insertarCancion(String nombreCancion, String artista, String genero, int duracion, int posicion) {
        nodo nuevaCancion = new nodo(nombreCancion, artista, genero, duracion);
        if (posicion == 0) {
            nuevaCancion.siguiente = cabeza;
            cabeza = nuevaCancion;
            return;
        }
        nodo actual = cabeza;
        for (int i = 0; i < posicion - 1 && actual != null; i++) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            nuevaCancion.siguiente = actual.siguiente;
            actual.siguiente = nuevaCancion;
        }
    }

    // Método para buscar una canción por su nombre y mostrar su información
    public void buscarCancion(String nombreCancion) {
        nodo actual = cabeza;
        while (actual != null) {
            if (actual.nombreCancion.equals(nombreCancion)) {
                System.out.println("Nombre: " + actual.nombreCancion + ", Artista: " + actual.artista + ", Género: " + actual.genero + ", Duración: " + actual.duracion + " segundos");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("La canción '" + nombreCancion + "' no se encontró en la playlist.");
    }

    // Método para ordenar la playlist por nombre de canción
    public void ordenarPorNombre() {
        if (cabeza == null || cabeza.siguiente == null) {
            return;
        }
        nodo actual = cabeza;
        while (actual != null) {
            nodo siguiente = actual.siguiente;
            while (siguiente != null) {
                if (actual.nombreCancion.compareToIgnoreCase(siguiente.nombreCancion) > 0) {
                    // Intercambiar nodos
                    String tempNombre = actual.nombreCancion;
                    String tempArtista = actual.artista;
                    String tempGenero = actual.genero;
                    int tempDuracion = actual.duracion;

                    actual.nombreCancion = siguiente.nombreCancion;
                    actual.artista = siguiente.artista;
                    actual.genero = siguiente.genero;
                    actual.duracion = siguiente.duracion;

                    siguiente.nombreCancion = tempNombre;
                    siguiente.artista = tempArtista;
                    siguiente.genero = tempGenero;
                    siguiente.duracion = tempDuracion;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        }
    }

    // Método para calcular la duración total de la playlist en minutos y segundos
    public void calcularDuracionTotal() {
        int duracionTotal = 0;
        nodo actual = cabeza;
        while (actual != null) {
            duracionTotal += actual.duracion;
            actual = actual.siguiente;
        }
        int minutos = duracionTotal / 60;
        int segundos = duracionTotal % 60;
        System.out.println("Duración total de la playlist: " + minutos + " minutos " + segundos + " segundos");
    }

    // Método para mostrar un menú interactivo
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Agregar una canción");
            System.out.println("2. Eliminar una canción");
            System.out.println("3. Insertar una canción en una posición específica");
            System.out.println("4. Buscar una canción");
            System.out.println("5. Ordenar la playlist por nombre");
            System.out.println("6. Calcular duración total de la playlist");
            System.out.println("7. Imprimir playlist completa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la canción: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingrese la duración (en segundos): ");
                    int duracion = scanner.nextInt();
                    agregarCancion(nombre, artista, genero, duracion);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la canción a eliminar: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String nombreEliminar = scanner.nextLine();
                    eliminarCancion(nombreEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la canción a insertar: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String nombreInsertar = scanner.nextLine();
                    System.out.print("Ingrese el artista: ");
                    String artistaInsertar = scanner.nextLine();
                    System.out.print("Ingrese el género: ");
                    String generoInsertar = scanner.nextLine();
                    System.out.print("Ingrese la duración (en segundos): ");
                    int duracionInsertar = scanner.nextInt();
                    System.out.print("Ingrese la posición de inserción: ");
                    int posicionInsertar = scanner.nextInt();
                    insertarCancion(nombreInsertar, artistaInsertar, generoInsertar, duracionInsertar, posicionInsertar);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la canción a buscar: ");
                    scanner.nextLine(); // Limpiar el buffer
                    String nombreBuscar = scanner.nextLine();
                    buscarCancion(nombreBuscar);
                    break;
                case 5:
                    ordenarPorNombre();
                    System.out.println("Playlist ordenada por nombre.");
                    break;
                case 6:
                    calcularDuracionTotal();
                    break;
                case 7:
                    imprimirPlaylist();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
