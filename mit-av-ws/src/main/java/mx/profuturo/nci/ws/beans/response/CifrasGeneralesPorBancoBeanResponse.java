package mx.profuturo.nci.ws.beans.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import mx.profuturo.nci.ws.beans.CifrasGeneralesBean;

public class CifrasGeneralesPorBancoBeanResponse {
	
	private List<CifrasGeneralesBean> cifrasGenerales;
	
	public CifrasGeneralesPorBancoBeanResponse(){}
	
	public CifrasGeneralesPorBancoBeanResponse(List<CifrasGeneralesBean> cifrasGenerales){
		
		super();
		this.cifrasGenerales = cifrasGenerales;
	}

	@XmlElementWrapper(name = "cifrasGenerales")
	@XmlElement(name = "cifraGeneral")
	public List<CifrasGeneralesBean> getCifrasGenerales() {
		return cifrasGenerales;
	}

	public void setCifrasGenerales(List<CifrasGeneralesBean> cifrasGenerales) {
		this.cifrasGenerales = cifrasGenerales;
	}

}
