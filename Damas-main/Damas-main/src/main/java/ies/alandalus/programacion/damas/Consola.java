package ies.alandalus.programacion.damas;
import ies.alandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;
import ies.alandalus.programacion.damas.modelo.Color;
import ies.alandalus.programacion.damas.modelo.Posicion;
import ies.alandalus.programacion.damas.modelo.Direccion;

import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class Consola {


    private Consola() {

    }

    public static void mostrarMenu() {
        System.out.println("1.Crear dama por defecto.");
        System.out.println("2.Crear dama eligiendo color.");
        System.out.println("3.Mover.");
        System.out.println("4.Salir.");
    }

    public static int elegirOpcionMenu() {
        System.out.print("Elige una opcion");
        int opcion = -1;
        opcion = Entrada.entero();
        switch (opcion) {
            case 1 -> {
                new Dama();
            }
            case 2 -> {
                new
            }
        }
    }

    public static Color elegirColor() {
        System.out.println("Elige un color");
        System.out.println("1.Blanco");
        System.out.println("2.Negro");
        Color color = null;
        int opcion = -1;
        do {
            opcion = Entrada.entero();

            switch (opcion) {
                case 1 -> {
                    color = Color.BLANCO;
                }
                case 2 -> {
                    color = Color.NEGRO;
                }
                default -> {
                    System.out.println("El color no puede ser diferente de Blanco o Negro");
                }
            }
        } while (opcion != 1 || opcion != 2);
        return color;
    }

}
