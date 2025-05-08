package mx.profuturo.nci.ws.beans.request;

public class SolicitudDomiciliacionObtenerClaveBeanRequest {
	private String claveSolicitudAux;
	private String curp;
	
	public String getClaveSolicitudAux() {
		return claveSolicitudAux;
	}

	public void setClaveSolicitudAux(String claveSolicitudAux) {
		this.claveSolicitudAux = claveSolicitudAux;
	}
	
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
}
