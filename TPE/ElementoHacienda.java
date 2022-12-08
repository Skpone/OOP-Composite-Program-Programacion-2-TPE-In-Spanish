package TPE;

import TPE.condicionesAnimal.CondicionAnimal;
import TPE.condicionesAnimal.TrueAnimal;
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
    
    public abstract double pesoTotal();
    
    public ArrayList<Animal> obtenerAnimales(){
        CondicionAnimal c = new TrueAnimal();
        return this.obtenerAnimales(c); //mas rapido
    };
    
    public abstract ArrayList<Animal> obtenerAnimales(CondicionAnimal c);
    
    public abstract ArrayList<Animal> obtenerAnimales(Camion ca, int espacioRestante);
    
    public abstract boolean eliminarElemento(ElementoHacienda a);
}
