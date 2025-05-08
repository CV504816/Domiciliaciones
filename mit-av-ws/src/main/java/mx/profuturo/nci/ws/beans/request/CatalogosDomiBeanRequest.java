package mx.profuturo.nci.ws.beans.request;

import mx.profuturo.nci.business.util.UtilValidate;
import mx.profuturo.nci.business.vo.ValidacionesVO;

public class CatalogosDomiBeanRequest {
	private String tipoCatalogo;
	
	public CatalogosDomiBeanRequest () {
		
	}
	
	/**
	 * CONSTRUCTOR SOBRECARGA
	 * @param tipoCatalogo
	 */
	public CatalogosDomiBeanRequest (String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
	

	public String getTipoCatalogo() {
		return tipoCatalogo;
	}

	public void setTipoCatalogo(String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
	
	public ValidacionesVO validarRequest() {
		if( !UtilValidate.validaFormatoIntegerF4(this.tipoCatalogo, 2) ) {
			return new ValidacionesVO( Boolean.FALSE, "Validar formato tipoCatalogo, LONG MAX 2" );
		}
		
		return new ValidacionesVO( Boolean.TRUE , "Validacion exitosa." );
	}

}
