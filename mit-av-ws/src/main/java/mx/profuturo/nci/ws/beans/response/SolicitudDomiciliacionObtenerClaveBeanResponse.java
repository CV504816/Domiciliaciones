package mx.profuturo.nci.ws.beans.response;

import mx.profuturo.nci.ws.beans.ClaveSolicitudDomiciliacionBean;

public class SolicitudDomiciliacionObtenerClaveBeanResponse {
	
	public SolicitudDomiciliacionObtenerClaveBeanResponse(){}
	
	public SolicitudDomiciliacionObtenerClaveBeanResponse(ClaveSolicitudDomiciliacionBean claveSolicitudDomiciliacionBean) {
		super();
		this.claveSolicitudDomiciliacionBean=claveSolicitudDomiciliacionBean;
	}

	private ClaveSolicitudDomiciliacionBean claveSolicitudDomiciliacionBean;


	public ClaveSolicitudDomiciliacionBean getclaveSolicitudDomiciliacion() {
		return claveSolicitudDomiciliacionBean;
	}

	public void setclaveSolicitudDomiciliacion(ClaveSolicitudDomiciliacionBean claveSolicitudDomiciliacionBean) {
		this.claveSolicitudDomiciliacionBean = claveSolicitudDomiciliacionBean;
	}
}
