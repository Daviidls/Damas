package ies.alandalus.programacion.damas;
import ies.alandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
   static Dama dama;
    public static void main(String[] args) {


    }
    private static void ejecutarOpcion(int opcion)
    {
        opcion=Entrada.entero();
    }
    private static void crearDamaDefecto()
    {
        dama= new Dama();
       
    }

}
