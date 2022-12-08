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
    private ArrayList<Categoria> categorias;

    public Clasificador() {
        this.categorias = new ArrayList<>();
    }
    
    public boolean addCategoria(Categoria c){
        return categorias.add(c);
    }
    
    public boolean removeCategoria(Categoria c){
        return categorias.remove(c);
    }
    
    public String categorizar(Animal a){
        String resultado = "";
        for(int i=0; i<categorias.size(); i++){
            String nombre = categorias.get(i).categorizar(a);
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
