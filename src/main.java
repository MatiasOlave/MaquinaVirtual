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
		int Sig=0;
		int cont=1;
		int[] resul; 
		cpu.Print1(Sig);
		while(tictoc!=0) {
			//System.out.println("tiktok "+tictoc);
			System.out.println("*************linea actual*************** ");
			System.out.println("Numero del ciclo: "+cont);
			linea =rom.linea(Sig);
			resul=cpu.leer(linea, valor,Sig);
			valor=resul[0];
			//System.out.println("resultado "+resul[1]);
			//System.out.println("a anterior "+a);
			Sig=cpu.sigLinea(resul[1],Sig);
			tictoc--;
			
			//System.out.println("el valor de a es:  "+a);
			if(Sig==-2) {
				tictoc=0;
			}
			System.out.println("************************************ ");
			cpu.Print1(cont);
			cont++;
		}
		
		cpu.Print1(-1);
		
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