package TPE;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mulat
 */
public abstract class ElementoHacienda {
    public abstract int cantidadAnimales();
    
    public abstract double getPeso();
    
    public abstract ArrayList<Animal> obtenerAnimales();
    
    public abstract ArrayList<Animal> obtenerAnimales(Camion ca, int espacioRestante);
    
    public abstract boolean eliminarElemento(ElementoHacienda a);
}
