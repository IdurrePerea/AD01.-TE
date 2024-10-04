package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FlujoReves {

	public static void main(String[] args) {
		
		// Creamos las instancias de la clase File del fichero de lectura y del fichero de escritura.
		File texto = new File("."+ File.separator + "src" + File.separator + "Ejercicio1" + File.separator + "texto.txt");
		File textoInvertido = new File("."+ File.separator + "src" + File.separator + "Ejercicio1" + File.separator + "textoInvertido.txt");

		//Creamos los buffers para el texto de entrada y el de salida.
	    BufferedReader mensaje = null;
	    BufferedWriter mensajeInvertido = null;
	    
		try {
		
			mensaje = new BufferedReader(new FileReader(texto));
			mensajeInvertido = new BufferedWriter(new FileWriter(textoInvertido));
			
		//Creamos un bucle que vaya leyendo cada línea e invierta el orden de las letras.
	    String linea; 

			while((linea = mensaje.readLine())!=null) {	 
                String lineaInvertida = new StringBuilder(linea).reverse().toString();
                
                //Escribimos en el fichero de salida el resultado.
                mensajeInvertido.write(lineaInvertida);
                mensajeInvertido.newLine();
			}
		} 
		catch (IOException e) {
		e.printStackTrace();		
		}
		
		//Cerramos los ficheros.
		try {
			mensaje.close();	
			mensajeInvertido.close();   
		} catch (IOException e) {
			e.printStackTrace();
	}   

	}
}
