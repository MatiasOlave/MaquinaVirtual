import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.util.Arrays;
public class main {
	public static void main(String args[]) throws Exception{
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
		System.out.println(Arrays.toString(Datos));
		System.out.println(Datos.length-1);
		int wh=0;
		//System.out.println(Datos[0]);
		
		String a1= Datos[0];
		int[] numbers = new int[a1.length()];
		for (int i = 0; i < a1.length(); i++) {
		    numbers[i] = a1.charAt(i) - '0';
		}
		System.out.println(Arrays.toString(numbers));
		leer(numbers);
		
	}
	

	public static void leer(int[] dato){
		//registros
		if(dato[0]==0) {
			System.out.print("PASA1\n");
			ALU(dato);	
		}
		if(dato[0]==1) {
			System.out.print("PASA2\n");
			ALU(dato);		
		}
	}
	
	public static void ALU(int[] dato) {
		if(dato[4]==0) {
			System.out.print("RESULTADO== "+traductorA0(dato,1,2));
		}
		if(dato[4]==1) {
			System.out.print("RESULTADO== "+traductorA1(dato,1,2, 0));
		}
	}
	
	public static int traductorA0(int[] dato,int D, int A) {
		//tranformar de binario a decimal Y GUARDARLO EN DECIMAL***
		int decimal=0;
		int[] comp= new int[6];
		for(int i=5;i<11;i++) {
			comp[i-5]=dato[i];
		}
		System.out.println(Arrays.toString(comp));
		int[] comp2= new int[6];
		for(int i=0;i<6;i++) {
			comp2[i]=comp[5-i];
		}
	    int power = 0;
		 for(int i = 0 ; i < comp2.length ; i++){
	            int tmp = comp2[i]%10;
	            decimal += tmp*Math.pow(2, power);
	            power++;
	    }
	    System.out.println("el valor es: "+decimal);
		if(decimal==42) {
			return 0;	
		}
		if(decimal==63) {
			return 1;
		}
		if(decimal==58) {
			return -1;
		}
		if(decimal==12) {
			return D;
		}
		if(decimal==48) {
			return A;
		}
		if(decimal==13) {
			//CREAR NOTD =!D
			int NOTD=0;
			return NOTD;
		}
		if(decimal==49) {
			//CREAR NOTA =!A
			int NOTA=0;
			return NOTA;	
		}
		if(decimal==15) {
			return -1*D;	
			
		}
		if(decimal==51) {
			return -1*A;
		}
		if(decimal==30) {
			return D+1;
		}
		if(decimal==55) {
			return A+1;
		}
		if(decimal==14) {
			return D-1;
		}
		if(decimal==50) {
			return A-1;
		}
		if(decimal==2) {
			System.out.println("VALOR A: "+A);
			System.out.println("VALOR D: "+D);
			return D+A;
		}
		if(decimal==19) {
			return A-D;
		}
		if(decimal==0) {
			//hacer D&A
			int resultado=0;
			return resultado; 
		}
		if(decimal==41) {
			//hacer D|A
			int resultado=0;
			return resultado; 
		}
		return 0;
	}
	
	public static int traductorA1(int[] dato,int D, int A,int M) {
		//tranformar de binario a decimal Y GUARDARLO EN DECIMAL***
		int decimal=0;
		if(decimal==48) {
			return M;
		}
		if(decimal==49) {
			//CREAR NOT M
			int notM=0;
			return notM;
		}
		if(decimal==51) {
			return -1*M;
		}
		if(decimal==55) {
			return M+1;
		}
		if(decimal==50) {
			return M-1;
		}
		if(decimal==2) {
			return D+M;
		}
		if(decimal==19) {
			return D-M;
		}
		if(decimal==7) {
			return M-D;
		}
		if(decimal==0) {
			//hacer D&M
			int resultado=0;
			return resultado; 
		}
		if(decimal==41) {
			//hacer D|M
			int resultado=0;
			return resultado; 
		}
		return 0;
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