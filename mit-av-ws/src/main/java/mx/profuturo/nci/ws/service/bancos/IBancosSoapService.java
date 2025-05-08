package mx.profuturo.nci.ws.service.bancos;

import mx.profuturo.nci.ws.beans.request.MovBancoConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.request.MovBancoActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.response.MovBancoConsultarBeanResponse;

public interface IBancosSoapService {
	public MovBancoConsultarBeanResponse consultar(MovBancoConsultarBeanRequest movBancoConsultarBeanRequest);
	public int actualizar(MovBancoActualizarBeanRequest movBancoInsertarBeanRequest);
}
