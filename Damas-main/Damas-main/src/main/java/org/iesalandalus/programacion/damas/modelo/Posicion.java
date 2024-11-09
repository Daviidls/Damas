package org.iesalandalus.programacion.damas.modelo;

public class Posicion {
    private int fila;
    private char columna;



    private void setFila(int fila)
    {
        if (fila>8 || fila<1){
            throw new IllegalArgumentException("El valor de la fila no puede ser menor de 1 y mayor de 8");
        }
            this.fila=fila;
    }
    public int getFila(){
        return fila;
    }
    private void setColumna(char columna)
    {
        if (columna<'a' || columna> 'h'){
            throw new IllegalArgumentException("El valor de la columna tiene que estar entre 'a' y 'h' ");
        }
        this.columna=columna;
    }

}
