package mx.profuturo.nci.ws.service.impl.bancos;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.ws.service.exception.WebServiceException;

import mx.profuturo.nci.business.exception.ErrorCodeSoap;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.IBancosService;
import mx.profuturo.nci.business.vo.BancosVO;
import mx.profuturo.nci.business.vo.FolioBancoVO;
import mx.profuturo.nci.business.vo.GenericCatalogoVO;
import mx.profuturo.nci.business.vo.MapaReferenciasVO;
import mx.profuturo.nci.business.wrapped.BancosFilter;
import mx.profuturo.nci.persistence.BancoPersistence;
import mx.profuturo.nci.ws.beans.FolioBancoBean;
import mx.profuturo.nci.ws.beans.GenericoCatalogoBean;
import mx.profuturo.nci.ws.beans.MovBancoBean;
import mx.profuturo.nci.ws.beans.request.MovBancoActualizarBeanRequest;
import mx.profuturo.nci.ws.beans.request.MovBancoConsultarBeanRequest;
import mx.profuturo.nci.ws.beans.response.MovBancoConsultarBeanResponse;
import mx.profuturo.nci.ws.service.bancos.IBancosSoapService;
import mx.profuturo.nci.ws.util.UtilMapping;

@Service("bancosSoapService")
public class BancosSoapServiceImpl implements IBancosSoapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BancosSoapServiceImpl.class);
	@Autowired IBancosService bancoService;

	@Override
	public MovBancoConsultarBeanResponse consultar(MovBancoConsultarBeanRequest movBancoConsultarBeanRequest) {
		List<MovBancoBean> lista = new ArrayList<MovBancoBean>();
		try {
			if (movBancoConsultarBeanRequest != null) {
				BancosFilter bancosFilter = new BancosFilter();
				bancosFilter.setIdBanco(movBancoConsultarBeanRequest.getIdBanco());
				bancosFilter.setFolio(movBancoConsultarBeanRequest.getFolio());
				bancosFilter.setNumCuentaIndividual(movBancoConsultarBeanRequest.getNumCuenta());
				bancosFilter.setOrigenAportaciones(movBancoConsultarBeanRequest.getListaAportaciones());
				bancosFilter.setRegConciliado(movBancoConsultarBeanRequest.getRegConciliado());
				if (movBancoConsultarBeanRequest.getClaveBanco() != null) {
					GenericCatalogoVO claveBanco = new GenericCatalogoVO();
					claveBanco.setId(movBancoConsultarBeanRequest.getClaveBanco());
					bancosFilter.setClaveBanco(claveBanco);
				}
				
				for (BancosVO bancos : bancoService.consultar(bancosFilter)) {
					MovBancoBean bancobean = new MovBancoBean();
					UtilMapping.mapVoToBean(bancobean, bancos);
					if(bancos.getSubctaApovol() != null){
						GenericoCatalogoBean subcuenta = new GenericoCatalogoBean();
						subcuenta.setId(bancos.getSubctaApovol().getClaveNCI());
						subcuenta.setValor(bancos.getSubctaApovol().getDescripcionNCI());
						bancobean.setRefSubcuentaApovol(subcuenta);
					}
					if(bancos.getClaveBanco() != null){
						GenericoCatalogoBean claveBanco = new GenericoCatalogoBean();
						UtilMapping.mapVoToBean(claveBanco, bancos.getClaveBanco());
						bancobean.setClaveBanco(claveBanco);
					}
					if(bancos.getOrigenAportacion() != null){
						GenericoCatalogoBean origenAportacion	 = new GenericoCatalogoBean();
						UtilMapping.mapVoToBean(origenAportacion, bancos.getOrigenAportacion());
						bancobean.setOrigenAportacion(origenAportacion);
					}
					if(bancos.getIndicadorSbc() != null){
						GenericoCatalogoBean indicadorSBC = new GenericoCatalogoBean();
						UtilMapping.mapVoToBean(indicadorSBC, bancos.getIndicadorSbc());
						bancobean.setIndSalvoBuenCobro(indicadorSBC);
					}
					if(bancos.getEstatusIDC() != null){
						GenericoCatalogoBean estatusIDC = new GenericoCatalogoBean();
						UtilMapping.mapVoToBean(estatusIDC, bancos.getEstatusIDC());
						bancobean.setEstatusIDC(estatusIDC);
					}
					if(bancos.getFolioRelacionado()!=null && !bancos.getFolioRelacionado().isEmpty()) {
						bancobean.setFolioRelacionado(new ArrayList<FolioBancoBean>());
						for(FolioBancoVO fb:bancos.getFolioRelacionado()) {
							FolioBancoBean fbBean = new FolioBancoBean();
							UtilMapping.mapVoToBean(fbBean,fb);
							bancobean.getFolioRelacionado().add(fbBean);
						}
					}
					lista.add(bancobean);
				}
			}
		} catch (MitBusinessException ex) {
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService:"+ex.getMessage(),
							new Object[] { "BancosSoapServiceImpl", "consultar(...)" }, ex));
			LOGGER.error(webServiceException.getMessage(), ex);
			throw webServiceException;
		}
		return new MovBancoConsultarBeanResponse(lista);
	}

	@Override
	public int actualizar(MovBancoActualizarBeanRequest movBancoInsertarBeanRequest) {
		try {
			if (movBancoInsertarBeanRequest.getMovBanco() != null) {
				MovBancoBean bancosBean = movBancoInsertarBeanRequest.getMovBanco();
				BancosVO bancosVO = new BancosVO();
				UtilMapping.mapBeanToVO(bancosBean, bancosVO);
				bancosVO.setUsuarioActualizacion(bancosBean.getUsuario());
				if(bancosBean.getRefSubcuentaApovol() != null){
					MapaReferenciasVO subcuenta = new MapaReferenciasVO();
					subcuenta.setClaveNCI(bancosBean.getRefSubcuentaApovol() != null ? bancosBean.getRefSubcuentaApovol().getId() : null);
					bancosVO.setSubctaApovol(subcuenta);
				}
				if(bancosBean.getClaveBanco() != null){
					GenericCatalogoVO claveBanco = new GenericCatalogoVO();
					UtilMapping.mapBeanToVO(bancosBean.getClaveBanco(), claveBanco);
					bancosVO.setClaveBanco(claveBanco);
				}
				if(bancosBean.getOrigenAportacion() != null){
					GenericCatalogoVO origenAportacion = new GenericCatalogoVO();
					UtilMapping.mapBeanToVO(bancosBean.getOrigenAportacion(), origenAportacion);
					bancosVO.setOrigenAportacion(origenAportacion);
				}
				if(bancosBean.getIndSalvoBuenCobro()!= null){
					GenericCatalogoVO indicadorSBC = new GenericCatalogoVO();
					UtilMapping.mapBeanToVO(bancosBean.getIndSalvoBuenCobro(), indicadorSBC);
				
					bancosVO.setIndicadorSbc(indicadorSBC);
				}
				if(bancosBean.getEstatusIDC() != null){
					GenericCatalogoVO estatusIDC = new GenericCatalogoVO();
					UtilMapping.mapBeanToVO(bancosBean.getEstatusIDC(), estatusIDC);
					bancosVO.setEstatusIDC(estatusIDC);
				}
				if(bancosBean.getFolioRelacionado()!= null && ! bancosBean.getFolioRelacionado().isEmpty()) {
					bancosVO.setFolioRelacionado(new ArrayList<FolioBancoVO>());
					for(FolioBancoBean fbb:bancosBean.getFolioRelacionado()) {
						FolioBancoVO fbvo = new FolioBancoVO();
						UtilMapping.mapBeanToVO(fbb,fbvo);
						bancosVO.getFolioRelacionado().add(fbvo);
					}
				}
				return bancoService.actualizar(bancosVO);
			}else{
				return 0;
			}
		} catch (MitBusinessException ex) {
			LOGGER.error(ex.getMessage(),ex);
			throw new WebServiceException(ex.getExceptionDetails());
		} catch (Exception ex) {
			WebServiceException webServiceException = new WebServiceException(
					GenerateExceptionDetails.generate(ErrorCodeSoap.EX_EXCEPTION, "En WebService:"+ex.getMessage(),
							new Object[] { "BancosSoapServiceImpl", "actualizar(...)" }, ex));
			LOGGER.error(webServiceException.getMessage(), ex);
			throw webServiceException;
		}
	}

}
