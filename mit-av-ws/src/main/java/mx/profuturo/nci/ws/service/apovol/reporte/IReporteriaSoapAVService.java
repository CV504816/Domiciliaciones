package mx.profuturo.nci.ws.service.apovol.reporte;

import mx.profuturo.nci.ws.beans.request.CifrasControlReclaApoVolReportRequest;
import mx.profuturo.nci.ws.beans.request.CifrasGeneralesReportRequest;
import mx.profuturo.nci.ws.beans.response.CifrasGeneralesReportResponse;

public interface IReporteriaSoapAVService {
	public CifrasGeneralesReportResponse cifrasControl(CifrasGeneralesReportRequest request);
	
	public CifrasGeneralesReportResponse cifrasControlReclaApoVol(CifrasControlReclaApoVolReportRequest request);
}
