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
public class SexoAnimal extends CondicionAnimal{
    private String sexo;

    public SexoAnimal(String retorno,String sexo) {
        super(retorno);
        this.setSexo(sexo);
    }

    public SexoAnimal(String sexo) {
        super();
        this.setSexo(sexo);
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public void setSexo(String sexo){
        if(sexo.equalsIgnoreCase("macho") || sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
        else
            this.sexo = "hembra"; //valor predeterminado
    }
    
    @Override
    public boolean cumple(Animal a) {
        return a.getSexo().equalsIgnoreCase(sexo);
    }
    
}
