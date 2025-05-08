package mx.profuturo.nci.ws.service.sumconcilia;

import mx.profuturo.nci.ws.beans.request.SumConciliaActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.request.SumConciliaConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.response.SumConciliaConsultarBeanResponse;

public interface ISumConciliaSoapService {
	public SumConciliaConsultarBeanResponse consultar(SumConciliaConsultarBeanRequest sumConciliaConsultarBeanRequest);
	public int actualizar(SumConciliaActualizarBeanRequest sumConciliaActualizarBeanRequest);
}
