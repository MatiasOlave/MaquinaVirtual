
public class Memoria {
	int Registros[]= new int[24576];
	int dregister;
	int aregister;
	public Memoria(){	
	}
	
	public void Print(int a) {
		if(a!=-1) {
			System.out.print("Estado Registros ciclo["+a+"]\n");
		}else {
			System.out.print("Estado Registros Final\n");
		}
		for(int i=0;i<Registros.length;i++) {
			if(Registros[i]!=0){
				System.out.print("Registro ["+i+"] = " +Registros[i]+" \n");
			}
		}
		
		System.out.println("Registro A es: "+getaregister());
		System.out.println("Registro D es: "+getdregister());
	}
	
	public void Guardar(int dato,int registro) {
		Registros[registro]=dato;
		System.out.println("Se guarda en el registro "+registro+" el valor de "+Registros[registro]);
	}
	
	public int Buscar(int registro) {
		return Registros[registro];
	}
	
	public void setdregister(int dato){
		dregister=dato;
	}
	public int getdregister(){
		return dregister;
	}
	
	public void setdaegister(int dato){
		aregister=dato;
	}
	public int getaregister(){
		return aregister;
	}
}
