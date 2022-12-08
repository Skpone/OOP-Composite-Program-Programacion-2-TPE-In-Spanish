/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPE;

import TPE.condicionesAnimal.CondicionAnimal;
import java.util.ArrayList;

/**
 *
 * @author mulat
 */
public class Camion {
    private int capacidad;/*cantidad de animales*/
    private int espacioRestante;
    private CondicionAnimal requisitos; /*esta condicion tmb pueden ser varias (usando una condicion compuesta x ejemplo)*/
    private ArrayList<Animal> animalesCargados;

    public Camion(int capacidad, CondicionAnimal requisitos) {
        this.capacidad = capacidad;
        this.espacioRestante = this.capacidad;
        this.requisitos = requisitos;
        this.animalesCargados = new ArrayList();
    }

    public boolean addAnimal(Animal a){
        if(! animalesCargados.contains(a) && espacioRestante>0){
            espacioRestante--;
            return animalesCargados.add(a);
        }
        return false;
    }
    
    public boolean removeAnimal(Animal a){
        if(animalesCargados.contains(a)){
            espacioRestante++;
            animalesCargados.remove(a);
            return true;
        }
        return false;
    }
    
    public int getCapacidad() {
        return capacidad;
    }

    public int getEspacioRestante() {
        return espacioRestante;
    }
    
    public void setRequisitos(CondicionAnimal requisitos) {
        this.requisitos = requisitos;
    }
    
    public boolean acepta(Animal a){
        return requisitos.cumple(a);
    }

    @Override
    public String toString() {
        return "Camion{" + "espacioRestante=" + espacioRestante + ", animalesCargados= " + animalesCargados + '}';
    }
    
    
}
