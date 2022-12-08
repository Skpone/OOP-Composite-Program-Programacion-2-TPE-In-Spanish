/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPE;

import TPE.condicionesAnimal.AnimalAnd;
import TPE.condicionesAnimal.AnimalNot;
import TPE.condicionesAnimal.AnimalOr;
import TPE.condicionesAnimal.CapadoAnimal;
import TPE.condicionesAnimal.CondicionAnimal;
import TPE.condicionesAnimal.EdadMayorAnimal;
import TPE.condicionesAnimal.ParioAnimal;
import TPE.condicionesAnimal.PesoMayorAnimal;
import TPE.condicionesAnimal.RazaAnimal;
import TPE.condicionesAnimal.SexoAnimal;
import TPE.condicionesEstablecimiento.EstablecimientoOr;
import TPE.condicionesEstablecimiento.PromedioEdadMayor;
import TPE.condicionesEstablecimiento.PromedioPesoMayor;
import java.util.ArrayList;

/**
 *
 * @author mulat
 */
public class Main {
    public static void main(String args[]){
        //creamos animales
        Animal juansito = new Animal(1, 3, 105.3, "holstein", "macho", false);
        Animal irene = new Animal(2, 50, 400.5, "holstein", "hembra", false);
        Animal franco = new Animal(3, 80, 500.4, "peludo", "macho", true);
        Animal luciano = new Animal(4, 197, 1500.31, "marchigiano", "macho", true);
        Animal francisca = new Animal(5, 9, 70.23, "blonde de aquitania", "hembra", false);
        Animal franchesca = new Animal(6, 100, 1200.3, "salers", "hembra", true);
        Animal juana = new Animal(7, 50, 800.0, "limousin", "", false);
        Animal jorge = new Animal(8, 60, 1500.3, "chianina", "macho", false);
        Animal nahuel = new Animal(9, 20, 1000.3, "beefmaster", "macho", false);
        
        //
        juana.agregarTerneroParido(juansito);
        irene.agregarTerneroParido(francisca);
        //creamos establecimientos y le asignamos animales PD: nombre de las variables hacen referencia a 3 grupos mencionados en la consigna para mostrar de q son lo mismo
        Establecimiento haciendaJonny = new Establecimiento();
        haciendaJonny.addElementoHacienda(juansito);
        haciendaJonny.addElementoHacienda(francisca);
        
        Establecimiento rodeoXV = new Establecimiento();
        rodeoXV.addElementoHacienda(irene);
        rodeoXV.addElementoHacienda(franchesca);
        
        Establecimiento rodeoII = new Establecimiento();
        rodeoII.addElementoHacienda(franco);
        rodeoII.addElementoHacienda(luciano);
        rodeoII.addElementoHacienda(nahuel);
        
        Establecimiento empresaLaRural = new Establecimiento();
        empresaLaRural.addElementoHacienda(jorge);
        empresaLaRural.addElementoHacienda(juana);
        
        //asignamos establecimientos dentro de otros
        empresaLaRural.addElementoHacienda(rodeoII);
        empresaLaRural.addElementoHacienda(rodeoXV);
        rodeoXV.addElementoHacienda(haciendaJonny);
        
        //resp a "SERVICIOS BASICOS"
        //1 obtener cantidad de animales de un establecimiento
        System.out.println(empresaLaRural.cantidadAnimales()); //debería imprimir 9
        System.out.println(haciendaJonny.cantidadAnimales()); //2
        
        //2 obtener promedio de edad de todos los animales del establecimiento
        System.out.println(haciendaJonny.getPromedioEdad()); //retorna 6.0 (juansito tiene 3 y francisca tiene 9(meses))dividivo 2
        
        //3 obtener el peso total de un establecimiento
        System.out.println(empresaLaRural.getPeso());
        System.out.println(rodeoXV.getPeso()); //(irene = 400.5, franchesca = 1200.3, juansito = 105.3 y francisca = 70.23) = 1776.33
        
        //4 obtener promedio de peso de animales en un establecimiento
        System.out.println(haciendaJonny.getPromedioPeso());//(francisca = 70.23 y juansito = 105.3)/2 = 87.765
        
        //resp a "Es posible consultar si un grupo de animales..."
        //1) Que el promedio del peso de cada animal del grupo sea superior a 650 Kg
        System.out.println(rodeoII.sePuedeVender(new PromedioPesoMayor(650)));//(500.4 + 1500.31 + 1000.3)/3 = 1000.33 = true
        System.out.println(haciendaJonny.sePuedeVender(new PromedioPesoMayor(650)));//false
        
        //2) Que el promedio de edad de cada animal del grupo sea mayor a 24 meses
        System.out.println(rodeoXV.sePuedeVender(new PromedioEdadMayor(24)));//irene 50, franchesca 100
        
        //3) Que el promedio de edad del grupo de animales sea superior a 36 meses o que el peso sea mayor a 700 Kg.
        System.out.println(rodeoII.sePuedeVender(new EstablecimientoOr(new PromedioEdadMayor(700), new PromedioEdadMayor(36))));//true pq ya sabemos q el promedio del peso es 1000.33
        
        //resp a "se debe proveer también mecanismos que permitan armar camiones para la venta de animales"
        //PD: un camion en cualquier momento podría cambiar sus requisitos; ejemplo en el camion wakawaka
        
        //1)Todos los animales deben ser de la raza “aberdeen angus”
        Camion camionManolito = new Camion(2, new RazaAnimal("aberdeen angus"));
        haciendaJonny.llenarCamion(camionManolito);
        System.out.println(haciendaJonny); //como en la haciendaJonny no existen animales de esa raza, se puede ver q todavía estan
        System.out.println(camionManolito); //camion esta sin animales, mismo espacio restante
        
        //2)Todos los animales deben tener un peso superior a 650 Kg.
        Camion camionWakaWaka = new Camion(3, new PesoMayorAnimal(650));
        rodeoII.llenarCamion(camionWakaWaka); //entra luciano y nahuel
        System.out.println(rodeoII); //2 ya no estan
        System.out.println(camionWakaWaka); //1 espacio restante y 2 animales dentro
        
        //3)Todos los animales deben tener una edad superior a 4 años.
        Camion camionParaGrandes = new Camion(1, new EdadMayorAnimal(48/*4 anios en meses*/));
        rodeoXV.llenarCamion(camionParaGrandes); //entra solo irene a pesar de tener 2 vacas mayores a 48 meses, pq no hay mas espacio en el camion
        System.out.println(rodeoXV);
        System.out.println(camionParaGrandes);
        
        //4)Todos los animales deben tener un peso superior a 500 Kg o una edad superior a 5 años
        CondicionAnimal condCompuesta = new AnimalOr(new PesoMayorAnimal(500), new EdadMayorAnimal(60/*5 anios en meses*/));
        camionWakaWaka.setRequisitos(condCompuesta); //camionWakaWaka cambio sus requisitos, pero solo le quedo 1 espacio restante
        empresaLaRural.llenarCamion(camionWakaWaka); //entra jorge pq es el primer animal que tiene que justo cumple con la condicion, hay siguientes que cumplen pero no hay mas espacio
        System.out.println(camionWakaWaka);
        
        //5)Todos los animales deben tener una edad superior a 3 años y ser de la raza “Hereford”.
        Camion camionUlt = new Camion(4, new AnimalAnd(new EdadMayorAnimal(36/*3 anios en meses*/), new RazaAnimal("hereford")));
        empresaLaRural.llenarCamion(camionUlt);
        System.out.println(camionUlt);
        
        
        //resp a " poder clasificar a un animal acorde a lo determinado por Ministerio de Agricultura y Pesca"
        Clasificador ministerio = new Clasificador();
        
        //asignamos "categorias"(Condiciones) a un clasificador PD: las codiciones tambien pueden actuar como categorias
        EdadMayorAnimal condicion1 = new EdadMayorAnimal(8);
        EdadMayorAnimal condicion2 = new EdadMayorAnimal(12);
        EdadMayorAnimal condicion3 = new EdadMayorAnimal(24);
        EdadMayorAnimal condicion4 = new EdadMayorAnimal(48);
        CapadoAnimal condicion5 = new CapadoAnimal();
        ParioAnimal condicion6 = new ParioAnimal();
        SexoAnimal condicion7 = new SexoAnimal("hembra");

        //condicion1.setEdad(12); si yo hago esto, directamente estoy cambiando el comportamiento y este objeto va a ser usado para x ejemplo definir un novillo, no puedo cambiarlo, a no ser que cree una copia
        
        //1)Lechal. Animales con una edad inferior a los 8 meses
        ministerio.addCategoria(new Categoria(new AnimalNot(condicion1), "Lechal"));
        //2)Ternero. Animales con una edad comprendida entre los 8 meses y el año de edad
        ministerio.addCategoria(new Categoria(new AnimalAnd(condicion1, new AnimalNot(condicion2)), "Ternero"));
        //3)Añojo. Son los animales que tienen entre 12 y 24 meses de edad.
        ministerio.addCategoria(new Categoria(new AnimalAnd(condicion2, new AnimalNot(condicion3)), "Añojo"));
        //4)Novillo. Animales con una edad comprendida entre los 2 y los 4 años
        ministerio.addCategoria(new Categoria(new AnimalAnd(condicion3, new AnimalNot(condicion4)), "Novillo"));
        //5)Cebón. Es el macho capado al año de edad que no ha llegado a cumplir los 48 meses
        ministerio.addCategoria(new Categoria(new AnimalAnd(new AnimalNot(condicion4), condicion5), "Cebón"));
        //6)Vaquillona: hembra mas de 15 meses, que nunca parió un ternero
        ministerio.addCategoria(new Categoria(new AnimalAnd(new AnimalAnd(new EdadMayorAnimal(15), condicion7), new AnimalNot(condicion6)), "Vaquillona"));
        //7)Vaca. Vaquillona que ya ha parido un ternero.
        ministerio.addCategoria(new Categoria(new AnimalAnd(new AnimalAnd(new EdadMayorAnimal(15), condicion7), condicion6), "Vaca"));
        //8)Buey. Ejemplar macho mayor de 48 meses y capado.
        ministerio.addCategoria(new Categoria(new AnimalAnd(new AnimalAnd(condicion4, condicion5), new AnimalNot(condicion7)/*o new SexoAnimal("macho")*/), "Buey"));
        //9)Toro. Ejemplar macho que no fue capado.
        ministerio.addCategoria(new Categoria(new AnimalAnd(new SexoAnimal("macho")/*o new AnimalNot(condicion7)*/, new AnimalNot(condicion5)),"Toro"));

                
        ArrayList<Animal> todosAnimales = empresaLaRural.obtenerAnimales();
        for(Animal animal:todosAnimales){
            //mostramos cada animal q categoría es (los restantes que quedaron en la empresa)
            System.out.println(animal+" es: "+ministerio.categorizar(animal));
        }
        
        //resp ult parte
        //imaginemos que ahora nuestra empresa desea basar la categorizacion de otras organizaciones o hasta podría suceder q el ministerio cambie sus categorías
        //simplemente consultamos las categorias a otros clasificadores
        Clasificador pepitoONG = new Clasificador();
        pepitoONG.addCategoria(new Categoria(new AnimalNot(condicion7), "TORO"));// "...Si es Macho es TORO"
        pepitoONG.addCategoria(new Categoria(condicion7, "VACA"));// "...y si es Hembra es VACA"
        
        for(Animal animal:todosAnimales){
            //mostramos cada animal q categoría es (los restantes que quedaron en la empresa)
            System.out.println(animal+" es: "+pepitoONG.categorizar(animal));
        }
        
    }
}
