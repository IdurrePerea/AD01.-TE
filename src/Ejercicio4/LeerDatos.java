package Ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerDatos {
	public static void main(String[] args) throws IOException {
		final int long_registro = 110; //Longitud del registro 
		try	{
			File fichero = new File("."+ File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");

			String tipoConsola, tipoFichero;
            boolean existeTipo = false;
            int contador = 0;

            System.out.println("Introduce el tipo de personaje (héroe o villano):");
            tipoConsola = Consola.readString().trim();

            // Recorremos el fichero
            for (long p = 0; p < file.length(); p += long_registro) {
                file.seek(p);
                
                // Leer el tipo (suponiendo que está en la posición correcta)
                char[] auxTipo = new char[10]; // Asumimos que el tipo ocupa 10 caracteres
                for (int i = 0; i < auxTipo.length; i++) {
                    auxTipo[i] = file.readChar();
                }
                tipoFichero = new String(auxTipo).trim();

                // Comprobar si coincide el tipo
                if (tipoFichero.equalsIgnoreCase(tipoConsola)) {
                    existeTipo = true;
                    contador++;

                    // Leer los demás datos
                    String dniFichero = readString(file, 9).trim(); // DNI
                    String nombreFichero = readString(file, 10).trim(); // Nombre
                    String identidadFichero = readString(file, 20).trim(); // Identidad secreta
                    int pesoFichero = file.readInt(); // Peso
                    int alturaFichero = file.readInt(); // Altura

