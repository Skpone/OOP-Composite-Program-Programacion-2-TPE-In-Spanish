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
public class RazaAnimal extends CondicionAnimal{
    private String raza;

    public RazaAnimal(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    @Override
    public boolean cumple(Animal a) {
        return a.getRaza().equalsIgnoreCase(raza);
    }
    
}
