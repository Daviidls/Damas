package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

   public Dama() {
       this.color = getColor();

       if (color == Color.BLANCO)
       {
           this.posicion = crearPosicionInicial(1, 3); //Posicion inicial para las damas blancas.
       } else if (color == Color.NEGRO)
       {
           this.posicion = crearPosicionInicial(6, 8);//Posicion inicial para las damas negras.
       }
       this.esDamaEspecial= false; //Ahora mismo la dama no llegó al final del tablero por lo tanto no es especial.


   }
   public Dama(Color color)
   {
       this.color=Color.BLANCO; //La dama sera blanca.
       this.posicion= crearPosicionInicialblanca(); //Genera una posicion inicial en este caso siempre del color blanco.
       this.esDamaEspecial = false;//Al principio no es dama especial.
   }
    public Color getColor()
    {
        return color;
    }

    private void setColor(Color color)
    {
        this.color=Objects.requireNonNull(color,"El color no puede ser diferente de Blanco o Negro");
    }


    public Posicion getPosicion()
    {
        return new Posicion(posicion);
    }


    public void setPosicion(Posicion posicion)
    {
        this.posicion=Objects.requireNonNull(posicion,"La posición no puede ser nula");
    }


    private Posicion crearPosicionInicial(int filaMin, int filaMax)//Esto para despues en el metodo Dama poner marcar hasta que fila llega.
    {
        int fila = (int) (Math.random() * 8) + 1;  // Aleatorio entre 1, 2, 3

        char columna;
        if (fila == 1 || fila == 3 || fila == 5 || fila == 7) {
/*El tema de la 'A' es una formula que encontré en internet para poder incluir las letras, segun lo que me he informado
La letra 'A' tiene un valor de 65 y con ese valor se va sumando por ejemplo a 67 que es el valor de C y asi con todas la demas letras.*/
            columna = (char) ('A' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
        } else {

            columna = (char) ('A' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H
        }
        return new Posicion(fila, columna);
    }

    private Posicion crearPosicionInicialblanca()//Este metodo sera es el punto 3 de la tarea para crear una dama blanca.
    {

        int fila = (int) (Math.random() * 3) + 1;  // Aleatorio entre 1, 2, 3

        char columna;
        if (fila == 1 || fila == 3) {

            columna = (char) ('A' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
        } else {

            columna = (char) ('A' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H
        }
        return new Posicion(fila, columna);
    }


    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException
    {
        if(direccion==null)
        {
            throw new IllegalArgumentException("La direccion no puede ser nula");
        }
        if (!esDamaEspecial)
        {
            if (pasos!=1)
            {
              throw new IllegalArgumentException("Las damas normales solo pueden moverse 1 paso hacia su sentido correcto");
            }
            if (color==Color.BLANCO && !(direccion==Direccion.NORESTE || direccion==Direccion.NOROESTE) || color==Color.NEGRO && !(direccion==Direccion.SURESTE || direccion==Direccion.SUROESTE))
            {
               throw new IllegalArgumentException("Las damas blancas solo puede moverse hacia el norte y las damas negras hacia el sur");
            }

        }
        if (color==Color.BLANCO && (posicion.getFila()==8) || color==Color.NEGRO && (posicion.getFila()==1))
        {
            esDamaEspecial=true;
        }
        if (posicion.getFila()>8 || posicion.getFila()<1)
        {
            throw new OperationNotSupportedException("Este movimiento se sale fuera del tablero");
        }
    }

    @Override
    public String toString() {
        return String.format("Dama [color=%s,posicion=%s]",this.color,this.posicion);
    }
}
