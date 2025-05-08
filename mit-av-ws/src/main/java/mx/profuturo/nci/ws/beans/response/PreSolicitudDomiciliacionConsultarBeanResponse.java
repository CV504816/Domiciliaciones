package mx.profuturo.nci.ws.beans.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import mx.profuturo.nci.ws.beans.PreSolicitudDomiciliacionBean;


public class PreSolicitudDomiciliacionConsultarBeanResponse 
{
	String mensaje;
	String codigo;
	public PreSolicitudDomiciliacionConsultarBeanResponse(){}
	
	public PreSolicitudDomiciliacionConsultarBeanResponse(List<PreSolicitudDomiciliacionBean> listaPreSolicitudDomiciliacion)
	{
		super();
		this.listaPreSolicitudDomiciliacion = listaPreSolicitudDomiciliacion;
	}
	
	private List<PreSolicitudDomiciliacionBean> listaPreSolicitudDomiciliacion;
	
	
	@XmlElementWrapper(name = "presolicitudesDomiciliacion")
	@XmlElement(name = "preSolicitud")
	public List<PreSolicitudDomiciliacionBean> getListaPreSolicitudDomiciliacion() {
		return listaPreSolicitudDomiciliacion;
	}

	public void setListaPreSolicitudDomiciliacion(List<PreSolicitudDomiciliacionBean> listaPreSolicitudDomiciliacion) {
		this.listaPreSolicitudDomiciliacion = listaPreSolicitudDomiciliacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PreSolicitudDomiciliacionConsultarBeanResponse(String mensaje, String codigo) {
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
}
