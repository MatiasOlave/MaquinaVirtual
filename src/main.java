import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.util.Arrays;
public class main {
	public static void main(String args[]) throws Exception{
		File doc = new File ("C://Users//matia//eclipse-workspace//U4ACDC//MaquinaVirtual//Mult.hack");
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