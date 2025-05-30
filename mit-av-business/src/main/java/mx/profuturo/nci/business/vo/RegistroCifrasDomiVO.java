package mx.profuturo.nci.business.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"archivoGenerar", "bancoIncluir", "origenAportacion", "totales"})
public class RegistroCifrasDomiVO {
	private String archivoGenerar;
	private String bancoIncluir;
	private String origenAportacion; 
	private List <TotalesRegistroDomiVO> totales;
	
	public RegistroCifrasDomiVO () {
		
	}
	
	public RegistroCifrasDomiVO ( String archivoGenerar
								, String bancoIncluir
								, String origenAportacion
								, List <TotalesRegistroDomiVO> totales) {
		this.archivoGenerar = archivoGenerar;
		this.bancoIncluir = bancoIncluir;
		this.origenAportacion = origenAportacion;
		this.totales = totales;
	}

	public String getArchivoGenerar() {
		return archivoGenerar;
	}

	public void setArchivoGenerar(String archivoGenerar) {
		this.archivoGenerar = archivoGenerar;
	}


	public String getBancoIncluir() {
		return bancoIncluir;
	}

	public void setBancoIncluir(String bancoIncluir) {
		this.bancoIncluir = bancoIncluir;
	}

	public String getOrigenAportacion() {
		return origenAportacion;
	}

	public void setOrigenAportacion(String origenAportacion) {
		this.origenAportacion = origenAportacion;
	}

	@XmlElementWrapper(name = "registrosTotales")
	@XmlElement(name = "registroTotal")
	public List<TotalesRegistroDomiVO> getTotales() {
		return totales;
	}

	public void setTotales(List<TotalesRegistroDomiVO> totales) {
		this.totales = totales;
	}

}
