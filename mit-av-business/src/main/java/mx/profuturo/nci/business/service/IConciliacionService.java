package mx.profuturo.nci.business.service;

import java.util.List;

import com.jeveris.core.exception.impl.BusinessException;

import mx.profuturo.nci.business.exception.MitBusinessException;
import mx.profuturo.nci.business.vo.ConciliacionVO;
import mx.profuturo.nci.business.vo.OrdenesVO;
import mx.profuturo.nci.business.wrapped.ConciliacionFilter;

public interface IConciliacionService 
{
	
	public Boolean insertar(ConciliacionVO conciliacionVO)throws MitBusinessException;
	public Boolean actualizar(ConciliacionVO conciliacionVO) throws MitBusinessException;
	public List<ConciliacionVO> consultar(ConciliacionFilter conciliacionFilter) throws MitBusinessException;
	List<ConciliacionVO> consultarBasica(ConciliacionFilter conciliacionFilter) throws MitBusinessException;
	public Integer consultarCuantosRegistros(ConciliacionFilter conciliacionFilter) throws MitBusinessException;

	public boolean conciliarTotales(String usuario, String folioConciliacion) throws BusinessException;
	public int actualizarConciliado(List<ConciliacionVO> conciliacionVO) throws BusinessException;
	Long getIdPagoApovol() throws BusinessException;
	
	/**
	 * Metodo para conciliar la orden spei y la conciliacion
	 * 
	 * @param conciliacion
	 * @param orden
	 * @throws MitBusinessException
	 */
	public void conciliarOrdenSpei(ConciliacionVO conciliacion, OrdenesVO orden) throws MitBusinessException;
	List<String> consultarFolios(ConciliacionFilter conciliacionFilter) throws MitBusinessException;
	
	public int actualizarEstatusConciliacion(Integer idConciliacion, Short estatus, String usuario) throws MitBusinessException;
}