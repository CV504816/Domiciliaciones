package mx.profuturo.nci.ws.service.cifrasgenerales;

import mx.profuturo.nci.ws.beans.request.CifrasGeneralesPorBancoBeanRequest;
import mx.profuturo.nci.ws.beans.request.CifrasGeneralesPorOrigenBeanRequest;
import mx.profuturo.nci.ws.beans.request.CifrasGeneralesPorSBCBeanRequest;
import mx.profuturo.nci.ws.beans.request.CifrasGeneralesPorTipoBeanRequest;
import mx.profuturo.nci.ws.beans.response.CifrasGeneralesPorBancoBeanResponse;
import mx.profuturo.nci.ws.beans.response.CifrasGeneralesPorOrigenBeanResponse;
import mx.profuturo.nci.ws.beans.response.CifrasGeneralesPorSBCBeanResponse;
import mx.profuturo.nci.ws.beans.response.CifrasGeneralesPorTipoBeanResponse;

public interface ICifrasGeneralesSoapService {
	public CifrasGeneralesPorOrigenBeanResponse consultarPorOrigen(
			CifrasGeneralesPorOrigenBeanRequest cifrasGeneralesPorOrigenBeanRequest);

	public CifrasGeneralesPorTipoBeanResponse consultaPorTipo(
			CifrasGeneralesPorTipoBeanRequest cifrasGeneralesPorTipoBeanRequest);

	public CifrasGeneralesPorBancoBeanResponse consultaPorBanco(
			CifrasGeneralesPorBancoBeanRequest cifrasGeneralesPorBancoBeanRequest);

	public CifrasGeneralesPorSBCBeanResponse consultaPorSaldoBuenCobro(
			CifrasGeneralesPorSBCBeanRequest cifrasGeneralesPorSBCBeanRequest);

	public CifrasGeneralesPorTipoBeanResponse consultaPorTipoReporte(
			CifrasGeneralesPorTipoBeanRequest cifrasGeneralesPorTipoBeanRequest);
}
