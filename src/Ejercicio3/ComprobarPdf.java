package Ejercicio3;

import java.io.*;
import java.util.Arrays;

public class ComprobarPdf {

	public static void main(String[] args) {
		
		//Creamos una instancia de la clase File.
		File fichero = new File("."+ File.separator + "src" + File.separator + "Ejercicio3" + File.separator + "prueba1.pdf");
		
		//Creamos la variable "datos" donde guardaremos el InputStream del fichero.
		FileInputStream datos = null;
		
		try {
			//Guardamos el InputStream en la variable "datos".
			datos = new FileInputStream(fichero);
		
			//Creamos dos Arrays para poder comparar.
			int[] cabecera = {37, 80, 68, 70};
	        int[] pdfHeader = new int[4];
	
	        //Creamos un bucle para obtener los 4 primeros datos y los almacenamos en pdfHeader.
			for (int i = 0; i < 4; i++) {
					pdfHeader[i] = datos.read();
			}
		
			//Comparamos los dos Arrays.
	        if (!Arrays.equals(pdfHeader, cabecera)) {
	            	System.out.println("No es un fichero PDF");
	                System.exit(-1);
	        }
        
	        System.out.println("Sí es un fichero PDF");
	        
		}
		catch (IOException e) {
	    		e.printStackTrace();		
	    	}		
	}
}


