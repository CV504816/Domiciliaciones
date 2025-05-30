package mx.profuturo.nci.business.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import mx.profuturo.nci.business.exception.ErrorCodeService;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.IPreSolicitudService;
import mx.profuturo.nci.business.vo.DiversificacionVO;
import mx.profuturo.nci.business.vo.GenericCatalogoVO;
import mx.profuturo.nci.business.vo.PreSolicitudVO;
import mx.profuturo.nci.business.wrapped.PreSolicitudFilter;
import mx.profuturo.nci.persistence.DiversificacionPersistence;
import mx.profuturo.nci.persistence.PreSolicitudPersistence;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("preSolicitudService")
public class PreSolicitudServiceImpl implements IPreSolicitudService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PreSolicitudServiceImpl.class);
	
	
	@Autowired
	PreSolicitudPersistence preSolicitudPersistence;

	@Autowired
	DiversificacionPersistence diversificacionPersistence;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Boolean guardar(final PreSolicitudVO preSolicitudVO)throws MitBusinessException 
	{
		try
		{
			if(preSolicitudVO != null)
			{
						
				final Integer numInsert = this.preSolicitudPersistence.insert(preSolicitudVO);						
				
				if(numInsert != null && numInsert > 0)
				{
					
					Boolean statusDiver=Boolean.TRUE;
					Boolean statusComen=Boolean.TRUE;
					
					if(CollectionUtils.isNotEmpty(preSolicitudVO.getDiversificaciones()))
					{												
						forDiver:
						for(DiversificacionVO diversificacionVO : preSolicitudVO.getDiversificaciones())
						{
							final Integer numInsertDive = this.diversificacionPersistence.insertDiversificacionPreSolicitud(diversificacionVO);
							
							if(numInsertDive == null || numInsertDive == 0)
							{
								statusDiver = Boolean.FALSE;
								break forDiver;
							}
						}						
					}
					
					if(statusDiver && statusComen)
					{
						return true;
					}
					else
					{
						return false;
					}
					
										
				}
				else
				{
					return false;
				}
			}	
			else
			{
				return false;
			}
				
			
		}
		catch(Exception ex)
		{
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Guardar PreSolicitud ",
					new Object[] { "PreSolicitudServiceImpl", "guardar()" }, ex));

//			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;			
		}
	}

	public Boolean actualizar(PreSolicitudVO preSolicitudVO) throws MitBusinessException {
		try
		{
			String folio = "";
			String usuAct = "";
			if(preSolicitudVO != null)
			{
				final Integer numUpdate = this.preSolicitudPersistence.actualizar(preSolicitudVO);						
				
				if(numUpdate != null && numUpdate > 0 && preSolicitudVO.getDiversificaciones() != null)
				{
					Map<Short,DiversificacionVO> divActual = new HashMap<Short,DiversificacionVO>();
					
					DiversificacionVO filtro = new DiversificacionVO();
					filtro.setClaveSolicitud(preSolicitudVO.getClaveSolicitud());
					List<DiversificacionVO> divExistentes = diversificacionPersistence.selectDiversificacionPreSolicitudDomiciliacion(filtro);
					
					for(DiversificacionVO diverVo: divExistentes){
						if(diverVo.getFolio()!=null && !diverVo.getFolio().isEmpty()){
							folio = diverVo.getFolio();
							usuAct = diverVo.getUsuarioActualizacion();
							divActual.put(diverVo.getFondoAportacionVoluntaria().getId(), diverVo);
						}
					}
									
					List<DiversificacionVO> lstDiver = preSolicitudVO.getDiversificaciones(); 
					for(DiversificacionVO divo: lstDiver){
						DiversificacionVO diver;
						if(divActual.containsKey(divo.getFondoAportacionVoluntaria().getId())){
							diver = divo;
							diver.setClaveSolicitud(divo.getClaveSolicitud());
							diver.setFolio(divo.getFolio());
							diver.setFondoAportacionVoluntaria(divo.getFondoAportacionVoluntaria());
							diver.setMonto(divo.getMonto());
							diver.setPorcentaje(divo.getPorcentaje());
							diver.setUsuarioActualizacion(divo.getUsuarioActualizacion());
							
							this.diversificacionPersistence.actualizarDiversificacionPreSolicitudDomiciliacion(diver);
							divActual.remove(divo.getFondoAportacionVoluntaria().getId());
						}else{
							diver = new DiversificacionVO(); 
							diver.setClaveSolicitud(divo.getClaveSolicitud());
							diver.setFolio(folio);
							diver.setFondoAportacionVoluntaria(divo.getFondoAportacionVoluntaria());
							diver.setMonto(divo.getMonto());
							diver.setPorcentaje(divo.getPorcentaje());
							diver.setUsuarioCreacion(divo.getUsuarioActualizacion());
						
							this.diversificacionPersistence.insertDiversificacionPreSolicitud(diver);
						}
					}
					
					if(divActual.size()>0){
						Set<Entry<Short,DiversificacionVO>> s = divActual.entrySet();
						Iterator<Entry<Short, DiversificacionVO>> it = s.iterator();
						while ( it.hasNext() ) {
							Map.Entry entry = (Map.Entry) it.next();
							
							DiversificacionVO registro = (DiversificacionVO)entry.getValue();
							registro.setMonto(BigDecimal.ZERO);
							registro.setPorcentaje(new Short("0"));
							registro.setUsuarioActualizacion(usuAct);
							
							this.diversificacionPersistence.actualizarDiversificacionPreSolicitudDomiciliacion(registro);							
						}
					}
					
					Boolean statusDiver=Boolean.TRUE;
					Boolean statusComen=Boolean.TRUE;
					
					if(statusDiver && statusComen)
					{
						return true;
					}
					else
					{
						return false;
					}				
				}
				else
				{
					return false;
				}
			}	
			else
			{
				return false;
			}
				
			
		}
		catch(Exception ex)
		{
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al Actualizar PreSolicitud ",
					new Object[] { "PreSolicitudServiceImpl", "actualizar()" }, ex));

//			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;			
		}
	}

	public List<PreSolicitudVO> consultar(PreSolicitudFilter preSolicitudFilter) throws MitBusinessException {
		List<PreSolicitudVO> listaPreSolicitudes = new ArrayList<PreSolicitudVO>();
		PreSolicitudVO selectBandera =null;
		try
		{
			if(preSolicitudFilter != null)
			{
				selectBandera= new PreSolicitudVO();
				selectBandera = preSolicitudPersistence.selectBandera();
				//if(selectBandera.getVigencia().intValue() == 0) {
				//listaPreSolicitudes =  preSolicitudPersistence.select(preSolicitudFilter);
				//}else {
				listaPreSolicitudes = preSolicitudPersistence.selectOptimizado(preSolicitudFilter);
				LOGGER.error("VALOR ESTATUS BANDERA: "+selectBandera.getVigencia().intValue());
				//	}
			}
			return listaPreSolicitudes;
		}
		catch(Exception ex)
		{
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al consultar PreSolicitud ",
					new Object[] { "PreSolicitudServiceImpl", "consultar()" }, ex));

//			LOGGER.error(mitBusinessException.getMessage(), ex);

			throw mitBusinessException;			
		}
		finally {
			listaPreSolicitudes = null;
			selectBandera= null;
		}
		
	}

	public Boolean actualizarEstatusPorFolioYEstatus(PreSolicitudFilter preSolicitudFilter) throws MitBusinessException {
		try{
			return preSolicitudPersistence.updateNewEstatusByFolioAndEstatus(preSolicitudFilter) > 0;
		}catch(Exception ex){
			MitBusinessException mitBusinessException = new MitBusinessException(GenerateExceptionDetails.generate(
					ErrorCodeService.EX_EXCEPTION, "Al consultar PreSolicitud ",
					new Object[] { getClass().getSimpleName(), "actualizarEstatusPorFolioYEstatus()" }, ex));
	
//			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;			
		}
	}

	
	
}
