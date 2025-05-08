package mx.profuturo.nci.ws.service.impl.validaVersionComponente;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import mx.profuturo.nci.ws.beans.response.ValidaVersionComponenteResponse;
import mx.profuturo.nci.ws.exceptions.FaultBeanServiceInfo;
import mx.profuturo.nci.ws.exceptions.MitWebServiceException;
import mx.profuturo.nci.ws.service.validaVersionComponente.IValidaVersionComponenteSoapService;

@Service("validaVersionComponenteSoapService")
public class ValidaVersionComponenteSoapServiceImpl implements IValidaVersionComponenteSoapService{
private static final Logger LOGGER = LoggerFactory.getLogger(ValidaVersionComponenteSoapServiceImpl.class);

	
	@Override
	public ValidaVersionComponenteResponse consultaVersion() {

		try {
				return new ValidaVersionComponenteResponse("000","Autor: ","Version 07/02/2024 - ");
			
		} catch (Exception e) {
			LOGGER.error("ERROR UBICACION     :" + ValidaVersionComponenteSoapServiceImpl.class.getCanonicalName());
			LOGGER.error("ERROR METODO        :" + "consultaVersion");
			LOGGER.error("ERROR MENSAJE       :" + e.getMessage());
			LOGGER.error("ERROR DESCRIPCION   :", e);
			FaultBeanServiceInfo missing = new FaultBeanServiceInfo();
			missing.setFaultstring("000");
			throw new MitWebServiceException(e.getMessage(), missing);
		}finally {
			
		}
	}

}
