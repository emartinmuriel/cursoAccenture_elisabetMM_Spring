package es.rf.tienda.dominio;

import java.io.Serializable;

import es.rf.tienda.constants.Constants;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

/**
 * 
 * Clase Categoria. Modelo Categoria
 * 
 * @author Eisabet Martin Muriel
 * @version
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(schema = "ALUMNO_EMM", name = "Categoria")
public class Categoria implements Serializable, Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "categoria_sequ")
	@TableGenerator(name = "categoria_sequ", table = "GENERATOR_TABLE", pkColumnName = "key", valueColumnName = "next", pkColumnValue = "course", allocationSize = 30)

	private int id_categoria; // identificador categoria
	@Column(nullable = false, length = 50)
	private String cat_nombre; // nombre de la categoria
	@Column(nullable = true, length = 200)
	private String cat_descripcion; // descripcion de la categoria

	public Categoria() {
	}

	/**
	 * Getter para identificador de categoria
	 * 
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter para el nombre de categoria
	 * 
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
	}

	/**
	 * Setter para el nombre de categoria. Debe tener más de cinco y menos de 50
	 * caracteres
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException {
		
		
			if (Validator.cumpleLongitud(cat_nombre, Constants.LONG_MIN_5, Constants.LONG_MAX_50)) {
				this.cat_nombre = cat_nombre;
			} else {
				throw new DomainException(ErrorMessages.CATERR_LONG_NOMBRE);
			}
	

	}

	/**
	 * Getter para la descripcion de categoria
	 * 
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}

	/**
	 * setter para la descripcion de categoria Añade solo los 200 primeros
	 * caracteres o null si la cadena es nula.
	 */
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = (cat_descripcion == null) ? null : StringUtils.truncate(cat_descripcion, 200);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}

	@Override
	public boolean isValidInsert() {
		return !Validator.isVacio(this.cat_nombre);

	}

	@Override
	public boolean isValidUpdate() {
		return !Validator.isVacio(this.cat_nombre) && this.id_categoria > 0;
	}

}
