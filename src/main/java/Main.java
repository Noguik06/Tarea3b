import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());
    
     get("/tarea3", (request, response) -> {
         Map<String, Object> attributes = new HashMap<>();
         ArrayList<String> output = new ArrayList<String>();
         String prueba = "";
        try {
            prueba = Calculos.ProcesarArchivos("lista1.txt", "lista3.txt");
            String[] objeto = prueba.split("#|#");
            DecimalFormat f = new DecimalFormat("##.000");
            
            attributes.put("message", "Los valores de la prueba 1 que se espera son: \n"
                 + "b0 = -22.55  b1 = 1.7279 rxy = 0.9545 r2 = 0.9111 yk = 644.29");
            attributes.put("message2", "Los valores de la prueba 1 que resultaron son: \n"
                 + "b0 = "+ f.format(Double.parseDouble(objeto[0]))  + " b1 ="+  f.format(Double.parseDouble(objeto[2])) + " "
                 + "rxy = "+ f.format(Double.parseDouble(objeto[4])) + " r2 ="+ f.format(Double.parseDouble(objeto[6]))+ " yk = " 
                 + f.format(Double.parseDouble(objeto[8])));
            
            
            prueba = Calculos.ProcesarArchivos("lista1.txt", "lista4.txt");
            objeto = prueba.split("#|#");
            
            attributes.put("message3", "Los valores de la prueba 2 que se espera son: \n"
                 + "b0 = -4.039  b1 = 0.1681 rxy = 0.9333 r2 = .8711 yk = 60.858");
            attributes.put("message4", "Los valores de la prueba 2 que resultaron son: \n"
                 + "b0 = "+ f.format(Double.parseDouble(objeto[0]))  + " b1 ="+  f.format(Double.parseDouble(objeto[2])) + " "
                 + "rxy = "+ f.format(Double.parseDouble(objeto[4])) + " r2 ="+ f.format(Double.parseDouble(objeto[6]))+ " yk = " 
                 + f.format(Double.parseDouble(objeto[8])));
            
            
            prueba = Calculos.ProcesarArchivos("lista2.txt", "lista3.txt");
            objeto = prueba.split("#|#");
            attributes.put("message5", "Los valores de la prueba 3 que se espera son: \n"
                 + "b0 = -23.92  b1 = 1.43097 rxy = .9631 r2 = 0.9276 yk = 528.4294");
            attributes.put("message6", "Los valores de la prueba 3 que resultaron son: \n"
                 + "b0 = "+ f.format(Double.parseDouble(objeto[0]))  + " b1 ="+  f.format(Double.parseDouble(objeto[2])) + " "
                 + "rxy = "+ f.format(Double.parseDouble(objeto[4])) + " r2 ="+ f.format(Double.parseDouble(objeto[6]))+ " yk = " 
                 + f.format(Double.parseDouble(objeto[8])));
            
            prueba = Calculos.ProcesarArchivos("lista1.txt", "lista3.txt");
            objeto = prueba.split("#|#");
            attributes.put("message7", "Los valores de la prueba 4 que se espera son: \n"
                 + "b0 = -4.604  b1 = 0.140164 rxy = .9480 r2 = .8988 yk = 49.4994");
            attributes.put("message8", "Los valores de la prueba 5 que resultaron son: \n"
                 + "b0 = "+ f.format(Double.parseDouble(objeto[0]))  + " b1 ="+  f.format(Double.parseDouble(objeto[2])) + " "
                 + "rxy = "+ f.format(Double.parseDouble(objeto[4])) + " r2 ="+ f.format(Double.parseDouble(objeto[6]))+ " yk = " 
                 + f.format(Double.parseDouble(objeto[8])));
        } catch (IOException ex) {
            attributes.put("message", "Error " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return new ModelAndView(attributes, "tarea3.ftl");
        }, new FreeMarkerEngine());
//    get("/tarea3", (request, response) -> {
//        try {
//            String tabla1 = Calculos.ProcesarArchivos("lista1.txt", "lista3.txt");
//            String tabla2 = Calculos.ProcesarArchivos("lista1.txt", "lista4.txt");
//            String tabla3 = Calculos.ProcesarArchivos("lista2.txt", "lista3.txt");
//            String tabla4 = Calculos.ProcesarArchivos("lista2.txt", "lista4.txt");
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           
//        }, new FreeMarkerEngine());


  }

}
