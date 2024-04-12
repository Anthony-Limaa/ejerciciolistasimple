package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        // Canciones agregadas por defecto.
        playlist.agregarCancion("In Your Eyes", "The Weeknd", "Pop", 357);
        playlist.agregarCancion("Bohemian Rhapsody", "Queen", "Rock", 354);
        playlist.agregarCancion("Paranoid", "Black Sabbath", "Rock", 246);
        playlist.agregarCancion("Wake Me Up", "Avicii", "Electrónica", 407);
        playlist.agregarCancion("God´s Plan", "Drake", "Trap", 319);

        // Ejecuta el menú interactivo
        playlist.menu();
    }
}