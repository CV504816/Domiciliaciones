package mx.profuturo.nci.business.vo;


public class ValidacionesVO {

	private boolean estatus;
	private String mensaje;
	private String codigo;
	private Object objetoAux;
	
	
	/**
	 * CONSTRUCTOR VACIO
	 */
	public ValidacionesVO() {
		
	}
	
	/**
	 * CONSTRUCTOR PARA REGRESAR UNA RESPUESTA Y VALIDACION
	 * @param estatus
	 * @param mensaje
	 */
	public ValidacionesVO( boolean estatus, String mensaje ) {
		this.estatus	= estatus;
		this.mensaje	= mensaje;
	}
	
	/**
	 * CONSTRUCTOR PARA REGRESAR UNA RESPUESTA DE VALIDACION Y UN OBJETO AUXILIAR
	 * @param estatus
	 * @param mensaje
	 * @param objetoAux
	 */
	public ValidacionesVO( boolean estatus, String mensaje, Object objetoAux ) {
		this.estatus	= estatus;
		this.mensaje	= mensaje;
		this.objetoAux	= objetoAux;
	}
	
	
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getObjetoAux() {
		return objetoAux;
	}
	public void setObjetoAux(Object objetoAux) {
		this.objetoAux = objetoAux;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ValidacionesVO(String codigo) {
		this.codigo = codigo;
	}
	
}
