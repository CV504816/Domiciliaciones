package mx.profuturo.nci.ws.beans.response;


import javax.xml.bind.annotation.XmlElement;

import mx.profuturo.nci.business.vo.SolicitudReclasificacionApoVolVO;

public class SolicitudReclasificacionConsultarBeanResponse {

	private SolicitudReclasificacionApoVolVO solicitudReclasificacionVO;

	public SolicitudReclasificacionConsultarBeanResponse() {}

	public SolicitudReclasificacionConsultarBeanResponse(SolicitudReclasificacionApoVolVO solicitudReclasificacion) {
		this.solicitudReclasificacionVO = solicitudReclasificacion;
	}
	
	@XmlElement(name="solicitudReclasificacion")
	public SolicitudReclasificacionApoVolVO getSolicitudReclasificacionVO() {
		return solicitudReclasificacionVO;
	}
	
	public void setSolicitudReclasificacionVO(SolicitudReclasificacionApoVolVO solicitudReclasificacionVO) {
		this.solicitudReclasificacionVO = solicitudReclasificacionVO;
	}
}
