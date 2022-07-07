import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Rom32k rom= new Rom32k();
		CPU cpu= new CPU();
		int[] linea=new int[16];
		
		System.out.println("**********Menu**********");
		System.out.println("Iniciar = Y Apagar: N");
		Scanner sc = new Scanner(System.in);
		char pc = sc.next().charAt(0);
		while(pc=='Y'||pc=='y') {
			System.out.println("*************Cambiar registros***************");
			System.out.println("Cambiar registros= Y Terminar = otro");
			Scanner Registros = new Scanner(System.in);
			char reg = Registros.next().charAt(0);
			if(reg=='Y'||reg=='y') {
				System.out.println("Cantidad de registros a cambiar");
				Registros = new Scanner(System.in);
				int cont = Registros.nextInt();
				for(int i=0;i<cont;i++){
					System.out.println("Numero de registro");
					Registros = new Scanner(System.in);
					int a = Registros.nextInt();
					System.out.println("Valor");
					Registros = new Scanner(System.in);
					int b = Registros.nextInt();
					cpu.ingresarRegistros(a, b);
				}
			}
			int valor=0;
			int cantidad=rom.cantidaddeciclos(args[0]);
			rom.inicio(cantidad,args[0]);
			//memory.Print();
			
			long tictoc = 9223372036854775807L;//jiji profe
			int Sig=0;
			int cont=1;
			int[] resul; 
			cpu.Print1(Sig);
		
			
			System.out.println("*************Seguir*************** ");
			System.out.println("Sigiente paso= Y Terminar = N");
			Scanner YN = new Scanner(System.in);
			char paso = YN.next().charAt(0);
			while(tictoc!=0&&((paso!='N')&&(paso!='n'))) {
			
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
					System.out.println("*************Seguir*************** ");
					System.out.println("Sigiente paso= Y Terminar = N");
					YN = new Scanner(System.in);
					paso = YN.next().charAt(0);
			}
			
			cpu.Print1(-1);
			System.out.println("**********Menu**********");
			System.out.println("Iniciar = Y Apagar: N");
			sc = new Scanner(System.in);
			pc = sc.next().charAt(0);
		}
		
	}
	


}
