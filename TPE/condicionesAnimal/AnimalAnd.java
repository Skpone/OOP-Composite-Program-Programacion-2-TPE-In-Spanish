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
public class AnimalAnd extends CondicionAnimal{
    private CondicionAnimal cond1;
    private CondicionAnimal cond2;
    
    public AnimalAnd(CondicionAnimal cond1, CondicionAnimal cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }
    ////no hay get de condiciones pq yo si quiero puedo tener acceso directo a la condicion, rompiendo encapsulamiento
    public void setCond1(CondicionAnimal cond1) {
        this.cond1 = cond1;
    }

    public void setCond2(CondicionAnimal cond2) {
        this.cond2 = cond2;
    }

    @Override
    public boolean cumple(Animal a) {
        return cond1.cumple(a) && cond2.cumple(a);
    }
}
