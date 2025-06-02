package mx.profuturo.nci.business.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"cveBancoIncluir", "archivoGenenerar", "archivoUnico"})
public class PeticionDomiciliacionVO {
	private String cveBancoIncluir;
	private String archivoGenenerar;
	private boolean archivoUnico;
	
	public PeticionDomiciliacionVO () {
		
	}
	
	public PeticionDomiciliacionVO ( String cveBancoIncluir
								   , String archivoGenenerar
								   , boolean archivoUnico) {
		this.cveBancoIncluir = cveBancoIncluir;
		this.archivoGenenerar = archivoGenenerar;
		this.archivoUnico = archivoUnico;
	}

	public String getCveBancoIncluir() {
		return cveBancoIncluir;
	}

	public void setCveBancoIncluir(String cveBancoIncluir) {
		this.cveBancoIncluir = cveBancoIncluir;
	}

	public String getArchivoGenenerar() {
		return archivoGenenerar;
	}

	public void setArchivoGenenerar(String archivoGenenerar) {
		this.archivoGenenerar = archivoGenenerar;
	}

	public boolean isArchivoUnico() {
		return archivoUnico;
	}

	public void setArchivoUnico(boolean archivoUnico) {
		this.archivoUnico = archivoUnico;
	}
	
	
}
