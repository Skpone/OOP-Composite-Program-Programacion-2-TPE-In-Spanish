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
public class CapadoAnimal extends CondicionAnimal{

    public CapadoAnimal() {
        super();
    }
    
    @Override
    public boolean cumple(Animal a) {
        return a.isCapado();
    }
    
}
