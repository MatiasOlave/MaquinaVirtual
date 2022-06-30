import java.io.FileNotFoundException;
import java.util.Arrays;

public class main {
	public static void main(String args[]) throws FileNotFoundException{
		Rom32k rom= new Rom32k();
		CPU cpu= new CPU();
		int[] linea=new int[16];
		
		int contador=0;
		int valor=-1;
		while(contador+1!=rom.cantidaddeciclos()){
		linea = rom.inicio(contador);
		System.out.println("linea main "+Arrays.toString(linea));
		valor = cpu.leer(linea,valor);
		contador++;
		System.out.println("\ncACTUAL de ciclos"+contador);
		}
		System.out.println("\nFINAL de ciclos"+contador);
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