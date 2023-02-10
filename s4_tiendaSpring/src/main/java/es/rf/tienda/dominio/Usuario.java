package es.rf.tienda.dominio;
import java.time.LocalDate;
import java.util.Objects;

import es.rf.tienda.constants.Constants;
import es.rf.tienda.constants.ErrorConstans;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

public class Usuario {
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int id_tipo;
	private String user_dni;
	private LocalDate user_fecAlta = LocalDate.now();
	private LocalDate user_fecConfirmacion = LocalDate.now();

	public Direccion getUser_pago() {
		return user_pago;
	}

	public void setUser_pago(Direccion user_pago) {

		this.user_pago = user_pago;
	}

	public Direccion getUser_envio() {
		return user_envio;
	}

	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}

	private Direccion user_pago = new Direccion();
	private Direccion user_envio = new Direccion();

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, Constants.LONG_MIN_1, Constants.LONG_MAX_200)) {
			this.user_nombre = user_nombre;
		} else {
			throw new DomainException(ErrorConstans.ERR_LONGITUD_NOMBRE_CATEGORIA);
		}

	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email) && Validator.cumpleLongitudMax(user_email, Constants.LONG_MAX_200)) {

			this.user_email = user_email;
		} else {
			throw new DomainException(ErrorConstans.ERR_EMAIL);
		}

	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.esPasswordValida(user_pass) && Validator.cumpleLongitudMin(user_pass, Constants.LONG_MIN_8)) {

			this.user_pass = user_pass;
		} else {
			throw new DomainException(ErrorConstans.ERR_PASSWORD);
		}

	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) throws DomainException {
		this.id_tipo = id_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni)) {

			this.user_dni = user_dni;
		} else {
			throw new DomainException(ErrorConstans.ERR_DNI);
		}

	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", user_nombre=" + user_nombre + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", id_tipo=" + id_tipo + ", user_dni=" + user_dni + ", user_fecAlta="
				+ user_fecAlta + ", user_fecConfirmacion=" + user_fecConfirmacion + ", user_pago=" + user_pago
				+ ", user_envio=" + user_envio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_tipo, id_usuario, user_dni, user_email, user_envio, user_fecAlta, user_fecConfirmacion,
				user_nombre, user_pago, user_pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id_tipo == other.id_tipo && id_usuario == other.id_usuario && Objects.equals(user_dni, other.user_dni)
				&& Objects.equals(user_email, other.user_email) && Objects.equals(user_envio, other.user_envio)
				&& Objects.equals(user_fecAlta, other.user_fecAlta)
				&& Objects.equals(user_fecConfirmacion, other.user_fecConfirmacion)
				&& Objects.equals(user_nombre, other.user_nombre) && Objects.equals(user_pago, other.user_pago)
				&& Objects.equals(user_pass, other.user_pass);
	}

}
