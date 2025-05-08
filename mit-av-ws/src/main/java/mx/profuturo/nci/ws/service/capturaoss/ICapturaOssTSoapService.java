package mx.profuturo.nci.ws.service.capturaoss;

import mx.profuturo.nci.ws.beans.request.ValidaAluxOssTBeanRequest;
import mx.profuturo.nci.ws.beans.response.ValidaAluxOssTBeanResponse;

public interface ICapturaOssTSoapService {

	public ValidaAluxOssTBeanResponse validaAlux(ValidaAluxOssTBeanRequest request);
	
}
