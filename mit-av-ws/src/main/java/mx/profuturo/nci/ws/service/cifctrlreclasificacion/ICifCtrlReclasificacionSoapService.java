package mx.profuturo.nci.ws.service.cifctrlreclasificacion;


import mx.profuturo.nci.business.vo.cifctrlreclasificacion.CCTotalReclasificacionVO;
import mx.profuturo.nci.ws.beans.request.CifCtrlCargoAbonoReclasifBeanRequest;
import mx.profuturo.nci.ws.beans.request.CifCtrlTotalReclasificacionBeanRequest;
import mx.profuturo.nci.ws.beans.response.CifCtrlOrigDestReclasificacionBeanResponse;
import mx.profuturo.nci.ws.beans.response.CifCtrlReclasificacionBeanResponse;

/**
 * Servicio para acceso a los datos en el esquema ETL de la tabla TTSISGRAL_ETL_CC_RECLASIFICACION
 * 
 * @author UC998101
 *
 */
public interface ICifCtrlReclasificacionSoapService {
	
	public CCTotalReclasificacionVO consultaTotalReclasificacion(CifCtrlTotalReclasificacionBeanRequest request);
	public CifCtrlOrigDestReclasificacionBeanResponse consultaOrigDestReclasificacion(CifCtrlTotalReclasificacionBeanRequest request);
	public CifCtrlReclasificacionBeanResponse consultaTotalPorSubcuentas(CifCtrlTotalReclasificacionBeanRequest request);
	public CifCtrlReclasificacionBeanResponse consultaCargAboPorSubcuentas(CifCtrlCargoAbonoReclasifBeanRequest request);

}
