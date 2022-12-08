/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPE.condicionesEstablecimiento;

import TPE.Establecimiento;

/**
 *
 * @author mulat
 */
public class PromedioEdadMayor extends CondicionEstablecimiento{
    private int edadMinima;

    public PromedioEdadMayor(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    
    @Override
    public boolean cumple(Establecimiento e) {
        return e.getPromedioEdad()>edadMinima;
    }
    
}
