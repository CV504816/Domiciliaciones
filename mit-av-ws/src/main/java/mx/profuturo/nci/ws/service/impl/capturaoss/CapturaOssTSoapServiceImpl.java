package mx.profuturo.nci.ws.service.impl.capturaoss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.exception.impl.BusinessException;

import mx.profuturo.nci.business.service.IAluxService;
import mx.profuturo.nci.business.util.Constantes;
import mx.profuturo.nci.business.util.enums.CtrlResponseWSEnum;
import mx.profuturo.nci.business.vo.ValidaAluxVO;
import mx.profuturo.nci.ws.beans.request.ValidaAluxOssTBeanRequest;
import mx.profuturo.nci.ws.beans.response.ValidaAluxOssTBeanResponse;
import mx.profuturo.nci.ws.exceptions.FaultBeanServiceInfo;
import mx.profuturo.nci.ws.exceptions.MitWebServiceException;
import mx.profuturo.nci.ws.service.capturaoss.ICapturaOssTSoapService;

@Service("capturaOssSoapService")
public class CapturaOssTSoapServiceImpl implements ICapturaOssTSoapService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CapturaOssTSoapServiceImpl.class);
	
	@Autowired
	IAluxService aluxService;
	
	
	@Override
	public ValidaAluxOssTBeanResponse validaAlux(ValidaAluxOssTBeanRequest request) {
		ValidaAluxVO valida		= null;
		
		try {
			if(request == null)
				return new ValidaAluxOssTBeanResponse(CtrlResponseWSEnum.WS_INPUT_ERROR.getCodRet(),
						  CtrlResponseWSEnum.WS_INPUT_ERROR.getMsgRet(), "El request no puede ser nulo");
			
			if(request.getNumeroCuenta() == null) 
				return new ValidaAluxOssTBeanResponse(CtrlResponseWSEnum.WS_INPUT_ERROR.getCodRet(),
						  CtrlResponseWSEnum.WS_INPUT_ERROR.getMsgRet(), "Numero de cuenta obligatorio en el request");
			
			valida = aluxService.validaAlux(request.getNumeroCuenta());
			
			if(valida == null)
				return new ValidaAluxOssTBeanResponse(CtrlResponseWSEnum.WS_NO_RECORD.getCodRet(),
						  CtrlResponseWSEnum.WS_NO_RECORD.getMsgRet(), "Sin registros", 
						  true, "No se encontro el numero de cuenta en alux");
			
			return new ValidaAluxOssTBeanResponse(CtrlResponseWSEnum.WS_OK.getCodRet(),
					  CtrlResponseWSEnum.WS_OK.getMsgRet(), "Consulta correcta", 
					  Boolean.valueOf(valida.getEsvalidoAlux()), valida.getMensaje());
			
		} catch (NullPointerException npe) {
			FaultBeanServiceInfo missing = new FaultBeanServiceInfo();
			missing.setFaultcode(Constantes.NULL_ITEM_REQ);
			missing.setFaultstring(Constantes.ERROR_AL_LEER_DATOS_DE_ENTRADA);
			LOGGER.error(npe.getMessage(), npe);
			throw new MitWebServiceException("El valor de un dato de consulta es nulo.", missing);
		} catch (BusinessException e) {
			FaultBeanServiceInfo missing = new FaultBeanServiceInfo();
			missing.setFaultstring("Ocurrio un error al realizar la inserción del servicio");
			LOGGER.error(e.getMessage(), e);
			throw new MitWebServiceException("Ocurrio un error al realizar la consulta del servicio", missing);
		} catch (Exception e) {
			FaultBeanServiceInfo missing = new FaultBeanServiceInfo();
			missing.setFaultstring("Ocurrio un error al consultar Numero de cuenta");
			LOGGER.error(e.getMessage(), e);
			throw new MitWebServiceException("Ocurrio un error al consultar Numero de cuenta", missing);
		}finally {
			
		}
	}



	
	
	
}
