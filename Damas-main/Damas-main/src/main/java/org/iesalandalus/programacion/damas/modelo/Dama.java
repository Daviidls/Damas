package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

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
    
}
