package mx.profuturo.nci.ws.service.depositos;

import mx.profuturo.nci.ws.beans.request.DepositosIDCConsultaBeanRequest;
import mx.profuturo.nci.ws.beans.response.DepositosIDCConsultaBeanResponse;

import mx.profuturo.nci.ws.beans.request.ValidarCuentaBeanRequest;
import mx.profuturo.nci.ws.beans.response.ValidarCuentaBeanResponse;

public interface IDepositosIDCSoapService {
	
	/*Metos disponibles en el servicio*/
	public DepositosIDCConsultaBeanResponse consultarDepositos (DepositosIDCConsultaBeanRequest request);
	
	public ValidarCuentaBeanResponse validarCuenta (ValidarCuentaBeanRequest request);
	
	
}
