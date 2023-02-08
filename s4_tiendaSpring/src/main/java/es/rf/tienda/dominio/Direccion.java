package es.rf.tienda.dominio;
import java.util.Objects;

public class Direccion {
	private String dir_nombre;
	private String dir_direccion;
	private String dir_poblacion;

	private String dir_cPostal;
	private String dir_provincia;
	private String dir_pais;
	private String dir_correoE;

	public String getDir_nombre() {
		return dir_nombre;
	}

	public void setDir_nombre(String dir_nombre) {
		this.dir_nombre = dir_nombre;
	}

	public String getDir_direccion() {
		return dir_direccion;
	}

	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
	}

	public String getDir_poblacion() {
		return dir_poblacion;
	}

	public void setDir_poblacion(String dir_poblacion) {
		this.dir_poblacion = dir_poblacion;
	}

	public String getDir_cPostal() {
		return dir_cPostal;
	}

	public void setDir_cPostal(String dir_cPostal) {
		this.dir_cPostal = dir_cPostal;
	}

	public String getDir_provincia() {
		return dir_provincia;
	}

	public void setDir_provincia(String dir_provincia) {
		this.dir_provincia = dir_provincia;
	}

	public String getDir_pais() {
		return dir_pais;
	}

	public void setDir_pais(String dir_pais) {
		this.dir_pais = dir_pais;
	}

	public String getDir_correoE() {
		return dir_correoE;
	}

	public void setDir_correoE(String dir_correoE) {
		this.dir_correoE = dir_correoE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dir_cPostal, dir_correoE, dir_direccion, dir_nombre, dir_pais, dir_poblacion,
				dir_provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(dir_cPostal, other.dir_cPostal) && Objects.equals(dir_correoE, other.dir_correoE)
				&& Objects.equals(dir_direccion, other.dir_direccion) && Objects.equals(dir_nombre, other.dir_nombre)
				&& Objects.equals(dir_pais, other.dir_pais) && Objects.equals(dir_poblacion, other.dir_poblacion)
				&& Objects.equals(dir_provincia, other.dir_provincia);
	}

	@Override
	public String toString() {
		return "Direccion [dir_nombre=" + dir_nombre + ", dir_direccion=" + dir_direccion + ", dir_poblacion="
				+ dir_poblacion + ", dir_cPostal=" + dir_cPostal + ", dir_provincia=" + dir_provincia + ", dir_pais="
				+ dir_pais + ", dir_correoE=" + dir_correoE + "]";
	}

}
