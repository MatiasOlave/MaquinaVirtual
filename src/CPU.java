import java.util.Arrays;

public class CPU {
	Memoria memory;
	
	
	public CPU() {
		memory=new Memoria();
		memory.Guardar(2, 0);
		memory.Guardar(3, 1);
		memory.Guardar(5, 2);
	}
	
	public int[] leer(int[] dato,int valor,int a){
		System.out.println("Actual ROM["+a+"] = "+Arrays.toString(dato));
		int[] resultado= new int[2];
		resultado[1]=-1;
		if(dato[0]==0) {
			int value= traductorbinario(dato);
			System.out.println("@R"+value+" // cargar registro");
			resultado[0]=value;
			return resultado;
			
		}
		if(dato[0]==1) {
			int salto;
			System.out.print("Instruccion es ");
			salto=ALU(dato,valor);
			resultado[1]=salto;
			return resultado;
		}
		return resultado;
	}
	
	public int ALU(int[] dato,int valorregistro) {
		if(dato[3]==0) {
			int resultado= traductorA0(dato,memory.getdregister(),memory.getaregister());
			System.out.println("Destino = "+traductorD(dato));
			if(traductorD(dato)=="D") {
				memory.setdregister(resultado);
			}else if(traductorD(dato)=="A") {
				memory.setdaegister(resultado);
			}else if(traductorD(dato)=="NULL") {
			
			}
			else {
				memory.Guardar(resultado,valorregistro);
			}
			System.out.println("JUMP == "+traductorJUMP(dato));
		    String jump = traductorJUMP(dato);
		    if(jump=="NULL") {
		    	return -1;
		    }
		    if(jump=="JEQ") {
		    	if(memory.getdregister()<0) {
		    		return valorregistro;
		    	}else {
		    		return -1;
		    	}
		    }
		    if(jump=="JUMP") {
		    	int a =valorregistro-1;
		    	//System.out.println("ES UNO O NOOO??? VALOR REGISTRO= "+a); eliminar***********************
		    	//System.out.println("ES UNO O NOOO???= "+memory.Buscar(a));
		    	//System.out.println("ES REGISTRO REAL"+valorregistro);
		    	if(memory.Buscar(a)>0) {
		    		return valorregistro;
		    	}else {
		    		return -2;
		    	}
		    	
		    }
		    
		    return 4041;	
			
		}
		if(dato[3]==1) {
			int resultado= traductorA1(dato,memory.getdregister(),memory.getaregister(),memory.Buscar(valorregistro));;
			System.out.println("Destino = "+traductorD(dato));
			if(traductorD(dato)=="D") {
				memory.setdregister(resultado);
			}else if(traductorD(dato)=="A") {
				memory.setdaegister(resultado);
			}else if(traductorD(dato)=="NULL") {
			
			}
			else {
				memory.Guardar(resultado,valorregistro);
			}
			System.out.println("JUMP == "+traductorJUMP(dato));
		    String jump = traductorJUMP(dato);
		    if(jump=="NULL") {
		    	return -1;
		    }
		    if(jump=="JEQ") {
		    	if(memory.getdregister()<0) {
		    		return valorregistro;
		    	}else {
		    		return -1;
		    	}
		    }
		    if(jump=="JUMP") {
		    	int a =valorregistro-1;
		    	//System.out.println("ES UNO O NOOO??? VALOR REGISTRO= "+a); eliminar***********************
		    	//System.out.println("ES UNO O NOOO???= "+memory.Buscar(a));
		    	//System.out.println("ES REGISTRO REAL"+valorregistro);
		    	if(memory.Buscar(a)>0) {
		    		return valorregistro;
		    	}else {
		    		return -2;
		    	}
		    	
		    }
		    
		    return 4042;
		}
		
		return 4043;
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
	    //System.out.println("el valor es ver*: "+decimal);
		if(decimal==42) {
			System.out.println("0");
			return 0;	
		}
		if(decimal==63) {
			System.out.println("1");
			return 1;
		}
		if(decimal==58) {
			System.out.println("-1");
			return -1;
		}
		if(decimal==12) {
			System.out.println("D");
			return D;
		}
		if(decimal==48) {
			System.out.println("A");
			return A;
		}
		if(decimal==13) {
			System.out.println("!D");
			//CREAR NOTD =!D
			int NOTD=-5;
			return NOTD;
		}
		if(decimal==49) {
			System.out.println("!A");
			//CREAR NOTA =!A
			int NOTA=-4;
			return NOTA;	
		}
		if(decimal==15) {
			System.out.println("-D");
			return -1*D;	
		}
		if(decimal==51) {
			System.out.println("-A");
			return -1*A;
		}
		if(decimal==30) {
			System.out.println("D+1");
			return D+1;
		}
		if(decimal==55) {
			System.out.println("A+1");
			return A+1;
		}
		if(decimal==14) {
			System.out.println("D-1");
			return D-1;
		}
		if(decimal==50) {
			System.out.println("A-1");
			return A-1;
		}
		if(decimal==2) {
			System.out.println("D+A");
			return D+A;
		}
		if(decimal==19) {
			System.out.println("A-D");
			return A-D;
		}
		if(decimal==0) {
			//hacer D&A
			System.out.println("D&A");
			int resultado=-2;
			return resultado; 
		}
		if(decimal==41) {
			System.out.println("D|A");
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
		//System.out.println(Arrays.toString(comp));
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
		if(decimal==48) {
			System.out.println("M");
			return M;
		}
		if(decimal==49) {
			System.out.println("!M");
			//CREAR NOT M
			int notM=0;
			return notM;
		}
		if(decimal==51) {
			System.out.println("-M");
			return -1*M;
		}
		if(decimal==55) {
			System.out.println("M+1");
			return M+1;
		}
		if(decimal==50) {
			System.out.println("M-1");
			return M-1;
		}
		if(decimal==2) {
			System.out.println("D+M");
			return D+M;
		}
		if(decimal==19) {
			System.out.println("D-M");
			return D-M;
		}
		if(decimal==7) {
			System.out.println("M-D");
			return M-D;
		}
		if(decimal==0) {
			System.out.println("D&M");
			//hacer D&M
			int resultado=0;
			return resultado; 
		}
		if(decimal==41) {
			System.out.println("D|M");
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
	    //System.out.println("el valor es: "+decimal);
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
	    //System.out.println("el valor es: "+decimal);
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
		//System.out.println("Array linea: "+Arrays.toString(comp));
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
	    //System.out.println("El valor es: "+decimal);
	    return decimal;
	}
	
	
	public int sigLinea(int arry, int a) {
		int resul=1234;
		if(arry!=-1) {
			resul=arry;
			//System.out.println("el valor de resul funcion:  "+resul);
			return resul;
		}else if(arry==-2) {
			return -2;
		}
		else{
			resul=a+1;
			//System.out.println("el valor de a funcion:  "+resul);
			return resul;
		}
	}
	
	public void Print1(int a) {
		memory.Print(a);
	}
	
}
