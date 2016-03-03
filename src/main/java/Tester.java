/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juannoguera
 */
public class Tester {
    
    public Tester() {
    }
     
     @Test
     public void Prueba1() throws IOException {
         
         String prueba = "";
         prueba = Calculos.ProcesarArchivos("lista1.txt", "lista3.txt");
         assertNotNull("La respuesta no puede  ser nula", prueba);
         assertNotSame("La respuesta no puede  ser vacía", prueba);
         String[] objeto = prueba.split("#|#");
         assertTrue("El primer valor de la prueba 1 no coincide", (int)Double.parseDouble(objeto[0]) == -22);
         assertTrue("El segundo valor de la prueba 1 no coincide", (int)Double.parseDouble(objeto[2]) == 1);
         assertTrue("El tercer valor de la prueba 1 no coincide", (int)Double.parseDouble(objeto[4]) == 0);
         assertTrue("El tercer valor de la prueba 1 no coincide", (int)Double.parseDouble(objeto[6]) == 0);
         assertTrue("El cuarto valor de la prueba 1 no coincide", (int)Double.parseDouble(objeto[8]) == 644);
     }
}
