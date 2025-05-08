package mx.profuturo.nci.business.report;

import java.util.List;

import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.report.beans.CargosDataReportBean;
import mx.profuturo.nci.business.report.beans.ConsultaAforeMovilDataReportBean;
import mx.profuturo.nci.business.report.beans.DiversificacionesDataReportBean;
import mx.profuturo.nci.business.report.beans.DomiliacionesDataReportBean;
import mx.profuturo.nci.business.report.beans.ValidacionesDataReportBean;
import mx.profuturo.nci.business.vo.ReporteVO;
import mx.profuturo.nci.ws.webservice.indicadores.IIndicadoresSoapWSConsultaBasicaResponse;

public interface IReportesService {
	
	public ReporteVO generaReporteDomiliacion(List<DomiliacionesDataReportBean> dataReportBean) throws MitBusinessException;
	
	public ReporteVO generaReporteDetalleDomiliacion(List<DiversificacionesDataReportBean> diverReportBean, 
			List<ValidacionesDataReportBean> validReportBean, List<CargosDataReportBean> cargoReportBean) throws MitBusinessException;

	public ReporteVO generaReporteDepositosAforeMovil(List<ConsultaAforeMovilDataReportBean> aforeMovilReportBean) throws MitBusinessException;
}