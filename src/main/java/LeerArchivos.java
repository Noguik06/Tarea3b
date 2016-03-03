/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author juannoguera
 */
public class LeerArchivos {

    public static LinkedList getLista(String fileName) throws FileNotFoundException, IOException {
        LinkedList lista = new LinkedList();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if(line.matches("[-+]?\\d*\\.?\\d+"))
                lista.add(line);
        }
        in.close();

        return lista;
    }
}
