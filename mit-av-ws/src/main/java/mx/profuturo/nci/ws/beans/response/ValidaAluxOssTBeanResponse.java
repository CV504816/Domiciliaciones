package mx.profuturo.nci.ws.beans.response;

public class ValidaAluxOssTBeanResponse {

	private String codRet;
	private String msgRet;
	private String desRet;
	private boolean esValidoAlux;
	private String mensaje;
	
	public ValidaAluxOssTBeanResponse() {
		super();
	}

	public ValidaAluxOssTBeanResponse(String codRet, String msgRet, String desRet) {
		super();
		this.codRet = codRet;
		this.msgRet = msgRet;
		this.desRet = desRet;
	}

	public ValidaAluxOssTBeanResponse(String codRet, String msgRet, String desRet, boolean esValidoAlux,
			String mensaje) {
		super();
		this.codRet = codRet;
		this.msgRet = msgRet;
		this.desRet = desRet;
		this.esValidoAlux = esValidoAlux;
		this.mensaje = mensaje;
	}

	public String getCodRet() {
		return codRet;
	}

	public void setCodRet(String codRet) {
		this.codRet = codRet;
	}

	public String getMsgRet() {
		return msgRet;
	}

	public void setMsgRet(String msgRet) {
		this.msgRet = msgRet;
	}

	public String getDesRet() {
		return desRet;
	}

	public void setDesRet(String desRet) {
		this.desRet = desRet;
	}

	public boolean isEsValidoAlux() {
		return esValidoAlux;
	}

	public void setEsValidoAlux(boolean esValidoAlux) {
		this.esValidoAlux = esValidoAlux;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ValidaAluxOssTBeanResponse [codRet=" + codRet + ", msgRet=" + msgRet + ", desRet=" + desRet
				+ ", esValidoAlux=" + esValidoAlux + ", mensaje=" + mensaje + "]";
	}
	
	
}
