package mx.profuturo.nci.business.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"archivoGenerar", "bancoIncluir", "origenAportacion", "totales", "descripcion"})
public class RegistroCifrasDomiVO {
	private String archivoGenerar;
	private String bancoIncluir;
	private String origenAportacion;
	private List <TotalesRegistroDomiVO> totales;
	private String descripcion;
	
	public RegistroCifrasDomiVO () {
		
	}
	
	public RegistroCifrasDomiVO ( String archivoGenerar
								, String bancoIncluir
								, String origenAportacion
								, List <TotalesRegistroDomiVO> totales
								, String descripcion) {
		this.archivoGenerar = archivoGenerar;
		this.bancoIncluir = bancoIncluir;
		this.origenAportacion = origenAportacion;
		this.totales = totales;
		this.descripcion = descripcion;
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
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
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