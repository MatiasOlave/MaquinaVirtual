import java.io.FileNotFoundException;
import java.util.Arrays;

public class main {
	public static void main(String args[]) throws FileNotFoundException{
		Rom32k rom= new Rom32k();
		CPU cpu= new CPU();
		int[] linea=new int[16];
		
		
		

		int valor=0;
		int cantidad=rom.cantidaddeciclos();
		rom.inicio(cantidad);
		//memory.Print();

		
		long tictoc = 9223372036854775807L;//jiji profe
		int a=0;
		int[] resul; 
		cpu.Print1();
		while(tictoc!=0) {
			//System.out.println("tiktok "+tictoc);
			System.out.println("*************linea actual*************** "+a);
			linea =rom.linea(a);
			resul=cpu.leer(linea, valor);
			valor=resul[0];
			//System.out.println("resultado "+resul[1]);
			//System.out.println("a anterior "+a);
			a=cpu.re(resul[1],a);
			tictoc--;
			//System.out.println("el valor de a es:  "+a);
			if(a==-2) {
				tictoc=0;
			}
			cpu.Print1();
		}
		
		cpu.Print1();
		
	}
	


}
/*//FileChooser openFile = new FileChooser();
//openFile.setTitle("Open File");
File file = openFile.showOpenDialog(primaryStage);
if (file != null) {
    try {
        Scanner archivo= new Scanner(file);
        while(archivo.hasNextLine()) {
            datos=archivo.nextLine();
            Scanner leer= new Scanner(datos);
            //System.out.println(datos);
            if (leer.hasNextInt()) {
                Idcargar=leer.nextInt();
            }
            if (leer.hasNext()) {
                Simbolocargar=leer.next();
            }*/