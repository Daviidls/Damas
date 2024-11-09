package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

   public Dama()
   {

   }
   public Dama(Color color)
   {
       this.color=Color.BLANCO; //La dama sera blanca.
       this.posicion= crearPosicionInicial(); //Genera una posicion inicial en este caso siempre del color blanco.
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
    private Posicion crearPosicionInicial()
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



}
