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
public class PromedioPesoMayor extends CondicionEstablecimiento{
    private int pesoMinimo;

    public PromedioPesoMayor(int pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public int getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(int pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }
    
    @Override
    public boolean cumple(Establecimiento e) {
        return e.pesoPromedio()>pesoMinimo;
    }
    
}
