package mx.profuturo.nci.ws.service.impl.domiciliacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mx.profuturo.nci.business.exception.ErrorCodeSoap;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.ISolicitudService;
import mx.profuturo.nci.business.util.enums.CtrlResponseWSEnum;
import mx.profuturo.nci.business.vo.DatosCorreoVO;
import mx.profuturo.nci.business.vo.GenericCatalogoVO;
import mx.profuturo.nci.business.vo.SolicitudVO;
import mx.profuturo.nci.business.wrapped.SolicitudFilter;
import mx.profuturo.nci.ws.beans.ClaveSolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.SolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.request.NotificacionConciliacionApovolRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionActualizarConBeanRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionConsultarSumBeanRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionInsertarBeanRequest;
import mx.profuturo.nci.ws.beans.request.SolicitudDomiciliacionObtenerClaveBeanRequest;
import mx.profuturo.nci.ws.beans.response.ConsultarActualizarConciliacionResponse;
import mx.profuturo.nci.ws.beans.response.NotificacionConciliacionApovolResponse;
import mx.profuturo.nci.ws.beans.response.SolicitudDomiciliacionConsultarBeanResponse;
import mx.profuturo.nci.ws.beans.response.SolicitudDomiciliacionConsultarSumBeanResponse;
import mx.profuturo.nci.ws.beans.response.SolicitudDomiciliacionObtenerClaveBeanResponse;
import mx.profuturo.nci.ws.service.domiciliacion.ISolicitudDomiciliacionSoapService;
import mx.profuturo.nci.ws.util.UtilMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.ws.service.exception.WebServiceException;

import static mx.profuturo.nci.business.util.ConstantesCatalogos.ID_ESTATUS_CARGO_PENDIENTE;

@Service("solicitudDomiciliacionSoapService")
public class SolicitudDomiciliacionSoapServiceImpl implements ISolicitudDomiciliacionSoapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudDomiciliacionSoapServiceImpl.class);

	@Autowired ISolicitudService solicitudService;
	
	public SolicitudDomiciliacionConsultarBeanResponse consultar(SolicitudDomiciliacionConsultarBeanRequest solicitudDomiciliacionConsultarBeanRequest)
	{
		
		List<SolicitudDomiciliacionBean> listResponse=null;
		try
		{

			SolicitudFilter filter=null;
			
			if(solicitudDomiciliacionConsultarBeanRequest != null)
			{
				filter=new SolicitudFilter();
				
				filter.setNumCuentaIndividual(solicitudDomiciliacionConsultarBeanRequest.getNumCuentaIndividual());
				filter.setFolio(solicitudDomiciliacionConsultarBeanRequest.getFolio());
				filter.setEstatusSolicitudes(solicitudDomiciliacionConsultarBeanRequest.getEstatusSolicitudes());
				filter.setClaveSolicitud(solicitudDomiciliacionConsultarBeanRequest.getClaveSolicitud());
				filter.setFolioProcesar(solicitudDomiciliacionConsultarBeanRequest.getFolioProcesar());
				filter.setCurp(solicitudDomiciliacionConsultarBeanRequest.getCurp());
				filter.setCurpTutor(solicitudDomiciliacionConsultarBeanRequest.getCurpTutor());
				filter.setCuentaBanco(solicitudDomiciliacionConsultarBeanRequest.getCuentaBanco());
			}
			
			listResponse =  UtilMapping.mappingListSolicitudDomiciliacionVO(this.solicitudService.consultar(filter));
			
			
		}
		catch(MitBusinessException ex)
		{
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		}
		catch (Exception ex) 
		{
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
									new Object[] { "SolicitudDomiciliacionServiceImpl", "consultar(...)" }, ex));
						
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}
		
		return new SolicitudDomiciliacionConsultarBeanResponse(listResponse);
		
	}
	
	public SolicitudDomiciliacionConsultarBeanResponse consultarConciliaciones(SolicitudDomiciliacionConsultarBeanRequest solicitudDomiciliacionConsultarBeanRequest)
	{
		
		List<SolicitudDomiciliacionBean> listResponse=null;
		try
		{

			SolicitudFilter filter=null;
			
			if(solicitudDomiciliacionConsultarBeanRequest != null)
			{
				filter=new SolicitudFilter();
				
				filter.setNumCuentaIndividual(solicitudDomiciliacionConsultarBeanRequest.getNumCuentaIndividual());
				filter.setFolio(solicitudDomiciliacionConsultarBeanRequest.getFolio());
				filter.setEstatusSolicitudes(solicitudDomiciliacionConsultarBeanRequest.getEstatusSolicitudes());
				filter.setClaveSolicitud(solicitudDomiciliacionConsultarBeanRequest.getClaveSolicitud());
				filter.setFolioProcesar(solicitudDomiciliacionConsultarBeanRequest.getFolioProcesar());
				filter.setCurp(solicitudDomiciliacionConsultarBeanRequest.getCurp());
				filter.setCurpTutor(solicitudDomiciliacionConsultarBeanRequest.getCurpTutor());
				filter.setCuentaBanco(solicitudDomiciliacionConsultarBeanRequest.getCuentaBanco());
			}
			
			listResponse =  UtilMapping.mappingListSolicitudDomiciliacionVO(this.solicitudService.consultarSolAux(filter));
			
			
		}
		catch(MitBusinessException ex)
		{
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		}
		catch (Exception ex) 
		{
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
									new Object[] { "SolicitudDomiciliacionServiceImpl", "consultarSolAux(...)" }, ex));
						
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}
		
		return new SolicitudDomiciliacionConsultarBeanResponse(listResponse);
		
	}

	public SolicitudDomiciliacionObtenerClaveBeanResponse obtenerClaveSolicitud(SolicitudDomiciliacionObtenerClaveBeanRequest solicitudDomiciliacionObtenerClaveBeanRequest) {
		
		ClaveSolicitudDomiciliacionBean responseClave=null;
		
		try{
			SolicitudFilter filter=null;
			if(solicitudDomiciliacionObtenerClaveBeanRequest != null)
			{
				filter=new SolicitudFilter();
				
				filter.setClaveSolicitud(solicitudDomiciliacionObtenerClaveBeanRequest.getClaveSolicitudAux());
				filter.setCurp(solicitudDomiciliacionObtenerClaveBeanRequest.getCurp());
			}
			
			responseClave =  UtilMapping.mappingClaveSolicitudDomiciliacionVO(this.solicitudService.obtenerClaveSolicitud(filter));

		}catch(MitBusinessException ex){
				LOGGER.error(ex.getMessage(),ex);
				throw new WebServiceException(ex.getExceptionDetails());
		}catch (Exception ex) {
				WebServiceException webServiceException = new WebServiceException(
						GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
										new Object[] { "SolicitudDomiciliacionServiceImpl", "obtenerClaveSolicitud(...)" }, ex));
							
				LOGGER.error(webServiceException.getMessage(), ex);
				
				throw webServiceException;
		}
		return new SolicitudDomiciliacionObtenerClaveBeanResponse(responseClave);
	}
	// MAMC ATENCION A MEJORA 2362
	public SolicitudDomiciliacionConsultarSumBeanResponse consultarMonto(SolicitudDomiciliacionConsultarSumBeanRequest solicitudDomiciliacionConsultarSumBeanRequest)
	{
		
		List<SolicitudDomiciliacionBean> listResponse=null;
		try
		{

			SolicitudFilter filter=null;
			
			if(solicitudDomiciliacionConsultarSumBeanRequest != null)
			{
				filter=new SolicitudFilter();
				
				filter.setNumCuentaIndividual(solicitudDomiciliacionConsultarSumBeanRequest.getNumCuentaIndividual());
				filter.setFolio(solicitudDomiciliacionConsultarSumBeanRequest.getFolio());
				filter.setEstatusSolicitudes(solicitudDomiciliacionConsultarSumBeanRequest.getEstatusSolicitudes());
				filter.setClaveSolicitud(solicitudDomiciliacionConsultarSumBeanRequest.getClaveSolicitud());
				filter.setCuentaBanco(solicitudDomiciliacionConsultarSumBeanRequest.getCuentaBanco());
			}
			
			listResponse =  UtilMapping.mappingListSolicitudDomiciliacionVO(this.solicitudService.consultarMonto(filter));
			
			
		}
		catch(MitBusinessException ex)
		{
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		}
		catch (Exception ex) 
		{
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
									new Object[] { "SolicitudDomiciliacionServiceImpl", "consultarMonto(...)" }, ex));
						
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}
		
		return new SolicitudDomiciliacionConsultarSumBeanResponse(listResponse);
		
	}
	
	@Override
	public boolean Insertar(SolicitudDomiciliacionInsertarBeanRequest solicitudDomiciliacionInsertarBeanRequest) {
		try {
			int estatusOperacion = 0;
			if (solicitudDomiciliacionInsertarBeanRequest != null) {
				
				SolicitudVO solicitudDomiciliacionVO = UtilMapping.mappingSolicitudDomiciliacionBean(solicitudDomiciliacionInsertarBeanRequest.getSolicitudDomiciliacion());
				if(solicitudDomiciliacionInsertarBeanRequest.getSolicitudDomiciliacion().getUsuario()!=null){
					solicitudDomiciliacionVO.setUsuarioCreacion(solicitudDomiciliacionInsertarBeanRequest.getSolicitudDomiciliacion().getUsuario());
				}
				if(solicitudDomiciliacionInsertarBeanRequest.getSolicitudDomiciliacion().getUsuarioCreacion()!=null){
					solicitudDomiciliacionVO.setUsuarioCreacion(solicitudDomiciliacionInsertarBeanRequest.getSolicitudDomiciliacion().getUsuarioCreacion());
				}
				
				setDefaultSolicitudData(solicitudDomiciliacionVO);
				/**
				 * FO998192 .- Se identifica Origen Traspasos Pro para evitar que inserte la solicitud y deje continuar el flujo
				 * 12/05/2023
				 */
				if(solicitudDomiciliacionVO.getOrigenSolicitud().getId() == 1610 ){
					estatusOperacion = 1;
				}else {
					estatusOperacion= solicitudService.insertar(solicitudDomiciliacionVO);
				}
			}
			return estatusOperacion == 1;
		}
		catch(MitBusinessException ex)
		{
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		}		
		catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService",
							new Object[] { "SolicitudDomiciliacionServiceImpl", "insertar(...)" }, ex));
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}

	}

	private void setDefaultSolicitudData(SolicitudVO solVO) throws MitBusinessException {
		if(solVO.getEstatusCargo()== null || solVO.getEstatusCargo().getId()==null){
			solVO.setEstatusCargo(new GenericCatalogoVO(ID_ESTATUS_CARGO_PENDIENTE));
		}
		if(solVO.getPeriodo()!=null &&  solVO.getPeriodo().getId() !=null ){
			solVO.setFechaProximoCargo(solicitudService.getProximaFechaDeCargo(solVO));
		}
		
	}
	

	
	

	@Override
	public boolean Actualizar(SolicitudDomiciliacionActualizarBeanRequest solicitudDomiciliacionActualizarBeanRequest) {
		try {
			int estatusOperacion = 0;
			if (solicitudDomiciliacionActualizarBeanRequest != null) {
				SolicitudDomiciliacionBean solicitudDomiciliacion = solicitudDomiciliacionActualizarBeanRequest.getSolicitudDomiciliacion();
				SolicitudVO solicitudDomiciliacionVO = UtilMapping.mappingSolicitudDomiciliacionBean(solicitudDomiciliacion);
				if(solicitudDomiciliacion.getUsuario()!=null){
					solicitudDomiciliacionVO.setUsuarioActualizacion(solicitudDomiciliacion.getUsuario());
				}
				if(solicitudDomiciliacion.getUsuarioActualizacion()!=null){
					solicitudDomiciliacionVO.setUsuarioActualizacion(solicitudDomiciliacion.getUsuarioActualizacion());
				}
				if(solicitudDomiciliacionVO.getPeriodo()!=null &&  solicitudDomiciliacionVO.getPeriodo().getId() !=null){
					solicitudDomiciliacionVO.setFechaProximoCargo(solicitudService.getProximaFechaDeCargo(solicitudDomiciliacionVO));
				}
				
//				Long importe = 0L;
//				if(solicitudDomiciliacion.getDiversificaciones()!= null) {
//					if(solicitudDomiciliacion.getDiversificaciones().size()>0) {
//						for (DiversificacionBean diversificacionVO : solicitudDomiciliacion.getDiversificaciones()) {
//							importe = importe + diversificacionVO.getMonto().longValue();
//						}
//					}
//				}
//				
//				if(importe>0) {
//					if(importe != (solicitudDomiciliacion.getImporte()==null?0L:solicitudDomiciliacion.getImporte().longValue())) {
//						throw new Exception("El importe de la domiciliación es diferente al de la diversificación");
//					}						
//				}
				
				estatusOperacion = solicitudService.actualizar(solicitudDomiciliacionVO);
			}
			return estatusOperacion == 1; 
		}
		catch(MitBusinessException ex)
		{
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		}		
		catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService",
							new Object[] { "SolicitudDomiciliacionServiceImpl", "actualizar(...)" }, ex));
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}

	}
	
public NotificacionConciliacionApovolResponse consultarNotificacionConciliacionApovol (NotificacionConciliacionApovolRequest request) {
		
		try {
			NotificacionConciliacionApovolResponse response = null;
			
			return new NotificacionConciliacionApovolResponse(CtrlResponseWSEnum.WS_OK.getCodRet(),CtrlResponseWSEnum.WS_OK.getCodRet(),"Correcto");
		}catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService",
							new Object[] { "SolicitudDomiciliacionServiceImpl", "actualizar(...)" }, ex));
			LOGGER.error(webServiceException.getMessage(), ex);
			
			throw webServiceException;
		}finally {
			
			
		}
	}
@Override
public boolean consultaActualizarConciliacion(SolicitudDomiciliacionActualizarConBeanRequest solicitudDomiciliacionActualizarConBeanRequest) {
	boolean respuesta =false;
	int dias = 3;
	Calendar calendar;
	DateFormat dateFormat;
	Date fechaCargo, fechaCargoComp, fecha, fechHoy;
	String respDiaHabil =null;
	//short tipoNotif=183, estatusSol=0;
	SimpleDateFormat formato = null;
	String fechaConDias =null , fechaHoy =null;
	Boolean isDiaHabil = null;
	String  fechaProxCargo=null;
	formato = new SimpleDateFormat("yyyy-MM-dd"); 
	dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	List<DatosCorreoVO> listaDatos = new ArrayList<DatosCorreoVO>();
	try {
		
		if (solicitudDomiciliacionActualizarConBeanRequest != null) {
			String claveSolicitud = solicitudDomiciliacionActualizarConBeanRequest.getClaveSolicitud();
			
			listaDatos = solicitudService.getFechaProxCargo(claveSolicitud);
			
			
			fechaProxCargo = listaDatos.get(0).getFechaProxCargo();
			fechaCargo = formato.parse(fechaProxCargo);
		    fechaHoy = dateFormat.format(new Date()); // fecha de hoy
		    fechHoy = formato.parse(fechaHoy);
		   
		    if(fechHoy.before(fechaCargo)){
		    	respuesta= true;
		    }else {
		    	calendar = Calendar.getInstance();
			    calendar.setTime(fechaCargo); // Configuramos la fecha que se recibe
		        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de d�as a a�adir, o restar en caso de d�as<0
		        fechaCargoComp = dateFormat.parse(dateFormat.format(calendar.getTime()));
		        fechaConDias = dateFormat.format(fechaCargoComp);
		        formato = new SimpleDateFormat("yyyy-MM-dd"); 
		        fecha = formato.parse(fechaConDias); //convertir a date para comparar

		        isDiaHabil= solicitudService.getDiaHabil(fecha);
		        if ( isDiaHabil==true) { //validar si es dia habil
			        fechaHoy = dateFormat.format(new Date()); // fecha de hoy
			        fechHoy = formato.parse(fechaHoy);
			        if((fechHoy.after(fecha)) || (fechHoy.equals(fecha))) {
			        	respuesta= true;
			        }
		        }else {
		        	respDiaHabil= solicitudService.getDiaHabilNom(fecha);
		        	if (respDiaHabil.equals("SABADO"))
		        	{
		        		dias=dias+2;
		        		calendar.setTime(fechaCargo); // Configuramos la fecha que se recibe
		 		        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de d�as a a�adir, o restar en caso de d�as<0
		 		        fechaCargoComp = dateFormat.parse(dateFormat.format(calendar.getTime()));
		 		        fechaConDias = dateFormat.format(fechaCargoComp);
		 		        fecha = formato.parse(fechaConDias); //convertir a date para comparar
		 		       	isDiaHabil= solicitudService.getDiaHabil(fecha);
				        if((fechHoy.after(fecha)) || (fechHoy.equals(fecha))) {
				        	respuesta= true;
				        }
		        		
		        	}else if (respDiaHabil.equals("DOMINGO")) {
		        		dias=dias+1;
		        		calendar.setTime(fechaCargo); // Configuramos la fecha que se recibe
		 		        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de d�as a a�adir, o restar en caso de d�as<0
		 		        fechaCargoComp = dateFormat.parse(dateFormat.format(calendar.getTime()));
		 		        fechaConDias = dateFormat.format(fechaCargoComp);
		 		        fecha = formato.parse(fechaConDias); //convertir a date para comparar
		 		        isDiaHabil= solicitudService.getDiaHabil(fecha);
				        if((fechHoy.after(fecha)) || (fechHoy.equals(fecha))) {
				        	respuesta= true;

				        }else {
				        	respuesta= false;
				        }
		        	}else {
		        		respuesta= false;
		        	}
		        	
		        }
			
		    }
		  
		}
		else {
			respuesta= false;
		}
		 return respuesta;
	}
	catch(MitBusinessException ex)
	{
		LOGGER.error(ex.getMessage(),ex);
		throw new WebServiceException(ex.getExceptionDetails());
	}		
	catch (Exception ex) {
		WebServiceException webServiceException = new WebServiceException(
				GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService",
						new Object[] { "SolicitudDomiciliacionServiceImpl", "actualizar(...)" }, ex));
		LOGGER.error(webServiceException.getMessage(), ex);
		
		throw webServiceException;
	}finally {
		calendar = null;
		dateFormat = null;
		respDiaHabil =null;
		formato = null;
		fechaConDias =null ; fechaHoy =null;
		isDiaHabil = null;
		 fechaProxCargo=null; 
		formato = null;
		dateFormat = null;
		listaDatos = null;
		
	}

}
}
