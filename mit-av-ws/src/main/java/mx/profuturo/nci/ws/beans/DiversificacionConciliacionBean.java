package mx.profuturo.nci.ws.beans;

import java.math.BigDecimal;

public class DiversificacionConciliacionBean 
{
	
	private GenericoCatalogoBean fondoApovol;
	private BigDecimal monto;
	private Short porcentaje;
	
	
	public GenericoCatalogoBean getFondoApovol() {
		return fondoApovol;
	}
	public void setFondoApovol(GenericoCatalogoBean fondoApovol) {
		this.fondoApovol = fondoApovol;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Short getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Short porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	



}
