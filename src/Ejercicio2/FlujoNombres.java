package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FlujoNombres {

	public static void main(String[] args) {
		
		// Creamos las instancias de la clase File del fichero de lectura y del fichero de escritura.
		File nombres = new File("."+ File.separator + "src" + File.separator + "Ejercicio2" + File.separator + "nombres.txt");
		File nombres5letras = new File("."+ File.separator + "src" + File.separator + "Ejercicio2" + File.separator + "nombres5letras.txt");

		//Creamos los buffers para el texto de entrada y el de salida.
	    BufferedReader lecturaNombres = null;
	    BufferedWriter escrituraNombres = null;
	    
		try {
		
			lecturaNombres = new BufferedReader(new FileReader(nombres));
			escrituraNombres = new BufferedWriter(new FileWriter(nombres5letras));
			
		//Creamos un bucle que vaya leyendo cada línea.
	    String linea; 

			while((linea = lecturaNombres.readLine())!=null) {	 
				//Dividimos cada línea en partes cada vez que haya un espacio y almacenamos en un array.
                String[] partes = linea.split(" ");
                //Y le decimos que si el primer elemento tiene 5 letras lo escriba en el fichero de salida.
                if (partes.length > 0 && partes[0].length() == 5) {    	
                escrituraNombres.write(partes[0]); 
                escrituraNombres.newLine();
                }
             }    
		}	
		catch (IOException e) {
		e.printStackTrace();		
		}
			
		//Cerramos los ficheros.
		try {
			if (lecturaNombres != null) lecturaNombres.close();	
			if (escrituraNombres != null) escrituraNombres.close();   
			} catch (IOException e) {
			e.printStackTrace();
		}   

	}
}

