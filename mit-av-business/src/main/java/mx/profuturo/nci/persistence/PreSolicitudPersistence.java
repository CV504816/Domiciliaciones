package mx.profuturo.nci.persistence;

import java.util.List;

import mx.profuturo.nci.business.vo.PreSolicitudVO;
import mx.profuturo.nci.business.wrapped.PreSolicitudFilter;
import mx.profuturo.nci.stereotype.Mapper;

@Mapper
public interface PreSolicitudPersistence 
{

	public int insert(PreSolicitudVO preSolicitudVO);
	
	public int actualizar(PreSolicitudVO preSolicitudVO);
	public int updateNewEstatusByFolioAndEstatus(PreSolicitudFilter preSolicitudFilter);
	
	public List<PreSolicitudVO> select(PreSolicitudFilter preSolicitudFilter);
	public PreSolicitudVO selectBandera();
	public List<PreSolicitudVO> selectOptimizado(PreSolicitudFilter preSolicitudFilter);
}
