package meteoritoNEO;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Dato> neos = inputData();
		ejecucion(neos);

	}

	public static void ejecucion(List<Dato> list) {
		String ruta = "./bin";
		String clase = "meteoritoNEO.ejecucion";
		File file = new File(ruta);
		ProcessBuilder pb;

		try {
			for (Dato d : list) {
				pb = new ProcessBuilder("java", clase, d.getNombre(), Double.toString(d.getPosicionNeo()),
						Double.toString(d.getVelocidadNeo()));
				pb.directory(file);
				pb.start();
			}
			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Dato> inputData() {
		String path = "NEOs.txt";
		List<Dato> dt = new ArrayList<Dato>();
		try {
			File file = new File(path);

			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				char coment = line.charAt(0);

				if (coment == '#') {
					continue;
				} else {
					// 0=Nombre 1=Posicion NEO 2=Velocidad NEO
					String[] le = line.split(",");
					Dato d = new Dato();

					d.setNombre(le[0]);
					d.setPosicionNeo(Double.parseDouble(le[1]));
					d.setVelocidadNeo(Double.parseDouble(le[2]));

					dt.add(d);
				}

			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return dt;
	}

}
