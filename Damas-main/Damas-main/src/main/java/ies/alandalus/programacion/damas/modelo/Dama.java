package ies.alandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

   public Dama() {
    color=Color.BLANCO;
    posicion= new Posicion(crearPosicionInicial());
    esDamaEspecial=false;
   }
   public Dama(Color color) {
       if (color==Color.BLANCO){
           int filaDama=(int) (Math.random()*3)+1;
           char columnaDama=0;
           if (filaDama == 1 || filaDama == 3 ) {
            /*El tema de la 'A' es una formula que encontré en internet para poder incluir las letras, segun lo que me he informado
            La letra 'A' tiene un valor de 65 y con ese valor se va sumando por ejemplo a 67 que es el valor de C y asi con todas la demas letras.*/
               columnaDama = (char) ('a' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
           } else if (filaDama==2) {

               columnaDama = (char) ('a' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H)
           }
           setColor(color);
           posicion= new Posicion(filaDama,columnaDama);
           esDamaEspecial=false;
       }
       if (color==Color.NEGRO){
           int filaDama=(int) (Math.random()*3)+6;
           char columnaDama=0;
           if (filaDama == 6 || filaDama == 8 ) {
            /*El tema de la 'A' es una formula que encontré en internet para poder incluir las letras, segun lo que me he informado
            La letra 'A' tiene un valor de 65 y con ese valor se va sumando por ejemplo a 67 que es el valor de C y asi con todas la demas letras.*/
               columnaDama = (char) ('a' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
           } else if (filaDama==7) {

               columnaDama = (char) ('a' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H)
           }
           setColor(color);
           posicion= new Posicion(filaDama,columnaDama);
           esDamaEspecial=false;
       }

   }

    private void  setColor(Color color){
       if (color!=Color.BLANCO && color!=Color.NEGRO){
           throw new IllegalArgumentException("El color no es el esperado");
       }
       this.color=color;
    }


    public Color getColor()
    {
        return color;
    }

    public Posicion getPosicion()
    {
        return new Posicion(posicion);
    }


    public void setPosicion(Posicion posicion)
    {
        if (posicion==null){
            throw new IllegalArgumentException("la posicion no puede ser nula");
        }
        this.posicion=posicion;
    }


    private Posicion crearPosicionInicial()
    {

        if (color==Color.BLANCO){
            int fila = (int) (Math.random() * 3) + 1;  // Aleatorio entre 1-3
            char columna= 0;
            if (fila == 1 || fila == 3 ) {
/*El tema de la 'A' es una formula que encontré en internet para poder incluir las letras, segun lo que me he informado
La letra 'A' tiene un valor de 65 y con ese valor se va sumando por ejemplo a 67 que es el valor de C y asi con todas la demas letras.*/
            columna = (char) ('a' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
            } else if (fila==2){

            columna = (char) ('a' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H
         }
            this.posicion=new Posicion(fila, columna);
        }
        if (color==Color.NEGRO){
            int fila = (int) (Math.random() *3 )+6;  // Aleatorio entre 6-8
            char columna = 0;
            if (fila == 6 || fila == 8 ) {
/*El tema de la 'A' es una formula que encontré en internet para poder incluir las letras, segun lo que me he informado
La letra 'A' tiene un valor de 65 y con ese valor se va sumando por ejemplo a 67 que es el valor de C y asi con todas la demas letras.*/
                columna = (char) ('a' + (Math.random() * 4) * 2);  // Aleatorio entre A, C, E, G
            } else if (fila==7){

                columna = (char) ('a' + (Math.random() * 4) * 2 + 1);  // Aleatorio entre B, D, F, H
            }
            this.posicion=new Posicion(fila,columna);
        }
            return posicion;
       }

       public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {   //Verificar que la direccion no sea nula
           int nuevaFila= posicion.getFila();
           int nuevaColumna= posicion.getColumna();

                if (direccion== null){
                throw new IllegalArgumentException("La direccion no puede ser nula");
        }
            //Verificar que los pasos sean validos.

            if (!esDamaEspecial) {
                if (pasos!=1){
                    throw new IllegalArgumentException("Los pasos tienen que ser igual a 1");
                }
                if (color == Color.BLANCO) {
                    // Dama blanca solo puede moverse hacia Noreste o Noroeste
                    if (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE) {
                        throw new OperationNotSupportedException("La dama blanca solo puede moverse Noreste o Noroeste.");
                    }
                } else if (color == Color.NEGRO) {
                    // Dama negra solo puede moverse hacia Sureste o Suroeste
                    if (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE) {
                        throw new OperationNotSupportedException("La dama negra solo puede moverse Sureste o Suroeste.");
                    }
                }
            }



            switch (direccion){
                case NORESTE -> {
                    nuevaFila+=pasos;
                    nuevaColumna+=pasos;
                    break;
                }
                case SURESTE -> {
                    nuevaFila -= pasos;
                    nuevaColumna+=pasos;
                    break;
                }
                case SUROESTE ->{
                    nuevaFila -= pasos;
                    nuevaColumna -= pasos;
                    break;
                }
                case NOROESTE ->{
                    nuevaFila += pasos;
                    nuevaColumna -= pasos;
                    break;
                }
                default -> {
                    throw new IllegalArgumentException("Direccion desconocida");
                }
            }
            //Verificar si el movimiento es valido dentro del tablero
            if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
                throw new OperationNotSupportedException("El movimiento esta fuera del tablero");
        }
            this.posicion = new Posicion(nuevaFila, (char) nuevaColumna);
            //Verificar si la dama se convierte en dama especial.
            if ((color==Color.BLANCO && nuevaFila==8 ) || (color== Color.NEGRO && nuevaFila== 1)){
                esDamaEspecial= true;
            }


        }
        @Override
    public String toString() {
        return String.format("Dama [color=%s,posicion=%s especial=%s]",this.color,this.posicion, this.esDamaEspecial);
    }


}

