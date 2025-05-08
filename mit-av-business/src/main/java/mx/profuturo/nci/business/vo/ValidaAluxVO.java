package mx.profuturo.nci.business.vo;

public class ValidaAluxVO {

	private String esvalidoAlux;
	private String mensaje;
	
	
	public ValidaAluxVO() {
		super();
	}


	public ValidaAluxVO(String esvalidoAlux, String mensaje) {
		super();
		this.esvalidoAlux = esvalidoAlux;
		this.mensaje = mensaje;
	}


	public String getEsvalidoAlux() {
		return esvalidoAlux;
	}


	public void setEsvalidoAlux(String esvalidoAlux) {
		this.esvalidoAlux = esvalidoAlux;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	@Override
	public String toString() {
		return "ValidaAluxVO [esvalidoAlux=" + esvalidoAlux + ", mensaje=" + mensaje + "]";
	}
	
	
	
}
