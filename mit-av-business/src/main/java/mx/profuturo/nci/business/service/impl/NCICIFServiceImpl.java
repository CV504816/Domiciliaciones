package mx.profuturo.nci.business.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeveris.core.persistence.exception.PersistenceException;

import mx.profuturo.nci.business.exception.ErrorCodeService;
import mx.profuturo.nci.business.exception.GenerateExceptionDetails;
import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.service.ICIFService;
import mx.profuturo.nci.business.vo.cif.DevolucionesEnvioCifCabeceraVO;
import mx.profuturo.nci.business.vo.cif.DevolucionesEnvioCifDetalleVO;
import mx.profuturo.nci.business.vo.cif.Profuturo_CIFVo;
import mx.profuturo.nci.business.wrapped.NCI_CIFExtVo;
import mx.profuturo.nci.business.wrapped.NCI_CIFFilter;
import mx.profuturo.nci.business.wrapped.cif.Profuturo_CIFFilter;
import mx.profuturo.nci.cif.persistence.ProfuturoCIFPersistence;
import mx.profuturo.nci.persistence.NCICIFPersistence;

@Service("nciCIFPService")
public class NCICIFServiceImpl implements ICIFService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NCICIFServiceImpl.class);
	@Autowired NCICIFPersistence nci_cifPersistence;
	@Autowired ProfuturoCIFPersistence profuturo_cifPersistence;

	@Override
	public List<NCI_CIFExtVo> consultarNCI(NCI_CIFFilter f) throws MitBusinessException {
		try{
			return nci_cifPersistence.select(f);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En consultar NCI CIF:"+ex.getMessage(),
							new Object[] {this.getClass().getName(), "consultarNCI()" }, ex));
			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;
		}
	}

	@Override
	public Integer actualizarNCI(NCI_CIFExtVo vo) throws MitBusinessException {
		try{
			return nci_cifPersistence.update(vo);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En actualizar NCI CIF:"+ex.getMessage(),
							new Object[] { this.getClass().getName(), "actualizarNCI()" }, ex));
			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;
		}
	}

	@Override
	public Integer borrarNCI(NCI_CIFExtVo vo) throws MitBusinessException {
		try{
			return nci_cifPersistence.delete(vo);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION, "En actualizar NCI CIF:"+ex.getMessage(),
							new Object[] { this.getClass().getName(), "actualizarNCI()" }, ex));
			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;
		}
	}	
	
	@Override
	public List<Profuturo_CIFVo> consultarProfuturo(Profuturo_CIFFilter f) throws MitBusinessException{
		try{
			return profuturo_cifPersistence.select(f);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION_CIF_EXT_DATABASE, "En consultar Profuturo CIF:"+ex.getMessage(),
							new Object[] {this.getClass().getName(), "consultarProfuturo()" }, ex));
			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;
		}
	}

	@Override
	public Integer insertarProfuturo(Profuturo_CIFVo vo) throws MitBusinessException {
		try{
			return profuturo_cifPersistence.insert(vo);
		} catch (PersistenceException ex) {
			throw new MitBusinessException(ex.getExceptionDetails());
		} catch (Exception ex) {
			MitBusinessException mitBusinessException = new MitBusinessException(
					GenerateExceptionDetails.generate(ErrorCodeService.EX_EXCEPTION_CIF_EXT_DATABASE, "En consultar Profuturo CIF:"+ex.getMessage(),
							new Object[] {this.getClass().getName(), "insertarProfuturo()" }, ex));
			LOGGER.error(mitBusinessException.getMessage(), ex);
			throw mitBusinessException;
		}
	}

	@Override
	public List<DevolucionesEnvioCifDetalleVO> buscaListaEnvioCIFDetalle(String folio) {
		return nci_cifPersistence.buscaListaEnvioCIFDetalleByFolio(folio);
	}

	@Override
	public List<DevolucionesEnvioCifDetalleVO> buscaListaEnvioCIFDetalle(DevolucionesEnvioCifDetalleVO filtro) {
		return nci_cifPersistence.buscaListaEnvioCIFDetalleByRango(filtro);
	}

	@Override
	public DevolucionesEnvioCifCabeceraVO buscaListaEnvioCIFCabecera(String folio) {
		return nci_cifPersistence.buscaListaEnvioCIFCabeceraByFolio(folio);
	}

	@Override
	public Integer updateDetalleDevCif(DevolucionesEnvioCifDetalleVO data) {
		return nci_cifPersistence.actualizaDetalleDevCif(data);
	}

	@Override
	public Integer updateCabeceraDevCif(DevolucionesEnvioCifDetalleVO data) {
		return nci_cifPersistence.actualizaCabeceraDevCif(data);
	} 
	
	
}
