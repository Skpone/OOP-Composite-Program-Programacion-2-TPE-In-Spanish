package TPE;

import TPE.condicionesEstablecimiento.CondicionEstablecimiento;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mulat
 */
public class Establecimiento extends ElementoHacienda {

    private ArrayList<ElementoHacienda> elementos;

    public Establecimiento() {
        this.elementos = new ArrayList<>();
    }

    public boolean addElementoHacienda(ElementoHacienda e){
        if(!elementos.contains(e))
            return elementos.add(e);
        return false;
    }
    
    public boolean removeElementoHacienda(ElementoHacienda e){
        return elementos.remove(e);
    }
    
    public double getPromedioEdad() {
        ArrayList<Animal> listaAnimales = this.obtenerAnimales();
        double suma = 0.0;
        for (Animal a : listaAnimales) {
            suma += a.getEdad();
        }
        double promedio = suma / listaAnimales.size();

        return promedio;
    }
    
    public double getPromedioPeso() {
        return this.getPeso()/this.cantidadAnimales();
    }

    public boolean sePuedeVender(CondicionEstablecimiento c) {
        return c.cumple(this);
    }
    
    public boolean llenarCamion(Camion ca) {
        /*no uso ca.getCapacidad(), porque si es que el camion por ejemplo esta lleno, se vuelve a llenar mas lo que ya tenía,
        la capacidad de un camion no es la carga que tiene encima*/
        ArrayList<Animal> animalesAptos = this.obtenerAnimales(ca, ca.getEspacioRestante());
        if(animalesAptos.isEmpty())
            return false;
        for (Animal a : animalesAptos) {
            ca.addAnimal(a);
            this.eliminarElemento(a);
        }
        return true;
    }

    @Override
    public boolean eliminarElemento(ElementoHacienda a) {
        for (ElementoHacienda e : elementos){
            if (e.equals(a)) { //si encuentra al objeto buscado usando el equals respectivo, lo elimina
                elementos.remove(e);
                return true;
            } else {
                if(e.eliminarElemento(a)) //no retorno directamente "e.eliminarElemento(a)" para q siga buscando en otros elementos
                    return true;
            }
        }
        return false;//si no lo encontro
    }

    @Override
    public int cantidadAnimales() {
        int cantidad = 0;
        for (ElementoHacienda e : elementos) {
            cantidad += e.cantidadAnimales();
        }
        return cantidad;
    }

    @Override
    public double getPeso() {
        double pesoTotal = 0.0;
        for (ElementoHacienda e : elementos) {
            pesoTotal += e.getPeso();
        }
        return pesoTotal;
    }

    @Override
    public ArrayList<Animal> obtenerAnimales() {
        ArrayList<Animal> resultado = new ArrayList<>();
        for (ElementoHacienda e : elementos) {
            resultado.addAll(e.obtenerAnimales());
        }
        return resultado;
    }

    @Override
    public ArrayList<Animal> obtenerAnimales(Camion ca, int espacioRestante) {
        ArrayList<Animal> resultado = new ArrayList();
        int i = 0;
        while (i < elementos.size()/*-1?*/ && espacioRestante > 0) {
            ArrayList<Animal> animales = elementos.get(i).obtenerAnimales(ca, espacioRestante);
            if (!animales.isEmpty()) {
                espacioRestante = espacioRestante - animales.size();
                resultado.addAll(animales);
            }
            i++;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Establecimiento{" + "elementos=" + elementos + '}';
    }

}
