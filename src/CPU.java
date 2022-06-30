import java.util.Arrays;

public class CPU {
	Memoria memory= new Memoria();
	public CPU() {
	}
	
	public int leer(int[] dato,int valor){
		//registros
		if(dato[0]==0) {
			int value= traductorbinario(dato);
			System.out.print("Cargar registo n° "+value);
			//System.out.print("return "+memory.Buscar(value));
			return value;
			
		}
		if(dato[0]==1) {
			System.out.print("PASA2\n");
			ALU(dato,valor);
			return -1;
		}
		return -2;
	}
	
	public void ALU(int[] dato,int valorregistro) {
		if(dato[4]==0) {
			System.out.println("RESULTADO comp== "+traductorA0(dato,memory.getdregister(),memory.getaregister()));
			int resultado= traductorA0(dato,memory.getdregister(),memory.getaregister());
			System.out.println("RESULTADO destino == "+traductorD(dato));
			//memory.Buscar(resultado);
			System.out.println("RESULTADO SALTO == "+traductorJUMP(dato));
		}
		if(dato[4]==1) {
			System.out.println("RESULTADO== "+traductorA1(dato,1,2, 0));
			int resultado= traductorA1(dato,1,2,0);
			System.out.println("RESULTADO destino == "+traductorD(dato));
			if(traductorD(dato)=="D") {
				memory.setdregister(resultado);
			}else if(traductorD(dato)=="A") {
				memory.setdaegister(resultado);
			}else {
				memory.Guardar(resultado,valorregistro);
			}
			System.out.println("RESULTADO SALTO == "+traductorJUMP(dato));
	
		}
	}
	
	public int traductorA0(int[] dato,int D, int A) {
		//tranformar de binario a decimal Y GUARDARLO EN DECIMAL***
		int decimal=0;
		int[] comp= new int[6];
		for(int i=4;i<10;i++) {
			comp[i-4]=dato[i];
		}
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
	    //System.out.println("el valor es: "+decimal);
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
			int NOTD=-5;
			return NOTD;
		}
		if(decimal==49) {
			//CREAR NOTA =!A
			int NOTA=-4;
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
			int resultado=-2;
			return resultado; 
		}
		if(decimal==41) {
			//hacer D|A
			int resultado=-3;
			return resultado; 
		}
		return -1;
	}
	
	public int traductorA1(int[] dato,int D, int A,int M) {
		int decimal=0;
		int[] comp= new int[6];
		for(int i=4;i<10;i++) {
			comp[i-4]=dato[i];
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
	
	public String traductorD(int[] dato){
		int decimal=0;
		int[] comp= new int[3];
		for(int i=10;i<13;i++) {
			comp[i-10]=dato[i];
		}
		//System.out.println(Arrays.toString(comp));
		int[] comp2= new int[3];
		for(int i=0;i<3;i++) {
			comp2[i]=comp[2-i];
		}
	    int power = 0;
		 for(int i = 0 ; i < comp2.length ; i++){
	            int tmp = comp2[i]%10;
	            decimal += tmp*Math.pow(2, power);
	            power++;
	    }
	    System.out.println("el valor es: "+decimal);
	    if(decimal==0) {
	    	return "NULL";
	    }
	    if(decimal==1) {
	    	return "M";
	    }
	    if(decimal==2) {
	    	return "D";
	    }
	    if(decimal==3) {
	    	return "M&D";
	    }
	    if(decimal==4) {
	    	return "A";
	    }
	    if(decimal==5) {
	    	return "A&M";
	    }
	    if(decimal==6) {
	    	return "A&D";
	    }
	    if(decimal==7) {
	    	return "A&M&D";
	    }
	    
	    return "error";
	}
	
	public String traductorJUMP(int[] dato){
		int decimal=0;
		int[] comp= new int[3];
		for(int i=13;i<16;i++) {
			comp[i-13]=dato[i];
		}
		System.out.println(Arrays.toString(comp));
		int[] comp2= new int[3];
		for(int i=0;i<3;i++) {
			comp2[i]=comp[2-i];
		}
	    int power = 0;
		 for(int i = 0 ; i < comp2.length ; i++){
	            int tmp = comp2[i]%10;
	            decimal += tmp*Math.pow(2, power);
	            power++;
	    }
	    System.out.println("el valor es: "+decimal);
	    if(decimal==0) {
	    	return "NULL";
	    }
	    if(decimal==1) {
	    	return "JGT";
	    }
	    if(decimal==2) {
	    	return "JEQ";
	    }
	    if(decimal==3) {
	    	return "JGE";
	    }
	    if(decimal==4) {
	    	return "JLT";
	    }
	    if(decimal==5) {
	    	return "JNE";
	    }
	    if(decimal==6) {
	    	return "JLE";
	    }
	    if(decimal==7) {
	    	return "JUMP";
	    }
	    
	    return "error";
	}
	public int traductorbinario(int[] dato){
		int decimal=0;
		int[] comp= new int[15];
		for(int i=1;i<16;i++) {
			comp[i-1]=dato[i];
		}
		System.out.println("array value"+Arrays.toString(comp));
		int[] comp2= new int[15];
		for(int i=0;i<15;i++) {
			comp2[i]=comp[14-i];
		}
	    int power = 0;
		 for(int i = 0 ; i < comp2.length ; i++){
	            int tmp = comp2[i]%10;
	            decimal += tmp*Math.pow(2, power);
	            power++;
	    }
	    System.out.println("el valor es: "+decimal);
	    return decimal;
	}
	
}
