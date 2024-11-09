package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {
    NORESTE("Noreste"),
    SURESTE("Sureste"),
    NOROESTE("Noroeste"),
    SUROESTE("Suroeste");

    private String cadenaAMostrar;

    private Direccion(String cadenaAMostrar)
    {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
