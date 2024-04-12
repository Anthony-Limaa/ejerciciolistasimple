package org.example;

public class nodo {
    String nombreCancion;
    String artista;
    String genero;
    int duracion; // en segundos
    nodo siguiente;

    // Constructor
    public nodo(String nombreCancion, String artista, String genero, int duracion) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.siguiente = null;
    }
}
