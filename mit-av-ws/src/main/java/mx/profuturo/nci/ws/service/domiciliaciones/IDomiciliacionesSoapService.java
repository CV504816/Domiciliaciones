package mx.profuturo.nci.ws.service.domiciliaciones;

import mx.profuturo.nci.ws.beans.request.ArchivosDomiBitacoraBeanRequest;
import mx.profuturo.nci.ws.beans.request.CatalogosDomiBeanRequest;
import mx.profuturo.nci.ws.beans.request.FiltroArchivosDomiciliacionBeanRequest;
import mx.profuturo.nci.ws.beans.request.PeticionesDomiBeanRequest;
import mx.profuturo.nci.ws.beans.request.TablaDinamicaArchDomiBeanRequest;
import mx.profuturo.nci.ws.beans.request.TipoProcesamientoDomisBeanRequest;
import mx.profuturo.nci.ws.beans.request.UltimosArchivosGeneradosBeanRequest;
import mx.profuturo.nci.ws.beans.response.ArchivosDomiBitacoraBeanResponse;
import mx.profuturo.nci.ws.beans.response.ArchivosDomiciliacionBeanResponse;
import mx.profuturo.nci.ws.beans.response.ArchivosDomiciliacionBitacoraBeanResponse;
import mx.profuturo.nci.ws.beans.response.ArchivosGeneradosDomiBeanResponse;
import mx.profuturo.nci.ws.beans.response.CatalogosDomiBeanResponse;
import mx.profuturo.nci.ws.beans.response.CifrasDomiBeanResponse;
import mx.profuturo.nci.ws.beans.response.GeneracionArchivosDomiBeanResponse;
import mx.profuturo.nci.ws.beans.response.RegistrosArchivoBeanResponse;
import mx.profuturo.nci.ws.beans.response.TipoProcesamientoDomiResponse;
import mx.profuturo.nci.ws.beans.response.TablaDinamicaArchDomiBeanResponse;
import mx.profuturo.nci.ws.beans.response.TipoProcesamientoDomisBeanResponse;

public interface IDomiciliacionesSoapService {
	
	public TipoProcesamientoDomiResponse consultarTipoProcesamientoDomi ();
	
	public ArchivosDomiBitacoraBeanResponse consultarArchivosDomiBitacora (ArchivosDomiBitacoraBeanRequest request);
	
	public CatalogosDomiBeanResponse catalogosControlDomi (CatalogosDomiBeanRequest request);
	
	public ArchivosGeneradosDomiBeanResponse ultimosArchivosGenerados(UltimosArchivosGeneradosBeanRequest request);
	
	public CifrasDomiBeanResponse cifrasDomi(PeticionesDomiBeanRequest request);
	
	public GeneracionArchivosDomiBeanResponse generarArchivosDomi(PeticionesDomiBeanRequest request);
	
	public ArchivosDomiciliacionBeanResponse consultarArchivosDomiciliacion(FiltroArchivosDomiciliacionBeanRequest request);
	
	public ArchivosDomiciliacionBitacoraBeanResponse consultarArchivosDomiciliacionBitacora(FiltroArchivosDomiciliacionBeanRequest request);
	
	public GeneracionArchivosDomiBeanResponse generarArchivosDomiLotes(PeticionesDomiBeanRequest request);

	public TablaDinamicaArchDomiBeanResponse generarTablaDinamicaArchDomi(TablaDinamicaArchDomiBeanRequest request);
	
	public TipoProcesamientoDomisBeanResponse actValorProcesamientoDomi(TipoProcesamientoDomisBeanRequest request);
	
	public RegistrosArchivoBeanResponse consultarRegistrosArchivo(String folio);
}
