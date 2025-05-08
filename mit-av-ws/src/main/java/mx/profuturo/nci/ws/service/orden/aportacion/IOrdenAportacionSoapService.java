package mx.profuturo.nci.ws.service.orden.aportacion;

import mx.profuturo.nci.ws.beans.request.OrdenAportacionActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.request.OrdenAportacionConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.request.OrdenAportacionInsertarBeanRequest;
import mx.profuturo.nci.ws.beans.response.OrdenAportacionConsultarBeanResponse;

public interface IOrdenAportacionSoapService 
{
	
	public OrdenAportacionConsultarBeanResponse consultar(OrdenAportacionConsultarBeanRequest request);

	public String insertar(OrdenAportacionInsertarBeanRequest request);
	 
	public Boolean actualizar(OrdenAportacionActualizarBeanRequest request);
}
