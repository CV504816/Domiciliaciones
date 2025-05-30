package mx.profuturo.nci.business.vo;

public class TotalesRegistroDomiVO {
	private String descripcion;
	private String total;
	private String origenAportacion;
	
	public TotalesRegistroDomiVO () {
		
	}
	
	public TotalesRegistroDomiVO ( String descripcion
							     , String total
							     , String origenAportacion) {
		this.descripcion = descripcion;
		this.total = total;
		this.origenAportacion = origenAportacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getOrigenAportacion() {
		return origenAportacion;
	}

	public void setOrigenAportacion(String origenAportacion) {
		this.origenAportacion = origenAportacion;
	}
	

}
