package es.rf.tienda.exception;

public class ErrorMessage {

	private String excepcion;
	private String mensaje;
	private String path;

	public ErrorMessage(Exception e, String path) {
		this.excepcion = e.getClass().getSimpleName();
		this.mensaje = e.getMessage();
		this.path = path;
	}

	public String getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorMessage{excepcion=" + excepcion + ", mensaje=" + mensaje + ", path=" + path + "}";
	}

}
