package ies.alandalus.programacion.damas;
import ies.alandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;
import ies.alandalus.programacion.damas.modelo.Color;
import ies.alandalus.programacion.damas.modelo.Posicion;
import ies.alandalus.programacion.damas.modelo.Direccion;

import javax.naming.OperationNotSupportedException;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class Consola {


    private Consola() {

    }

    public static void mostrarMenu() {//Puse Menú con acento pero cuando inicio el MainApp la "Ú" me sale con un simbolo y lo deje sin acento.
        System.out.println("Menu de opciones:");
        System.out.println("1.Crear dama por defecto.");
        System.out.println("2.Crear dama eligiendo color.");
        System.out.println("3.Mover.");
        System.out.println("4.Salir.");
    }

    public static int elegirOpcionMenu()  {
        int opcion;

        do {
            System.out.println("Elija una opcion del menu");//Puse Menú con acento pero cuando inicio el MainApp la "Ú" me sale con un simbolo y lo deje sin acento.
            opcion=Entrada.entero();
            if (opcion<1 || opcion>4){
                System.out.println("Elija una opcion correcta");
            }
        }while(opcion<1 || opcion>4);
        return opcion;
    }


    public static Color elegirColor()  {
        Color color = null; //Metodo para elegir el color
        int colorEleccion;
        do {
            System.out.println("Elige un color:");
            System.out.println("1.Blanco");
            System.out.println("2.Negro");
            colorEleccion=Entrada.entero();
            if (colorEleccion==1){
               color=Color.BLANCO;

            }else if (colorEleccion==2){
              color=Color.NEGRO;
            }
            else{
                System.out.println("Elección invalida,eliga una opcion entre 1)blanco o 2)negro.");
            }
        }while(color== null);
        return color;
    }
    public static void mostrarMenuDirecciones(){
        System.out.println("Menu de Direcciones:"); //Puse Menú con acento pero cuando inicio el MainApp la "Ú" me sale con un simbolo y lo deje sin acento.
        System.out.println("1.Noreste");
        System.out.println("2.Noroeste");
        System.out.println("3.Sureste");
        System.out.println("4.Suroeste");

    }
    public static int elegirPasos()throws OperationNotSupportedException  {//metodo para elegir el número de pasos
        int pasos=0;
        try {
            do {
                System.out.println("Elija el numero de pasos");
                pasos = Entrada.entero();
            } while (pasos < 1);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

        }
        return pasos;
    }


    public static Direccion elegirDireccion()
    {
        int direccion;
        Direccion direccionElegida =null;
        do{
            System.out.println("Elige una direccion");
            direccion=Entrada.entero();
            switch (direccion) {
                case 1 -> {
                    direccionElegida = Direccion.NORESTE;
                    break;
                }
                case 2 -> {
                    direccionElegida = Direccion.NOROESTE;
                    break;
                }

                case 3-> {
                    direccionElegida = Direccion.SUROESTE;
                    break;
                }
                case 4-> {
                    direccionElegida = Direccion.SURESTE;
                    break;
                }
                default->{
                    System.out.println("La direccion no puede ser nula");
                }
            }

        }while(direccionElegida==null);
        return direccionElegida;

    }
    public static void salir(){
        System.out.println("***************** VUELVE PRONTO *****************");
    }
}





