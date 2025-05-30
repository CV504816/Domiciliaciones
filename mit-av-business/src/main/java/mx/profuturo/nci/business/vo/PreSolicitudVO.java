package mx.profuturo.nci.business.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PreSolicitudVO extends AbstractAuditoriaVO 
{
	private String claveSolicitud;
	private String folio;
	private Long numCuentaIndividual;
	private GenericCatalogoVO lineaNegocio;
	private GenericCatalogoVO origenSolicitud;
	private String cuentaBanco;
	private GenericCatalogoVO tipoCuenta;
	private GenericCatalogoVO claveBanco;
	private String clienteNombre;
	private String clientePaterno;
	private String clienteMaterno;
	private String correoElectronico;
	private String curp;
	private String nss;
	private String clienteRfc;
	private GenericCatalogoVO periodo;
	private FrecuenciaVO frecuenciaInicial;
	private FrecuenciaVO frecuenciaFinal;
	private GenericCatalogoVO estatusSolicitud;
	private GenericCatalogoVO rechazoSolicitud;
	private Date fechaCaptura;
	private BigDecimal importe;
	private Short incrementabilidad;	
	private Short opcionIncrementabilidad;	
	private GenericCatalogoVO porcentajeIncremento;	
	private BigDecimal montoIncremento;	
	private GenericCatalogoVO periodoIncrementabilidad;
	private Short banderaDocumentos;
	private GenericCatalogoVO moneda;
	private Long celular;
	private GenericCatalogoVO companiaCelular;
	private Date fechaCargo;
	private Date fechaEstatuSolicitud;

	private GenericCatalogoVO medioNotificacion;
	private List<DiversificacionVO> diversificaciones;
	
	private String origenSolAfom;
	private String vigenciaTc;
	
	private String folioProcesar;
	
	
	private String curpTutor;
	private String folioFamilia;
	//FOP Domi Registro 25/06/2018
	private String gerencia;
	private String promotor;
	private String regional;
	private Integer tipoRegistro;
	private String tutor;
	private String paternoTutor;
	private String maternoTutor;
	//validar vigencia BANDERA
	private Integer vigencia;
	
	public GenericCatalogoVO getMedioNotificacion() {
		return medioNotificacion;
	}
	public void setMedioNotificacion(GenericCatalogoVO medioNotificacion) {
		this.medioNotificacion = medioNotificacion;
	}
	public String getClaveSolicitud() {
		return claveSolicitud;
	}
	public void setClaveSolicitud(String claveSolicitud) {
		this.claveSolicitud = claveSolicitud;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public Long getNumCuentaIndividual() {
		return numCuentaIndividual;
	}
	public void setNumCuentaIndividual(Long numCuentaIndividual) {
		this.numCuentaIndividual = numCuentaIndividual;
	}
	public GenericCatalogoVO getLineaNegocio() {
		return lineaNegocio;
	}
	public void setLineaNegocio(GenericCatalogoVO lineaNegocio) {
		this.lineaNegocio = lineaNegocio;
	}
	public GenericCatalogoVO getOrigenSolicitud() {
		return origenSolicitud;
	}
	public void setOrigenSolicitud(GenericCatalogoVO origenSolicitud) {
		this.origenSolicitud = origenSolicitud;
	}
	public String getCuentaBanco() {
		return cuentaBanco;
	}
	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}
	public GenericCatalogoVO getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(GenericCatalogoVO tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public GenericCatalogoVO getClaveBanco() {
		return claveBanco;
	}
	public void setClaveBanco(GenericCatalogoVO claveBanco) {
		this.claveBanco = claveBanco;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public String getClientePaterno() {
		return clientePaterno;
	}
	public void setClientePaterno(String clientePaterno) {
		this.clientePaterno = clientePaterno;
	}
	public String getClienteMaterno() {
		return clienteMaterno;
	}
	public void setClienteMaterno(String clienteMaterno) {
		this.clienteMaterno = clienteMaterno;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getClienteRfc() {
		return clienteRfc;
	}
	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}
	public GenericCatalogoVO getPeriodo() {
		return periodo;
	}
	public void setPeriodo(GenericCatalogoVO periodo) {
		this.periodo = periodo;
	}
	public FrecuenciaVO getFrecuenciaInicial() {
		return frecuenciaInicial;
	}
	public void setFrecuenciaInicial(FrecuenciaVO frecuenciaInicial) {
		this.frecuenciaInicial = frecuenciaInicial;
	}
	public FrecuenciaVO getFrecuenciaFinal() {
		return frecuenciaFinal;
	}
	public void setFrecuenciaFinal(FrecuenciaVO frecuenciaFinal) {
		this.frecuenciaFinal = frecuenciaFinal;
	}
	public GenericCatalogoVO getEstatusSolicitud() {
		return estatusSolicitud;
	}
	public void setEstatusSolicitud(GenericCatalogoVO estatusSolicitud) {
		this.estatusSolicitud = estatusSolicitud;
	}
	public GenericCatalogoVO getRechazoSolicitud() {
		return rechazoSolicitud;
	}
	public void setRechazoSolicitud(GenericCatalogoVO rechazoSolicitud) {
		this.rechazoSolicitud = rechazoSolicitud;
	}
	public Date getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Short getIncrementabilidad() {
		return incrementabilidad;
	}
	public void setIncrementabilidad(Short incrementabilidad) {
		this.incrementabilidad = incrementabilidad;
	}
	public Short getOpcionIncrementabilidad() {
		return opcionIncrementabilidad;
	}
	public void setOpcionIncrementabilidad(Short opcionIncrementabilidad) {
		this.opcionIncrementabilidad = opcionIncrementabilidad;
	}
	public GenericCatalogoVO getPorcentajeIncremento() {
		return porcentajeIncremento;
	}
	public void setPorcentajeIncremento(GenericCatalogoVO porcentajeIncremento) {
		this.porcentajeIncremento = porcentajeIncremento;
	}
	public GenericCatalogoVO getPeriodoIncrementabilidad() {
		return periodoIncrementabilidad;
	}
	public void setPeriodoIncrementabilidad(
			GenericCatalogoVO periodoIncrementabilidad) {
		this.periodoIncrementabilidad = periodoIncrementabilidad;
	}
	public Short getBanderaDocumentos() {
		return banderaDocumentos;
	}
	public void setBanderaDocumentos(Short banderaDocumentos) {
		this.banderaDocumentos = banderaDocumentos;
	}
	public GenericCatalogoVO getMoneda() {
		return moneda;
	}
	public void setMoneda(GenericCatalogoVO moneda) {
		this.moneda = moneda;
	}
	public List<DiversificacionVO> getDiversificaciones() {
		return diversificaciones;
	}
	public void setDiversificaciones(List<DiversificacionVO> diversificaciones) {
		this.diversificaciones = diversificaciones;
	}
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}
	public BigDecimal getMontoIncremento() {
		return montoIncremento;
	}
	public void setMontoIncremento(BigDecimal montoIncremento) {
		this.montoIncremento = montoIncremento;
	}
	public Date getFechaCargo() {
		return fechaCargo;
	}
	public void setFechaCargo(Date fechaCargo) {
		this.fechaCargo = fechaCargo;
	}
	public Date getFechaEstatuSolicitud() {
		return fechaEstatuSolicitud;
	}
	public void setFechaEstatuSolicitud(Date fechaEstatuSolicitud) {
		this.fechaEstatuSolicitud = fechaEstatuSolicitud;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long celular) {
		this.celular = celular;
	}
	public GenericCatalogoVO getCompaniaCelular() {
		return companiaCelular;
	}
	public void setCompaniaCelular(GenericCatalogoVO companiaCelular) {
		this.companiaCelular = companiaCelular;
	}
	public String getOrigenSolAfom() {
		return origenSolAfom;
	}
	public void setOrigenSolAfom(String origenSolAfom) {
		this.origenSolAfom = origenSolAfom;
	}
	public String getVigenciaTc() {
		return vigenciaTc;
	}
	public void setVigenciaTc(String vigenciaTc) {
		this.vigenciaTc = vigenciaTc;
	}
	public String getFolioProcesar() {
		return folioProcesar;
	}
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}
	public String getCurpTutor() {
		return curpTutor;
	}
	public void setCurpTutor(String curpTutor) {
		this.curpTutor = curpTutor;
	}
	public String getFolioFamilia() {
		return folioFamilia;
	}
	public void setFolioFamilia(String folioFamilia) {
		this.folioFamilia = folioFamilia;
	}
	
	public String getGerencia() {
		return gerencia;
	}
	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}
	public String getPromotor() {
		return promotor;
	}
	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}
	public String getRegional() {
		return regional;
	}
	public void setRegional(String regional) {
		this.regional = regional;
	}
	public Integer getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	public String getPaternoTutor() {
		return paternoTutor;
	}
	public void setPaternoTutor(String paternoTutor) {
		this.paternoTutor = paternoTutor;
	}
	public String getMaternoTutor() {
		return maternoTutor;
	}
	public void setMaternoTutor(String maternoTutor) {
		this.maternoTutor = maternoTutor;
	}
	
	
	public Integer getVigencia() {
		return vigencia;
	}
	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)				
				.append("claveSolicitud", claveSolicitud)
				.append("folio", folio)
				.append("numCuentaIndividual", numCuentaIndividual)
				.append("lineaNegocio", lineaNegocio)
				.append("origenSolicitud", origenSolicitud)
				.append("cuentaBanco", cuentaBanco)
				.append("tipoCuenta", tipoCuenta)
				.append("claveBanco", claveBanco)
				.append("clienteNombre", clienteNombre)
				.append("clientePaterno", clientePaterno)
				.append("clienteMaterno", clienteMaterno)
				.append("correoElectronico", correoElectronico)
				.append("curp", curp)
				.append("nss", nss)
				.append("clienteRfc", clienteRfc)
				.append("periodo", periodo)
				.append("frecuenciaInicial", frecuenciaInicial)
				.append("frecuenciaFinal", frecuenciaFinal)
				.append("estatusSolicitud", estatusSolicitud)
				.append("rechazoSolicitud", rechazoSolicitud)
				.append("fechaCaptura", fechaCaptura)
				.append("importe", importe)
				.append("incrementabilidad", incrementabilidad)
				.append("opcionIncrementabilidad", opcionIncrementabilidad)
				.append("porcentajeIncremento", porcentajeIncremento)
				.append("montoIncremento", montoIncremento)
				.append("periodoIncrementabilidad", periodoIncrementabilidad)
				.append("banderaDocumentos", banderaDocumentos)
				.append("moneda", moneda)
				.append("diversificaciones", diversificaciones)
				.append("origenSolAfom",origenSolAfom)
				.append("vigenciaTc",vigenciaTc)
				.append("gerencia",gerencia)
				.append("promotor",promotor)
				.append("regional",regional)
				.append("tipoRegistro",tipoRegistro)
				.append("tutor",tutor)
				.append("paternoTutor",paternoTutor)
				.append("maternoTutor",maternoTutor)
				.appendSuper(super.toString())
				.toString();
	}

	
}
