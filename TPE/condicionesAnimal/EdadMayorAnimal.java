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
public class EdadMayorAnimal extends CondicionAnimal{
    private int edad;

    public EdadMayorAnimal(int edad) {
        super();
        this.edad = edad;
    }
    
    public EdadMayorAnimal(String retorno, int edad){
        super(retorno);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean cumple(Animal a) {
        return a.getEdad()>edad;
    }
    
}
