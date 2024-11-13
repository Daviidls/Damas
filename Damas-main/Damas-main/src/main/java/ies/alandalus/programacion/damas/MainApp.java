package ies.alandalus.programacion.damas;
import ies.alandalus.programacion.damas.modelo.Color;
import ies.alandalus.programacion.damas.modelo.Dama;
import ies.alandalus.programacion.damas.modelo.Direccion;
import javax.naming.OperationNotSupportedException;


public class MainApp {
  private static Dama dama;//Atributo de la clase dama
    public static void main(String[] args) throws Exception {
        int opcion;
        do {

                Consola.mostrarMenu();//Mostramos el menu principal

                opcion = Consola.elegirOpcionMenu(); //Elegir la opcion del menú

                ejecutarOpcion(opcion);//Ejecutar la opcion elegida

            } while (opcion != 4); //Repetimos el bucle hasta que no se elige la opción 4.

        }


    private static void ejecutarOpcion(int opcion) throws Exception {

            switch (opcion){

            case 1->crearDamaDefecto();


            case 2->{
                crearDamaColor();
            }
            case 3->{
                mover();
            }
            case 4->{
                Consola.salir();
            }
            default -> {
                System.out.println("OPCIÓN INVÁLIDA");
            }
        }
    }


    private static void crearDamaDefecto()
    {
        dama= new Dama();
        System.out.println("Dama creada por defecto: "+dama);

    }

    private static void crearDamaColor() throws Exception {
       Color colorElegido = Consola.elegirColor();
         dama= new Dama(colorElegido);
       System.out.println("Dama creada con el color "+colorElegido+": "+dama);
    }

    private static void mover() throws OperationNotSupportedException {
       if (dama==null){
           System.out.println("No hay dama creada");
           return;
       }//Mostrar el menu de direccion.
       Consola.mostrarMenuDirecciones();
        Direccion direccionElegida = Consola.elegirDireccion();

        mostrarDama();
        try{
            dama.mover(direccionElegida,Consola.elegirPasos());
        }catch (OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
        mostrarDama();



    }

    private static void mostrarDama()
    {
      if (dama==null){
          System.out.println("No hay una dama creada.");
      }else {
          System.out.println("INFORMACIÓN DE LA DAMA: "+dama);
      }
    }
}


