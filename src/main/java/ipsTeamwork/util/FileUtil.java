package ipsTeamwork.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
	
public static Map<String, String> cargarTiempos (String nombreFicheroEntradaCarrera) {
		Map<String, String> map = new HashMap<String, String>();
	    String linea;
	    String[] datos= null;	 
	    
	    

	    
	    try {
	    	   BufferedReader fichero= new BufferedReader(new FileReader("files/" + nombreFicheroEntradaCarrera+".txt"));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			datos = linea.split("-");
	    		
	    			
	    			String tiempoTotal = String.valueOf(Integer.parseInt(datos[2]) - Integer.parseInt(datos[1]));
	    			
	    			if(tiempoTotal.equals("0")) {
	    				tiempoTotal = "NF";
	    			}
	    			
	    			map.put(datos[0], tiempoTotal);
	    		}
	    		
	    		
	    		
	    		 
	    		fichero.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("El archivo no se ha encontrado.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("Error de entrada/salida.");
	    } 
	    
	    return map;
	  }


}
