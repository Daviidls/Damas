package ies.alandalus.programacion.damas.modelo;

public enum Color {
    BLANCO("Blanco"),
    NEGRO("Negro");

    private String cadenaAMostrar;

    private Color(String cadenaAMostrar)
    {
        this.cadenaAMostrar = cadenaAMostrar;
    }
    public String toString(){
        return cadenaAMostrar;
    }
}