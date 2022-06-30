import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Rom32k {
	public Rom32k(){
	}
	public int[] inicio(int lineaAc ) throws FileNotFoundException {
		File doc = new File ("C://Users//Cris//Desktop//proyecto//MaquinaVirtual//Mult.hack");
		//System.out.println(doc.exists());
		Scanner archivo = new Scanner(doc);
		//System.out.println(new File(".").getAbsolutePath());
		int contador=0;
		while(archivo.hasNextLine()){
			archivo.nextLine();
			contador++;
		}
		//System.out.println(contador);
		String[] Datos = new String[contador];
		archivo.close();
		Scanner archivo1 = new Scanner(doc);
		int aux=0;
		while(archivo1.hasNextLine()){
			Datos[aux]=archivo1.nextLine();
			aux++;
			//System.out.println(archivo1.nextLine());
		}
		//System.out.println(Arrays.toString(Datos));
		//System.out.println(Datos.length-1);

		//System.out.println(Datos[0]);
		
		String a1= Datos[lineaAc];
		int[] numbers = new int[a1.length()];
		for (int i = 0; i < a1.length(); i++) {
		    numbers[i] = a1.charAt(i) - '0';
		}
		//System.out.println(Arrays.toString(numbers));
		return numbers;
	}
	
	public int cantidaddeciclos() throws FileNotFoundException{
		File doc = new File ("C://Users//Cris//Desktop//proyecto//MaquinaVirtual//Mult.hack");
		Scanner archivo = new Scanner(doc);
		int contador=0;
		while(archivo.hasNextLine()){
			archivo.nextLine();
			contador++;
		}
		archivo.close();
		return contador;
	}
}
