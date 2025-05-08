package mx.profuturo.nci.business.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.profuturo.nci.alux.persistence.AluxOssPersistence;
import mx.profuturo.nci.business.service.IAluxService;
import mx.profuturo.nci.business.vo.ValidaAluxVO;

@Service("aluxService")
public class AluxServiceImpl implements IAluxService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AluxServiceImpl.class);

	@Autowired AluxOssPersistence alux;

	
	public ValidaAluxVO validaAlux (String numeroCuenta) throws Exception {
		try {
			return alux.validaAlux(numeroCuenta);
		} catch (Exception ex) {
			LOGGER.error( "ERROR UBICACIÓN     :" + DomiciliacionesServiceImpl.class.getCanonicalName() );
			LOGGER.error( "ERROR METODO        :" + "validaAlux" );
			LOGGER.error( "ERROR MENSAJE       :" + ex.getMessage() );
			LOGGER.error( "ERROR DESCRIPCIÓN   :" , ex );
			throw ex;
		}
	}
		
	
	
}
