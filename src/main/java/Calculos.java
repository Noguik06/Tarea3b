/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juannoguera
 */
public class Calculos {
   public static String ProcesarArchivos(String archivoX, String archivoY) throws IOException{
        String respuesta = "";
        // TODO code application logic here
        LinkedList lista1 = LeerArchivos.getLista(archivoX);
        LinkedList lista2 = LeerArchivos.getLista(archivoY);
        double sumx = Funciones.sum(lista1);
        double sumy = Funciones.sum(lista2);
        double mediax = Funciones.media(lista1);
        double mediay = Funciones.media(lista2);
        double summultix = Funciones.sumatoriamultiplicacion(lista1, lista1);
        double summultiy = Funciones.sumatoriamultiplicacion(lista2, lista2);
        double summultixy = Funciones.sumatoriamultiplicacion(lista1, lista2);
        double b1 = Funciones.b1(summultixy, lista1.size(), mediax, mediay, summultix);
        double b2 = Funciones.b0(mediay, b1, mediax);
        //Averiguamos el numerados
        double rxyNumerador = (lista1.size()*summultixy) - (sumx*sumy);
        double rxydenominador =  (lista1.size()*summultix) - Math.pow(sumx,2);
        rxydenominador = rxydenominador*((lista1.size()*summultiy)-Math.pow(sumy,2));
        rxydenominador = Math.sqrt(rxydenominador);
        double rxy = rxyNumerador/rxydenominador;
        //Averiguamos el b0
        double b0 = mediay-(b1*mediax);
        //Averiguamos yk
        double yk = b0 + (b1*386);
        respuesta = b0 + "#|#" + b1 + "#|#" + rxy + "#|#" +  Math.pow(rxy, 2) + "#|#" +yk;
        return respuesta;
   }
}
