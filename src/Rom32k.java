import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Rom32k {
	String[] rom= new String[32767];
	
	public Rom32k(){
		
	}
	
	public void inicio(int contador, String locacion) throws FileNotFoundException, IOException {
		//File doc = new File (locacion);
		//System.out.println(doc.exists());
		//System.out.println(new File(".").getAbsolutePath());
		int aux=0;
        String lista;
        FileReader archivo = new FileReader(locacion);
        BufferedReader leer = new BufferedReader(archivo);
        while ((lista = leer.readLine())!=null){
        	if(lista!="null") {
				rom[aux]=lista;
			}else {
				if(contador!=aux) {
					rom[aux]="0000000000000000";
				}
			}
			//System.out.println("ROMar=  "+rom[aux]);
			aux++;
            
        }
		//mostarRom(); muestra rom
	}
	
	public int cantidaddeciclos(String locacion) throws FileNotFoundException, IOException{
		FileReader archivo = new FileReader(locacion);
        BufferedReader leer = new BufferedReader(archivo);
		int contador=0;
		String lista;
		while ((lista = leer.readLine())!=null){
			contador++;
        }
		return contador;
	}
	
	public int[] linea(int lineaAc){
		String a1= rom[lineaAc];
		int[] numbers = new int[a1.length()];
		for (int i = 0; i < a1.length(); i++) {
		    numbers[i] = a1.charAt(i) - '0';
		}
		//System.out.println("que es numbers:  "+Arrays.toString(numbers));
		return numbers;
	}
	
	public void mostarRom(){
		for(int i=0;i<rom.length;i++) {
			if(rom[i]!=null){
				System.out.print("ROM ["+i+"] = " +rom[i]+" \n");
			}
		}
	}

}
