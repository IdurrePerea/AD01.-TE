package Ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificaDatos {
		
	public static void main(String[] args) throws IOException {
		
		final int long_registro = 110; //Longitud del registro 
			
		try	{
			
			File fichero = new File("."+ File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
				
			int pesoConsola, pesoFichero, diferenciaPeso, posicion;
			String dniConsola, dniFichero;
			String nombreFichero, identidadFichero, tipoFichero;
			
				char [] aux = new char[20];
				
				System.out.println("Introduzca el DNI (con letra) del personaje para control de peso:");
				dniConsola = Consola.readString().trim();
				posicion = (dniConsola - 1) * long_registro;
				
	            for (int i = 0; i < file.length() / long_registro; i++) {
	                file.seek(i * long_registro);
	                dniFichero = readString(file, 9).trim();

	                if (dniFichero.equals(dniConsola)) {
	                    encontrado = true;
	                    // Leemos el resto de los datos
	                    nombreFichero = readString(file, 10).trim(); // Leer nombre de 10 caracteres
	                    pesoFichero = file.readInt();
						System.out.println("Introduzca el peso del último mes:");
						pesoConsola = Consola.readInt();
						file.seek(posicion);
						dniFichero=file.readLine().trim();

		                    
						for (int i=0;i<20;i++) {
							aux[i]=file.readChar();
						}
						nombreFichero= new String(aux).trim();
						
						pesoFichero = file.readInt();
						diferenciaPeso = pesoConsola - pesoFichero;
						file.seek(posicion+164); 
						file.writeInt(diferenciaPeso);
						
						if (diferenciaPeso >0) {
						System.out.println(nombreFichero + " ha engordado " + diferenciaPeso);	
						}
						
						System.out.println(nombreFichero + " se mantiene en su peso anterior");
						}
				}
				file.close();
			
		} catch (IOException e) {
		e.printStackTrace();
		} 
	}
}

