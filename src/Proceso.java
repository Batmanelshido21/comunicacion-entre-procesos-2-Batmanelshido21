import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author javier
 *
 */
public class Proceso {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		File file = new File("\\home\\javier\\eclipse-workspace\\comunicación entre procesos 2");
		int opcion = 0;

		while (opcion != 3) {
			System.out.println("Ingresa la operación que desea realizar \n 1.-Generar archivo"
					+ "\n2.- leer archivo \n 3.-Terminar proceso");
			opcion = lector.nextInt();

			switch (opcion) {
			case 1:
				BufferedWriter bw = null;
				FileWriter fw = null;
				String id = ManagementFactory.getRuntimeMXBean().getName();
				String[] ids = id.split("@");
				String data = ids[0];
				// Si el archivo no existe, se crea!
				if (!file.exists()) {
					file.createNewFile();
					fw = new FileWriter(file.getAbsoluteFile());
					bw = new BufferedWriter(fw);
					bw.write("El PID del proceso es " + ids[0]);
					System.out.println("El PID del proceso es " + ids[0]);
					bw.newLine();
				}
				// flag true, indica adjuntar información al archivo.
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				bw.write("El PID del proceso es " + data);
				System.out.println("El PID del proceso es " + ids[0]);
				bw.newLine();
				bw.close();
				fw.close();
				break;
			case 2:
				String cadena;
				FileReader f = new FileReader(file);
				BufferedReader b = new BufferedReader(f);
				while ((cadena = b.readLine()) != null) {
					System.out.println(cadena);
				}
				break;
			case 3:

				break;
			default:
				System.out.println("El número es erroneo");
				break;

			}
		}

	}
}
