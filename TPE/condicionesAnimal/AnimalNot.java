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
public class AnimalNot extends CondicionAnimal{
    private CondicionAnimal cond;

    public AnimalNot(CondicionAnimal cond, String retorno) {
        super(retorno);
        this.cond = cond;
    }
    
    public AnimalNot(CondicionAnimal cond) {
        this.cond = cond;
    }
    ////no hay get de condicion pq yo si quiero puedo tener acceso directo a la condicion, rompiendo encapsulamiento
    public void setCond(CondicionAnimal cond) {
        this.cond = cond;
    }

    @Override
    public boolean cumple(Animal a) {
        return ! cond.cumple(a);
    }
}
