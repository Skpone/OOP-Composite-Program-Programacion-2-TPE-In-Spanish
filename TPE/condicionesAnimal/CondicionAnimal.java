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
public abstract class CondicionAnimal { /*condicion sobre un animal, tmb puede tomar el papel de categoría, si es que se la da*/
    private String retorno;

    public CondicionAnimal(String retorno) {
        this.retorno = retorno;
    }

    public CondicionAnimal() {
        this.retorno = "";
    }
    
    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    public abstract boolean cumple(Animal a);
    
    public String categorizar(Animal a){
        if(this.cumple(a)){
            return retorno;
        }
        return "";
    }
}
