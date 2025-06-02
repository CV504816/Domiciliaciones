package mx.profuturo.nci.ws.beans.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import mx.profuturo.nci.business.util.UtilValidate;
import mx.profuturo.nci.business.vo.PeticionDomiciliacionVO;
import mx.profuturo.nci.business.vo.ValidacionesVO;

@XmlType(propOrder={"fechaInicio","fechaFin", "usuario", "folio", "peticiones"})
public class PeticionesDomiBeanRequest {
	private String fechaInicio;
	private String fechaFin;
	private String usuario;
	private String folio;
	private List <PeticionDomiciliacionVO> peticiones;
	
	public PeticionesDomiBeanRequest () {
		
	}
	
	public PeticionesDomiBeanRequest ( String fechaInicio
								 	 , String fechaFin
								 	 , String usuario
								 	 , List <PeticionDomiciliacionVO> peticiones) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.peticiones = peticiones;
	}
	
	public PeticionesDomiBeanRequest ( String fechaInicio
								 	 , String fechaFin
								 	 , String usuario
								 	 , List <PeticionDomiciliacionVO> peticiones
								 	 , String folio) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.peticiones = peticiones;
		this.folio = folio;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	@XmlElementWrapper(name = "peticiones")
	@XmlElement(name = "peticion")
	public List<PeticionDomiciliacionVO> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(List<PeticionDomiciliacionVO> peticiones) {
		this.peticiones = peticiones;
	}
	
	public ValidacionesVO validarRequestCifras() {
		
		
		if( !UtilValidate.validarFechaPorFormatoF4( this.fechaInicio , "dd/MM/yyyy") ) {
			return new ValidacionesVO( Boolean.FALSE, "fechaInicio, validar formato dd/MM/yyyy" );
		}
		
		if( !UtilValidate.validarFechaPorFormatoF4( this.fechaFin , "dd/MM/yyyy") ) {
			return new ValidacionesVO( Boolean.FALSE, "fechaFin, validar formato dd/MM/yyyy" );
		}
		
		if (this.peticiones == null || this.peticiones.isEmpty()) {
			return new ValidacionesVO( Boolean.FALSE, "peticiones, por favor ingrese 'peticiones' " );
		}
		
		if (this.usuario == null || this.usuario.isEmpty()) {
			return new ValidacionesVO( Boolean.FALSE, "peticiones, por favor ingrese 'usuario' " );
		}
		
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}
	
	public ValidacionesVO validarRequestArchivosDomi() {
		
		
		if( !UtilValidate.validarFechaPorFormatoF4( this.fechaInicio , "dd/MM/yyyy") ) {
			return new ValidacionesVO( Boolean.FALSE, "fechaInicio, validar formato dd/MM/yyyy" );
		}
		
		if( !UtilValidate.validarFechaPorFormatoF4( this.fechaFin , "dd/MM/yyyy") ) {
			return new ValidacionesVO( Boolean.FALSE, "fechaFin, validar formato dd/MM/yyyy" );
		}
		
		if (this.peticiones == null || this.peticiones.isEmpty()) {
			return new ValidacionesVO( Boolean.FALSE, "peticiones, por favor ingrese 'peticiones' " );
		}
		
		if (this.usuario == null || this.usuario.isEmpty()) {
			return new ValidacionesVO( Boolean.FALSE, "peticiones, por favor ingrese 'usuario' " );
		}
		
		if (!UtilValidate.validaFormatoIntegerF4(this.folio, 20)) {
			return new ValidacionesVO( Boolean.FALSE, "Validar formato de folio, LONG MAX 20" );
		}
			
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}
	

}
