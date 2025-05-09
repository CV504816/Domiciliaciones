package mx.profuturo.nci.business.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeveris.core.persistence.exception.PersistenceException;

import mx.profuturo.nci.business.exception.ErrorCodeService;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.ICalendarioService;
import mx.profuturo.nci.business.service.ISolicitudService;
import mx.profuturo.nci.business.util.DiasSemanaEnum;
import mx.profuturo.nci.business.util.UtilMethod;
import mx.profuturo.nci.business.vo.DatosCorreoVO;
import mx.profuturo.nci.business.vo.DiversificacionVO;
import mx.profuturo.nci.business.vo.SolicitudVO;
import mx.profuturo.nci.business.vo.SpeiDetalleApoVolVO;
import mx.profuturo.nci.business.vo.ValidacionVO;
import mx.profuturo.nci.business.wrapped.SolicitudFilter;
import mx.profuturo.nci.persistence.DiversificacionPersistence;
import mx.profuturo.nci.persistence.SolicitudPersistence;

@Service("solicitudService")
public class SolicitudServiceImpl implements ISolicitudService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudServiceImpl.class);

	@Autowired
	SolicitudPersistence solicitudPersistence;

	@Autowired
	DiversificacionPersistence diversificacionPersistence;
	
	@Autowired ICalendarioService calendarioService;

	public List<SolicitudVO> consultar(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try {
			return this.solicitudPersistence.selectSolicitudDomiciliacion(solicitudFilter);
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Consultar Solicitudes: "+ex.getMessage(),
					new Object[] { getClass().getSimpleName(), "consultar()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}
	
	public List<SolicitudVO> consultarSolAux(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try {
			return this.solicitudPersistence.selectSolicitudDomiciliacionAux(solicitudFilter);
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Consultar Solicitudes: "+ex.getMessage(),
					new Object[] { getClass().getSimpleName(), "consultarSolAux()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}
	
	public SolicitudVO obtenerClaveSolicitud(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try {
			return this.solicitudPersistence.selectClaveSolicitudDomiciliacionAux(solicitudFilter);
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Consultar Clave de Solicitud: "+ex.getMessage(),
					new Object[] { getClass().getSimpleName(), "consultarSolAux()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}

	public List<SolicitudVO> consultarMonto(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try {
			return this.solicitudPersistence.selectSolicitudSumDomiciliacion(solicitudFilter);
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Consultar Solicitudes: "+ex.getMessage(),
					new Object[] { getClass().getSimpleName(), "consultar()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int insertar(SolicitudVO solicitudVO) throws MitBusinessException {
		try {
//			calcularFechaProximoCargo(solicitudVO);
			int estadoEjecucion = solicitudPersistence.insertarSolicitudDomiciliacion(solicitudVO);
			if (estadoEjecucion == 1 && solicitudVO.getDiversificaciones() != null)
				for (DiversificacionVO diversificacionVO : solicitudVO.getDiversificaciones()) {
					diversificacionPersistence.insertarDiversificacionSolicitudDomiciliacion(diversificacionVO);
				}
			return estadoEjecucion;
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al insertar solicitud domiciliacion ",
					new Object[] { getClass().getSimpleName(), "insertar()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}

//	private void calcularFechaProximoCargo(SolicitudVO solicitudVO) {
//		solicitudVO.getPeriodo();
//		solicitudVO.getFechaCargo();
//		solicitudVO.getFrecuenciaInicial();
//		solicitudVO.getFrecuenciaFinal();
//		solicitudVO.getFechaProximoCargo();
//		
////		solicitudVO.setFechaProximoCargo();
//		
//	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public int actualizar(SolicitudVO solicitudVO) throws MitBusinessException {
		try {

			int estadoEjecucion = solicitudPersistence.actualizarSolicitudDomiciliacion(solicitudVO);
			
			if (estadoEjecucion == 1 && solicitudVO.getDiversificaciones() != null) {
				DiversificacionVO filtro = new DiversificacionVO();
				filtro.setClaveSolicitud(solicitudVO.getClaveSolicitud());
				List<DiversificacionVO> divExistentes = diversificacionPersistence.selectDiversificacionSolicitudDomiciliacion(filtro);
				
				if(!isAllDiversificacionesSDExist(solicitudVO.getDiversificaciones(),divExistentes)){
					//Se les cambia el estatus a no vigente 
					filtro.setUsuarioActualizacion(solicitudVO.getUsuarioActualizacion());
					diversificacionPersistence.logicDeleteDiversificacionSolicitudDomiciliacion(filtro);
					for (DiversificacionVO diversificacionVO : solicitudVO.getDiversificaciones()) {
						//Se insertan las nuevas
						diversificacionVO.setUsuarioCreacion(solicitudVO.getUsuarioActualizacion());
						diversificacionPersistence.insertarDiversificacionSolicitudDomiciliacion(diversificacionVO);
					}
				}
			}
			return estadoEjecucion;
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al actualizar solicitud domiciliacion ",
					new Object[] {getClass().getSimpleName(), "actualizar()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;

		}
	}
	
	public Date getProximaFechaDeCargo(SolicitudVO solVO) throws MitBusinessException {
		Date proxFecha= null;
		Calendar cal = Calendar.getInstance();
		Date today = UtilMethod.truncateHour(new Date(System.currentTimeMillis()));
		cal.setTime(today);
		Integer dayToday =cal.get(Calendar.DAY_OF_MONTH);
		
		switch(solVO.getPeriodo().getId()){
			case 492/*semanal*/:
					DiasSemanaEnum dia= DiasSemanaEnum.getEnumFromcatalogValue(solVO.getFrecuenciaInicial().getDiaSemana().getId());
					cal.set(Calendar.DAY_OF_WEEK, dia.getCalendarValue());
					if(System.currentTimeMillis() - cal.getTimeInMillis() >= 0){
						cal.add(Calendar.WEEK_OF_YEAR, 1);
					}
					break;
			case 493/*quincenal*/:
					if(solVO.getFrecuenciaInicial()!=null && solVO.getFrecuenciaInicial().getDia()!=null 
						&& solVO.getFrecuenciaFinal()!=null && solVO.getFrecuenciaFinal().getDia()!=null ){
						short diaQ1 = solVO.getFrecuenciaInicial().getDia();
						short diaQ2 = solVO.getFrecuenciaFinal().getDia();
						if(dayToday < diaQ1){
							cal.set(Calendar.DAY_OF_MONTH, diaQ1);
						}else if(diaQ1 <= dayToday && dayToday < diaQ2){
							cal.set(Calendar.DAY_OF_MONTH, diaQ2);
						}else{
							cal.set(Calendar.DAY_OF_MONTH, diaQ1);
							cal.add(Calendar.MONTH, 1);
						}
					}
					break;
			case 494/*mensual*/:
					if(solVO.getFrecuenciaInicial()!=null && solVO.getFrecuenciaInicial().getDia()!=null ){
						short diaM = solVO.getFrecuenciaInicial().getDia();
						cal.set(Calendar.DAY_OF_MONTH, diaM);
						if(dayToday >= diaM){
							cal.add(Calendar.MONTH, 1);
						}
					}
					break;
			case 495/*unico*/:
					if(solVO.getFechaCargo()!=null && UtilMethod.truncateHour(solVO.getFechaCargo()).after(today) ){
						cal.setTime(solVO.getFechaCargo());
					}else{
						cal.setTime(today);
						cal.add(Calendar.DAY_OF_YEAR, 1);
					}
					break;
		}
		Boolean isDiaHabil = false;
		try{
			isDiaHabil=calendarioService.esDiaHabil(cal.getTime());
		}catch(Exception e){
			isDiaHabil = true;
		}
		if(isDiaHabil){
			proxFecha=cal.getTime();
		}else{
			proxFecha= calendarioService.consultaSiguienteDiaHabil(cal.getTime());
		}
		return proxFecha;
	}
	

	private boolean isAllDiversificacionesSDExist(List<DiversificacionVO> nuevas,List<DiversificacionVO> persistidas) {
		if(nuevas!=null && persistidas!=null){
			if(nuevas.size() != persistidas.size()){
				return false;
			}else{
				return isAllDiversificacionesEquals(nuevas,persistidas);
			}
		}
		return false;
	}
	
	private boolean isAllDiversificacionesEquals(List<DiversificacionVO> nuevas,List<DiversificacionVO> persistidas){
		for(final DiversificacionVO dvo : nuevas){
			DiversificacionVO dPersist = (DiversificacionVO) CollectionUtils.find(persistidas, new Predicate() {
				public boolean evaluate(Object object) {
					if(	object!=null
							&& object instanceof DiversificacionVO
							&& dvo.getFondoAportacionVoluntaria()!=null
							&& dvo.getFondoAportacionVoluntaria().getId()!=null
							&& dvo.getClaveSolicitud()!=null){
						
						DiversificacionVO evalObject = (DiversificacionVO)object;
						if(evalObject.getFondoAportacionVoluntaria()==null){
							return false;
						}
						return dvo.getClaveSolicitud().equals(evalObject.getClaveSolicitud())
								&& dvo.getFondoAportacionVoluntaria().getId().equals(evalObject.getFondoAportacionVoluntaria().getId());
					}
					return false;
				}
			});
			if(dPersist != null && dPersist.getMonto() != null){
				if(!dPersist.getMonto().equals(dvo.getMonto())){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	

	public List<SolicitudVO> consultarSolicitudDomiciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarSolicitudDomiciliacion(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	public List<SolicitudVO> consultarSolicitudDomiciliacionCorta(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarSolicitudDomiciliacionCorta(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	
	public List<SolicitudVO> consultarHistSolicitud(SolicitudFilter claveSolicitud) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarHistSolicitud(claveSolicitud);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarHistSolicitud()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	public List<SolicitudVO> consultarHistConciliacion(SolicitudFilter claveSolicitud) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCargosConciliacion(claveSolicitud);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarHistSolicitud()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	
	public List<SolicitudVO> consultarDetSolicitudNoDomi(SolicitudFilter claveSolicitud) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarHistSolicitudNoDomi(claveSolicitud);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarHistSolicitud()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarCuentasSolicitudDomiciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitud(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<DiversificacionVO> consultarDiversificacionesSol(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			List<DiversificacionVO> lst=new ArrayList<DiversificacionVO>();
			List<DiversificacionVO> lstDiversifSol=solicitudPersistence.consultarDiversificacionesSolicitud(solicitudFilter);
			
			if(lstDiversifSol!=null && lstDiversifSol.size()>0){
				lst.addAll(lstDiversifSol);
			}else{
				List<DiversificacionVO> lstDiversifPreSol=solicitudPersistence.consultarDiversificacionesPreSolicitud(solicitudFilter);		
				
				lst.addAll(lstDiversifPreSol);
			}
			
			return lst;
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar diversificaciones solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarDiversificaciones(SolicitudFilter)" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	public List<DiversificacionVO> consultarDiversificacionesCon(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarDiversificacionesConciliacion(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar diversificaciones solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarDiversificaciones(SolicitudFilter)" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<ValidacionVO> consultaValidaciones(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarValidacionesSolicitud(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar validaciones solicitud",
							new Object[] { "SolicitudServiceImpl", "consultaValidaciones(SolicitudFilter)" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
//	public List<ArchivoDomiciliacionVO> consultarInfoArchivos(ArchivoDomiciliacionfilter archivoFilter)
//			throws MitBusinessException {
//		try {
//			List<ArchivoDomiciliacionVO> listaArchivos = new ArrayList<ArchivoDomiciliacionVO>();
//			listaArchivos.addAll(solicitudPersistence.selectArchivosDomiciliacion(archivoFilter));
//			listaArchivos.addAll(solicitudPersistence.selectArchivosOtrosDomiciliacion(archivoFilter));
//			return listaArchivos;
//		} catch (Exception ex) {
//			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
//					ErrorCodeService.EX_EXCEPTION, "Al Consultar Solicitudes ",
//					new Object[] { "SolicitudServiceImpl", "consultarInfoArchivos()" }, ex));
//
//			LOGGER.error(mitBusinessException.getMessage(), ex);
//
//			throw mitBusinessException;
//
//		}
//	}



//	public List<SolicitudVO> consultarDomiRecord(SolicitudFilter archivoDomiFilter) throws MitBusinessException {
//		List<SolicitudVO> res = null;
//		try {
//			res= solicitudPersistence.selectDomiRecords(archivoDomiFilter);
//			return res;
//		} catch (Exception ex) {
//			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
//					ErrorCodeService.EX_EXCEPTION, "Al Consultar Solicitudes ",
//					new Object[] { "SolicitudServiceImpl", "consultarInfoArchivos()" }, ex));
//	
//			LOGGER.error(mitBusinessException.getMessage(), ex);
//	
//			throw mitBusinessException;
//	
//		}
//	}
	
	public List<SpeiDetalleApoVolVO> consultaDetalleSpei(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarDetalleSpei(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar detalle SPEI conciliacion",
							new Object[] { "SolicitudServiceImpl", "consultaDetalleSpei(SolicitudFilter)" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}	
	
	public List<SpeiDetalleApoVolVO> consultaDetalleNomina(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarDetalleNomina(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar detalle SPEI conciliacion",
							new Object[] { "SolicitudServiceImpl", "consultaDetalleSpei(SolicitudFilter)" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}	
	
	public List<SolicitudVO> consultarCuentasSolicitud(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitudSolici(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarCuentasConciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitudConcil(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarCuentasBancos(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitudBanco(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarCuentasSpei(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitudSpei(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasSolicitudDomiciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	public List<SolicitudVO> consultarCuentasTodos(SolicitudFilter solicitudFilter) throws MitBusinessException {
		try{
			return solicitudPersistence.consultarCuentasSolicitudTodos(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas todas las solicitudes",
							new Object[] { "SolicitudServiceImpl", "consultarCuentasTodos()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}

	
	public List<SolicitudVO> consultarSolicitudDomiciliacionSolicitud(SolicitudFilter solicitudFilter) throws MitBusinessException{
		try{
			return solicitudPersistence.consultarSolicitudesSolicitud(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacionSolicitud()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarSolicitudDomiciliacionConciliacion(SolicitudFilter solicitudFilter) throws MitBusinessException{
		try{
			return solicitudPersistence.consultarSolicitudesConciliacion(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacionConciliacion()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarSolicitudDomiciliacionBancos(SolicitudFilter solicitudFilter) throws MitBusinessException{
		try{
			return solicitudPersistence.consultarSolicitudesBancos(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudesDomiciliacionBancos()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarSolicitudDomiciliacionSpei(SolicitudFilter solicitudFilter) throws MitBusinessException{
		try{
			return solicitudPersistence.consultarSolicitudesSpei(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudesDomiciliacionSpei()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<SolicitudVO> consultarSolicitudDomiciliacionTodos(SolicitudFilter solicitudFilter) throws MitBusinessException{
		try{
			return solicitudPersistence.consultarSolicitudesTodos(solicitudFilter);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud TODOS",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacionTodos()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public List<DatosCorreoVO> getFechaProxCargo(String claveSol) throws MitBusinessException{
		try{
			return solicitudPersistence.getFechaProxCargo(claveSol);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar cuentas solicitud TODOS",
							new Object[] { "SolicitudServiceImpl", "consultarSolicitudDomiciliacionTodos()" }, ex));

			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;
		}
	}
	
	public Boolean getDiaHabil(Date fecha) throws MitBusinessException {

		Boolean isDiaHabil = false;
		try{
			isDiaHabil=calendarioService.esDiaHabil(fecha);
		}catch(Exception e){
			isDiaHabil = true;
		}
		
		return isDiaHabil;
	}
	
	
	public String getDiaHabilNom(Date fecha) throws MitBusinessException {

		String isDiaHabilNom = null;
		try{
			isDiaHabilNom=calendarioService.esDiaHabilNom(fecha);
		}catch(Exception e){
			isDiaHabilNom = null;
		}
		
		return isDiaHabilNom;
	}

}