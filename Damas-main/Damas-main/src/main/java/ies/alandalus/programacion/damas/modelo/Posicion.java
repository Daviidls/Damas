package ies.alandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    public Posicion(int fila, char columna) //Contructor que acepte los parametros columna y fila.
    {
        setColumna(columna);
        setFila(fila);
    }
    public Posicion (Posicion posicion){

        fila= posicion.fila;
        columna= posicion.columna;
    }

    private void setFila(int fila)
    {
        if (fila>8 || fila<1){ //Comprobación para que no se pase una dama a fila erronea.
            throw new IllegalArgumentException("El valor de la fila no puede ser menor de 1 y mayor de 8");
        }
            this.fila=fila;
    }
    public int getFila(){
        return fila;
    }
    public char getColumna()
    {
        return columna;
    }
    private void setColumna(char columna)
    {
        if (columna<'a' || columna> 'h'){ //Comprobación para que no se genere una dama en una columna erronea.
            throw new IllegalArgumentException("El valor de la columna tiene que estar entre 'a' y 'h' ");
        }
        this.columna=columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }
    public String toString(){
        return String.format("ies.alandalus.programacion.damas.modelo.Posicion[Fila=%s, Columna=%s]", this.fila, this.columna);
    }
}



