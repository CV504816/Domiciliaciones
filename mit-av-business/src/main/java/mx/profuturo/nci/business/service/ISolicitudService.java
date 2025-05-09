package mx.profuturo.nci.business.service;

import java.util.Date;
import java.util.List;

import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.vo.DatosCorreoVO;
import mx.profuturo.nci.business.vo.DiversificacionVO;
import mx.profuturo.nci.business.vo.SolicitudVO;
import mx.profuturo.nci.business.vo.SpeiDetalleApoVolVO;
import mx.profuturo.nci.business.vo.ValidacionVO;
import mx.profuturo.nci.business.wrapped.SolicitudFilter;


public interface ISolicitudService {

	public List<SolicitudVO> consultar(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public List<SolicitudVO> consultarSolAux(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public SolicitudVO obtenerClaveSolicitud(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public List<SolicitudVO> consultarMonto(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public int insertar(SolicitudVO solicitudVO) throws MitBusinessException;
	public int actualizar(SolicitudVO solicitudVO) throws MitBusinessException;
	public Date getProximaFechaDeCargo(SolicitudVO solVO) throws MitBusinessException ;
//	public List<ArchivoDomiciliacionVO> consultarInfoArchivos(ArchivoDomiciliacionfilter archivoFilter) throws MitBusinessException;
//	List<SolicitudVO> consultarDomiRecord(SolicitudFilter archivoDomiFilter)throws MitBusinessException;
	
	public List<SolicitudVO> consultarSolicitudDomiciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarSolicitudDomiciliacionCorta(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarHistSolicitud(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarHistConciliacion(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarDetSolicitudNoDomi(SolicitudFilter claveSolicitud) throws MitBusinessException;
	
	public List<ValidacionVO> consultaValidaciones(SolicitudFilter solicitudFilter) throws MitBusinessException;	
	public List<SolicitudVO> consultarCuentasSolicitudDomiciliacion(SolicitudFilter claveSolicitud) throws MitBusinessException;
	
	public List<DiversificacionVO> consultarDiversificacionesSol(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<DiversificacionVO> consultarDiversificacionesCon(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public List<SpeiDetalleApoVolVO> consultaDetalleSpei(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public List<SpeiDetalleApoVolVO> consultaDetalleNomina(SolicitudFilter solicitudFilter) throws MitBusinessException;
	
	public List<SolicitudVO> consultarCuentasSolicitud(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarCuentasConciliacion(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarCuentasBancos(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarCuentasSpei(SolicitudFilter claveSolicitud) throws MitBusinessException;
	public List<SolicitudVO> consultarCuentasTodos(SolicitudFilter claveSolicitud) throws MitBusinessException;

	public List<SolicitudVO> consultarSolicitudDomiciliacionSolicitud(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarSolicitudDomiciliacionConciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarSolicitudDomiciliacionBancos(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarSolicitudDomiciliacionSpei(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<SolicitudVO> consultarSolicitudDomiciliacionTodos(SolicitudFilter solicitudFilter) throws MitBusinessException;
	public List<DatosCorreoVO> getFechaProxCargo (String claveSol) throws MitBusinessException;
	public Boolean getDiaHabil (Date fecha) throws MitBusinessException;
	public String getDiaHabilNom (Date fecha) throws MitBusinessException;
	
	
}