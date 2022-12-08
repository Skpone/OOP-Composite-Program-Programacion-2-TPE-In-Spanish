/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPE.condicionesAnimal;

import TPE.Animal;

/**
 *
 * @author mulat
 */
public class PesoMayorAnimal extends CondicionAnimal{
    private double peso;

    public PesoMayorAnimal(double peso) {
        /*super() implicito*/
        this.peso = peso;
    }
    
    public PesoMayorAnimal(String retorno, double peso) {
        super(retorno);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean cumple(Animal a) {
        return a.getPeso()>peso;
    }
    
    
}
