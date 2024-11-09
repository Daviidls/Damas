package org.iesalandalus.programacion.damas.modelo;

public class Posicion {
    private int fila;
    private char columna;

    public Posicion(int fila, char columna) //Contructor que acepte los parametros columna y fila.
    {
        setColumna(columna);
        setFila(fila);
    }

    private void setFila(int fila)
    {
        if (fila>8 || fila<1){ //Comprobación para que no se genere una dama en una fila erronea.
            throw new IllegalArgumentException("El valor de la fila no puede ser menor de 1 y mayor de 8");
        }
            this.fila=fila;
    }
    public int getFila(){
        return fila;
    }
    private void setColumna(char columna)
    {
        if (columna<'a' || columna> 'h'){ //Comprobación para que no se genere una dama en una columna erronea.
            throw new IllegalArgumentException("El valor de la columna tiene que estar entre 'a' y 'h' ");
        }
        this.columna=columna;
    }

}
