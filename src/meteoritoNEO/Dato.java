package meteoritoNEO;

public class Dato {
	/**
	 *
	 * @author jose
	 */
	private String nombre;
	private double posicionNeo;
	private double velocidadNeo;

	public Dato(String nombre, double posicionNeo, double velodidadNeo) {
		this.nombre = nombre;
		this.posicionNeo = posicionNeo;
		this.velocidadNeo = velodidadNeo;
	}

	public Dato() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPosicionNeo() {
		return posicionNeo;
	}

	public void setPosicionNeo(double posicionNeo) {
		this.posicionNeo = posicionNeo;
	}

	public double getVelocidadNeo() {
		return velocidadNeo;
	}

	public void setVelocidadNeo(double velodidadNeo) {
		this.velocidadNeo = velodidadNeo;
	}

}
