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
public class Clasificador {
    private ArrayList<CondicionAnimal> condicionesCategorizadoras;//condiciones para clasificar a un animal

    public Clasificador() {
        this.condicionesCategorizadoras = new ArrayList<>();
    }
    
    public boolean addCategoria(CondicionAnimal c){
        return condicionesCategorizadoras.add(c);
    }
    
    public boolean removeCategoria(CondicionAnimal c){
        return condicionesCategorizadoras.remove(c);
    }
    
    public String categorizar(Animal a){
        String resultado = "";
        for(int i=0; i<condicionesCategorizadoras.size(); i++){
            String nombre = condicionesCategorizadoras.get(i).categorizar(a);
            if(!nombre.equals("")){
                if(!resultado.equals(""))
                    resultado = resultado+"-"+nombre;
                else
                    resultado = resultado+nombre;
            }
        }
        return resultado;
    }
}
