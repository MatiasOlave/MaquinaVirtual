import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Rom32k {
	String[] rom= new String[32767];
	
	public Rom32k(){
	}
	
	public void inicio(int contador) throws FileNotFoundException {
		File doc = new File ("C://Users//Cris//Desktop//proyecto//MaquinaVirtual//Mult.hack");
		//System.out.println(doc.exists());
		//System.out.println(new File(".").getAbsolutePath());
		Scanner archivo = new Scanner(doc);
		int aux=0;
		while(archivo.hasNextLine()&&aux!=contador){
			String ar= archivo.nextLine();
			if(ar!="null") {
				rom[aux]=ar;
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
