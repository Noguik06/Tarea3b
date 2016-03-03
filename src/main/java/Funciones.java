/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author juannoguera
 */
public class Funciones {
    public static double media(LinkedList lista){
        Iterator it = lista.iterator();
        double suma = 0;
        while(it.hasNext()){
            suma += Double.parseDouble(it.next().toString());
        }
        return suma/lista.size();
    }
    
    public static double sum(LinkedList lista){
        Iterator it = lista.iterator();
        double suma = 0;
        while(it.hasNext()){
            suma += Double.parseDouble(it.next().toString());
        }
        return suma;
    }
    
    public static double desviacion(LinkedList lista, double media){
        Iterator it = lista.iterator();
        double suma = 0;
        while(it.hasNext()){
            suma += Math.pow(Double.parseDouble(it.next().toString()) - media, 2);
        }
        return Math.sqrt(suma/(lista.size()-1));
    }
    
    public static double sumatoriacuadrado(LinkedList lista){
        return 0;
    }
    
    public static double sumatoriamultiplicacion(LinkedList lista1, LinkedList lista2){
        Iterator it1 = lista1.iterator();
        Iterator it2 = lista2.iterator();
        double suma = 0;
        while(it1.hasNext()){
            String valor1 = it1.next().toString();
            String valor2 = it2.next().toString();
            suma += Double.parseDouble(valor1)*Double.parseDouble(valor2);
        }
        return suma;
    }
    
    public static double b1(double sumMulti, double sizeList, double mediax, double mediay, double sumsqtx){
        double total = 0;
        double numerador = (sumMulti) - (sizeList*mediax*mediay);
        double denominador = (sumsqtx) - (sizeList*Math.pow(mediax, 2));
        return numerador/denominador;
    }
    
    public static double b0(double mediay, double b1, double mediax){
        return mediay - ((b1)*mediax);
    }
    
}
