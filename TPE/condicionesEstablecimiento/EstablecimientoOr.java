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
public class EstablecimientoOr extends CondicionEstablecimiento{
    private CondicionEstablecimiento cond1;
    private CondicionEstablecimiento cond2;

    public EstablecimientoOr(CondicionEstablecimiento cond1, CondicionEstablecimiento cond2) {
        this.cond1 = cond1;
        this.cond2 = cond2;
    }
    //no hay get de condiciones pq yo si quiero puedo tener acceso directo a la condicion, rompiendo encapsulamiento
    public void setCond1(CondicionEstablecimiento cond1) {
        this.cond1 = cond1;
    }

    public void setCond2(CondicionEstablecimiento cond2) {
        this.cond2 = cond2;
    }
    
    @Override
    public boolean cumple(Establecimiento e) {
        return cond1.cumple(e) || cond2.cumple(e);
    }
    
}
