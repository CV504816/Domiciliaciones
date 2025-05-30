package mx.profuturo.nci.ws.service.impl.predomiciliacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.ws.service.exception.WebServiceException;

import mx.profuturo.nci.business.exception.ErrorCodeSoap;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.IPreSolicitudService;
import mx.profuturo.nci.business.vo.GenericCatalogoVO;
import mx.profuturo.nci.business.vo.ValidacionesVO;
import mx.profuturo.nci.business.wrapped.PreSolicitudFilter;
import mx.profuturo.nci.ws.beans.PreSolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.request.PreSolicitudDomiciliacionActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.request.PreSolicitudDomiciliacionConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.request.PreSolicitudDomiciliacionInsertarBeanRequest;
import mx.profuturo.nci.ws.beans.request.PreSolicitudDomiciliacionRechazarBeanRequest;
import mx.profuturo.nci.ws.beans.response.PreSolicitudDomiciliacionConsultarBeanResponse;
import mx.profuturo.nci.ws.service.predomiciliacion.IPreSolicitudDomiciliacionSoapService;
import mx.profuturo.nci.ws.util.UtilMapping;
import mx.profuturo.nci.ws.util.enums.PresolicitudEnum;

import static mx.profuturo.nci.business.util.ConstantesCatalogos.ID_ESTATUS_SOLICITUD_RECHAZADO;
import static mx.profuturo.nci.business.util.ConstantesCatalogos.ID_ESTATUS_SOLICITUD_PENDIENTE;


@Service("preSolicitudDomiciliacionSoapService")
public class PreSolicitudDomiciliacionSoapServiceImpl implements IPreSolicitudDomiciliacionSoapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PreSolicitudDomiciliacionSoapServiceImpl.class);

	@Autowired
	IPreSolicitudService preSolicitudService;

	@Override
	public Boolean insertar(final PreSolicitudDomiciliacionInsertarBeanRequest preSolicitudDomiciliacionInsertarBeanRequest) {
		try {
			if (preSolicitudDomiciliacionInsertarBeanRequest != null && preSolicitudDomiciliacionInsertarBeanRequest.getPreSolicitudDomiciliacion() != null) {
				return this.preSolicitudService.guardar(UtilMapping.mappingPreSolicitudDomiciliacionBean(
						preSolicitudDomiciliacionInsertarBeanRequest.getPreSolicitudDomiciliacion(), PresolicitudEnum.MAPPING_TO_INSERTAR));
			} else {
				return false;
			}
		} catch (MitBusinessException ex) {
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService:"+ex.getMessage(),
							new Object[] { getClass().getSimpleName(), "insertar(...)" }, ex));

			LOGGER.error(webServiceException.getMessage(), ex);

			throw webServiceException;
		}

	}

	@Override
	public PreSolicitudDomiciliacionConsultarBeanResponse consultar(
			PreSolicitudDomiciliacionConsultarBeanRequest preSolicitudDomiciliacionConsultarBeanRequest) {
		List<PreSolicitudDomiciliacionBean> listResponse=null;
		PreSolicitudFilter preSolicitudFilter = null;
		ValidacionesVO validacion = null;
		validacion = new ValidacionesVO();
		try {
		
				if((validacion = preSolicitudDomiciliacionConsultarBeanRequest.validaRequestConsulta()).isEstatus()) {
				preSolicitudFilter = new PreSolicitudFilter();
				preSolicitudFilter.setNumCuentaIndividual(preSolicitudDomiciliacionConsultarBeanRequest.getNumCuentaIndividual());
				preSolicitudFilter.setFolio(preSolicitudDomiciliacionConsultarBeanRequest.getFolio());
				preSolicitudFilter.setClaveSolicitud(preSolicitudDomiciliacionConsultarBeanRequest.getClaveSolicitud());
				preSolicitudFilter.setEstatusSolicitudes(preSolicitudDomiciliacionConsultarBeanRequest.getEstatusSolicitudes());
				preSolicitudFilter.setFolioProcesar(preSolicitudDomiciliacionConsultarBeanRequest.getFolioProcesar());
				preSolicitudFilter.setCurp(preSolicitudDomiciliacionConsultarBeanRequest.getCurp());
				preSolicitudFilter.setCurpTutor(preSolicitudDomiciliacionConsultarBeanRequest.getCurpTutor());
				preSolicitudFilter.setCuentaBanco(preSolicitudDomiciliacionConsultarBeanRequest.getCuentaBanco());
				
				listResponse = UtilMapping.mappingListPreSolicitudDomiciliacionVO(this.preSolicitudService.consultar(preSolicitudFilter));
			}else {
				  return new PreSolicitudDomiciliacionConsultarBeanResponse(
						  validacion.getMensaje(),validacion.getCodigo()
						  );
	                       
			}
			return new PreSolicitudDomiciliacionConsultarBeanResponse(listResponse);
		} catch (MitBusinessException ex) {
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
							new Object[] { getClass().getSimpleName(), "consultar(...)" }, ex));

			LOGGER.error(webServiceException.getMessage(), ex);

			throw webServiceException;
		}
		finally {
			listResponse=null;
			preSolicitudFilter=null;
		}
	}

	@Override
	public Boolean actualizar(PreSolicitudDomiciliacionActualizarBeanRequest preSolicitudDomiciliacionActualizarBeanRequest) {
		try {
			if (preSolicitudDomiciliacionActualizarBeanRequest != null && preSolicitudDomiciliacionActualizarBeanRequest.getPreSolicitudDomiciliacion() != null) {
				return this.preSolicitudService.actualizar(UtilMapping.mappingPreSolicitudDomiciliacionBean(
						preSolicitudDomiciliacionActualizarBeanRequest.getPreSolicitudDomiciliacion(), PresolicitudEnum.MAPPING_TO_ACTUALIZAR));
			} else {
				return false;
			}
		} catch (MitBusinessException ex) {
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
							new Object[] { getClass().getSimpleName(), "actualizar(...)" }, ex));

			LOGGER.error(webServiceException.getMessage(), ex);

			throw webServiceException;
		}
	}

	@Override
	public Boolean rechazarPendientesPorFolio(PreSolicitudDomiciliacionRechazarBeanRequest request) {
		Boolean resp=Boolean.FALSE;
		PreSolicitudFilter preSolicitudFilter = new PreSolicitudFilter();
		try {
			preSolicitudFilter.setFolio(request.getFolio());
			preSolicitudFilter.setUsuarioActualizacion(request.getUsuario());
			preSolicitudFilter.setEstatusSolicitud(new GenericCatalogoVO(ID_ESTATUS_SOLICITUD_RECHAZADO));
			preSolicitudFilter.setIdEstatusSolicitudOld(ID_ESTATUS_SOLICITUD_PENDIENTE);
			resp = preSolicitudService.actualizarEstatusPorFolioYEstatus(preSolicitudFilter);
		} catch (MitBusinessException ex) {
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService: "+ex.getMessage(),
							new Object[] { getClass().getSimpleName(), "rechazarPendientesPorFolio(...)" }, ex));

			LOGGER.error(webServiceException.getMessage(), ex);

			throw webServiceException;
		}
		return resp;
	}

}
