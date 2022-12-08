/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPE;

import TPE.condicionesAnimal.CondicionAnimal;

/**
 *
 * @author mulat
 */
public class Categoria {
    private String retorno;
    private CondicionAnimal condicion;

    public Categoria(CondicionAnimal condicion, String retorno) {
        this.retorno = retorno;
        this.condicion = condicion;
    }

    public void setCondicion(CondicionAnimal condicion) {
        this.condicion = condicion;
    }
    
    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    
    public String categorizar(Animal a){
        if(condicion.cumple(a)){
            return retorno;
        }
        return "";
    }
}
