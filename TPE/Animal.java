package TPE;

import TPE.condicionesAnimal.CondicionAnimal;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mulat
 */
public class Animal extends ElementoHacienda {

    private int identificador;
    private int edad/*en meses*/;
    private double peso/*kg*/;
    private String raza;
    private String sexo;/*macho o hembra*/
    private boolean capado;
    private ArrayList<Animal> ternerosParidos;/*dependiendo el sexo tiene o no tiene ternerosParidos*/

    public Animal(int identificador, int edad, double peso, String raza, String sexo, boolean capado) {
        this.identificador = identificador;
        this.edad = edad;
        this.peso = peso;
        this.raza = raza;
        this.setSexo(sexo);
        this.capado = capado;
        this.ternerosParidos = new ArrayList();
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public String getSexo() {
        return sexo;
    }

    private void setSexo(String sexo) {
        if (sexo.equalsIgnoreCase("macho") || sexo.equalsIgnoreCase("hembra")) {
            this.sexo = sexo;
        } else {
            this.sexo = "hembra"; //de forma predeterminada, se asigna al animal con éste sexo
        }
    }

    public boolean isCapado() {
        return capado;
    }

    public void capar() {
        this.capado = true;
    }
    
    public void agregarTerneroParido(Animal ternero) {
        if (!this.ternerosParidos.contains(ternero) && this.sexo.equalsIgnoreCase("hembra")) {
            /*solo las hembras pueden parir*/
            this.ternerosParidos.add(ternero);
        }
    }
    
    public boolean tieneTernerosParidos(){
        return !ternerosParidos.isEmpty();
    }

    @Override
    public int cantidadAnimales() {
        return 1; //la cantidad de animales que es un objeto animal es uno
    }

    @Override
    public double pesoTotal() { //este metodo a pesar de comportarse igual que "getPeso", esta pensado usarse para busqueda de peso en elementos compuestos
        return this.getPeso();
    }

    @Override
    public ArrayList<Animal> obtenerAnimales(CondicionAnimal c) {
        ArrayList<Animal> resultado = new ArrayList<>();
        if (c.cumple(this)) {
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public ArrayList<Animal> obtenerAnimales(Camion ca, int espacioRestante) {
        ArrayList<Animal> resultado = new ArrayList();
        if (espacioRestante > 0 && ca.acepta(this)) {
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public boolean eliminarElemento(ElementoHacienda a) {
        return false; //este metodo solo esta para que se pueda enviar el mensaje a la lista de elementos, evitamos hacer casteos
    }
    
    @Override
    public boolean equals(Object o) { //se redefine el equals para saber si un animal es igual al otro (por su id)
        try {
            Animal animal = ((Animal) o);
            return this.getIdentificador() == animal.getIdentificador();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Animal{" + "id= " + identificador + '}';
    }
}
