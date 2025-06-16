package mx.profuturo.nci.ws.beans.request;

import mx.profuturo.nci.business.util.UtilValidate;
import mx.profuturo.nci.business.vo.ValidacionesVO;

public class UltimosArchivosGeneradosBeanRequest {
	private String cuentasIncluir;
	private String archivoGenerar;
	
	public UltimosArchivosGeneradosBeanRequest() {
		
	}
	
	public UltimosArchivosGeneradosBeanRequest( String cuentasIncluir
											  , String archivoGenerar) {
		this.cuentasIncluir = cuentasIncluir;
		this.archivoGenerar = archivoGenerar;
	}

	public ValidacionesVO validarOrigenAportacion() {
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}
	
	public ValidacionesVO validarCuentasIncluir() {
		if( !UtilValidate.validaFormatoIntegerF4(this.cuentasIncluir, 5) ) {
			return new ValidacionesVO( Boolean.FALSE, "Validar formato cuentasIncluir, LONG MAX 5" );
		}
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}
	public ValidacionesVO validarArchivoGenerar() {
		if( !UtilValidate.validaFormatoIntegerF4(this.archivoGenerar, 5) ) {
			return new ValidacionesVO( Boolean.FALSE, "Validar formato archivoGenerar, LONG MAX 5" );
		}
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}
	

	public String getCuentasIncluir() {
		return cuentasIncluir;
	}

	public void setCuentasIncluir(String cuentasIncluir) {
		this.cuentasIncluir = cuentasIncluir;
	}

	public String getArchivoGenerar() {
		return archivoGenerar;
	}

	public void setArchivoGenerar(String archivoGenerar) {
		this.archivoGenerar = archivoGenerar;
	}
	
	

}
