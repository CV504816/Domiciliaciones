package mx.profuturo.nci.alux.persistence;

import mx.profuturo.nci.business.vo.ValidaAluxVO;
import mx.profuturo.nci.stereotype.Mapper;

@Mapper
public interface AluxOssPersistence {

	public ValidaAluxVO validaAlux(String numeroCuenta);
	
	
}
