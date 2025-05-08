package mx.profuturo.nci.ws.service.principal;

import mx.profuturo.nci.ws.beans.request.PrincipalConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.response.PrincipalConsultarBeanResponse;

public interface IPrincipalSoapService {
	public PrincipalConsultarBeanResponse consultar(PrincipalConsultarBeanRequest principalConsultarBeanRequest);	
}