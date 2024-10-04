package Ejercicio4;
	import java.io.*;

public class CargaDatos {

	public static void main(String[] args) throws IOException { 	
		
		//Creamos el fichero de acceso aleatorio.
		File fichero = new File("."+ File.separator + "src" + File.separator + "Ejercicio4" + File.separator + "Marvel.dat");  
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		if(fichero.exists()){
			fichero.delete();
		}
	    //Declaramos los arrays con los datos
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
	   
		//Declaro los buffers que necesitaré
		StringBuffer bufferDnis = null;
		StringBuffer bufferNoms = null;
		StringBuffer bufferIdentidades = null;
		StringBuffer bufferTipos = null;
		int n=ids.length; //Será el numero de elementos del array
	   	int posicion = 0;	    

	   	//Con un bucle iremos escribiendo los registros.
		for (int i=0;i<n; i++){
			file.writeInt(i+1);
			file.writeInt(ids[i]);
			
			bufferDnis = new StringBuffer( dnis[i] );      //DNIS
			bufferDnis.setLength(9); 
			file.writeChars(bufferDnis.toString());
			
			bufferNoms = new StringBuffer( noms[i] );      //NOMBRES
			bufferNoms.setLength(10); 
			file.writeChars(bufferNoms.toString());
			
			bufferIdentidades = new StringBuffer( identidades[i] );      //IDENTIDADES
			bufferIdentidades.setLength(20); 
			file.writeChars(bufferIdentidades.toString());
			
			bufferTipos = new StringBuffer( tipos[i] );      //TIPOS
			bufferTipos.setLength(10); 
			file.writeChars(bufferTipos.toString());
			
			file.writeInt(pesos[i]);
			file.writeInt(alturas[i]);

	    }  
	    //Cerramos el fichero y sacamos el mensaje de carga correcta.
	    file.close();   
		System.out.println("La carga de los personajes ha terminado correctamente.");			

	   }
	}
