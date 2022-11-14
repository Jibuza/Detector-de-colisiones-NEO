package meteoritoNEO;

import java.io.File;
import java.io.PrintWriter;

public class ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = args[0];
		double posicion = Double.parseDouble(args[1]);
		double velocidad = Double.parseDouble(args[2]);

		try {
			double probabilidad = calculoNEO(posicion, velocidad);

			File f = new File("../../" + name);

			PrintWriter wt = new PrintWriter(f);
			wt.print("nombre: " + name);
			wt.print("\nProbabilidad de impacto: " + probabilidad+"%");

			wt.close();
			f.createNewFile();

			if (probabilidad >= 10.0) {
				wt.print("\nPeligro, probabilidad de colision del " + probabilidad + "%	");
				System.err.println("\nPeligro, probabilidad de colision del " + probabilidad + "%	");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static double calculoNEO(double posicionNEO, double velocidadNEO) {
		double posicionTierra = 1;
		double velocidadTierra = 100;

		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}

		double resultado = 100 * Math.random()
				* Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);

		return resultado;

	}
}
