package mx.profuturo.nci.ws.beans.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class ConciliacionConsultaFolioBeanResponse {
	
	
	private List<String> folios;

	@XmlElementWrapper(name = "folios")
	@XmlElement(name = "folio")
	public List<String> getFolios() {
		return folios;
	}

	public void setFolios(List<String> folios) {
		this.folios = folios;
	}
	
}
