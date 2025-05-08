package mx.profuturo.nci.ws.util;

import java.util.HashMap;
import java.util.Map;

import mx.profuturo.nci.business.vo.BancosVO;
import mx.profuturo.nci.business.vo.FolioBancoVO;
import mx.profuturo.nci.business.vo.ConciliacionVO;
import mx.profuturo.nci.business.vo.DiversificacionConciliacionVO;
import mx.profuturo.nci.business.vo.DiversificacionOrdenesVO;
import mx.profuturo.nci.business.vo.DiversificacionVO;
import mx.profuturo.nci.business.vo.ElementoVO;
import mx.profuturo.nci.business.vo.FrecuenciaVO;
import mx.profuturo.nci.business.vo.GenericCatalogoVO;
import mx.profuturo.nci.business.vo.OrdenesVO;
import mx.profuturo.nci.business.vo.PreSolicitudVO;
import mx.profuturo.nci.business.vo.PrincipalVO;
import mx.profuturo.nci.business.vo.SeccionVO;
import mx.profuturo.nci.business.vo.SolicitudVO;
import mx.profuturo.nci.business.vo.SumConciliacionVO;
import mx.profuturo.nci.ws.beans.ClaveSolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.ConciliacionBean;
import mx.profuturo.nci.ws.beans.DiversificacionBean;
import mx.profuturo.nci.ws.beans.DiversificacionConciliacionBean;
import mx.profuturo.nci.ws.beans.DiversificacionOrdenAportacionBean;
import mx.profuturo.nci.ws.beans.DiversificacionPreSolBean;
import mx.profuturo.nci.ws.beans.ElementoBean;
import mx.profuturo.nci.ws.beans.FrecuenciaBean;
import mx.profuturo.nci.ws.beans.GenericoCatalogoBean;
import mx.profuturo.nci.ws.beans.MovBancoBean;
import mx.profuturo.nci.ws.beans.FolioBancoBean;
import mx.profuturo.nci.ws.beans.OrdenAportacionBean;
import mx.profuturo.nci.ws.beans.PreSolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.PrincipalBean;
import mx.profuturo.nci.ws.beans.SeccionBean;
import mx.profuturo.nci.ws.beans.SolicitudDomiciliacionBean;
import mx.profuturo.nci.ws.beans.SumConciliacionBean;

@SuppressWarnings("rawtypes")
public enum BeanMap 
{
	
	GENERIC_CATALOGO(GenericoCatalogoBean.class, GenericCatalogoVO.class,
			new HashMap<String, String>() 
			{
				private static final long serialVersionUID = 1L;
				{
					put(ATTRIBUTE_CAT_GENERICO_ID,ATTRIBUTE_CAT_GENERICO_ID);
					put(ATTRIBUTE_CAT_GENERICO_VALOR,ATTRIBUTE_CAT_GENERICO_VALOR);
			
				}
			}),			
	 FRECUENCIA(FrecuenciaBean.class, FrecuenciaVO.class,
				new HashMap<String, String>() 
				{
						private static final long serialVersionUID = 1L;
						{
							put("dia","dia");
						}
				}),	
	 CLAVE_SOLICITUD(ClaveSolicitudDomiciliacionBean.class, SolicitudVO.class,
				new HashMap<String, String>() 
				{
					private static final long serialVersionUID = 1L;
					{
						put("claveSolicitud","claveSolicitud");						
					}
				}),
	SOLICITUD(SolicitudDomiciliacionBean.class, SolicitudVO.class,
			new HashMap<String, String>() 
			{
				private static final long serialVersionUID = 1L;
				{
					put("claveSolicitud","claveSolicitud");
					put("folio","folio");
					put("numCuentaIndividual","numCuentaIndividual");
					put("cuentaBanco","cuentaBanco");
//					put("claveBanco","claveBanco");
					put("clienteNombre","clienteNombre");
					put("clientePaterno","clientePaterno");
					put("clienteMaterno","clienteMaterno");
					put("correoElectronico","correoElectronico");
					put("curp","curp");
					put("nss","nss");
					put("clienteRfc","clienteRfc");
					put("fechaCargo","fechaCargo");
					put("fechaProximoCargo","fechaProximoCargo");
					put("fechaCargaResp","fechaCargaResp");
					put("fechaReactivacion","fechaReactivacion");
					put("fechaCaptura","fechaCaptura");
					put("importe","importe");
					put("incrementabilidad","incrementabilidad");
					put("opcionIncrementabilidad","opcionIncrementabilidad");
					put("montoIncremento","montoIncremento");
					put("intentos","intentos");
					put("fechaEstatuSolicitud","fechaEstatuSolicitud");
					put("celular","celular");
					put("fechaActualizacion","fechaActualizacion");
					put("fechaCreacion","fechaCreacion");
					put("usuarioActualizacion","usuarioActualizacion");
					put("usuarioCreacion","usuarioCreacion");
					put("numCargo","numCargo");
					put("fechaSuspension","fechaSuspension");
					put("origenSolAfom","origenSolAfom");
					put("vigenciaTc","vigenciaTc");
					put("folioProcesar","folioProcesar");
					put("curpTutor","curpTutor");
					put("folioFamilia","folioFamilia");
					put("gerencia","gerencia");
					put("promotor","promotor");
					put("regional","regional");
					put("tipoRegistro","tipoRegistro");
					put("tutor","tutor");					
					put("paternoTutor","paternoTutor");
					put("maternoTutor","maternoTutor");
				}
			}),
	DIVERSIFICACION(DiversificacionBean.class, DiversificacionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("folio","folio");
						put("monto","monto");
						put("porcentaje","porcentaje");
					}
			}),
	DIVERSIFICACION_PRE_SOLICITUD(DiversificacionPreSolBean.class, DiversificacionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("folio","folio");
						put("monto","monto");
						put("porcentaje","porcentaje");
					}
			}),			
	PERSOLICITUD(PreSolicitudDomiciliacionBean.class, PreSolicitudVO.class,
				new HashMap<String, String>() 
				{
						private static final long serialVersionUID = 1L;
						{
							put("claveSolicitud","claveSolicitud");
							put("folio","folio");
							put("numCuentaIndividual","numCuentaIndividual");
							put("cuentaBanco","cuentaBanco");
//							put("claveBanco","claveBanco");
							put("clienteNombre","clienteNombre");
							put("clientePaterno","clientePaterno");
							put("clienteMaterno","clienteMaterno");
							put("correoElectronico","correoElectronico");
							put("curp","curp");
							put("nss","nss");
							put("clienteRfc","clienteRfc");
							put("fechaCaptura","fechaCaptura");
							put("importe","importe");
							put("incrementabilidad","incrementabilidad");
							put("opcionIncrementabilidad","opcionIncrementabilidad");
							put("montoIncremento","montoIncremento");
							put("banderaDocumentos","banderaDocumentos");	
							put("celular","celular");	
							put("fechaCargo","fechaCargo");
							put("fechaEstatuSolicitud","fechaEstatuSolicitud");
							put("fechaActualizacion","fechaActualizacion");
							put("fechaCreacion","fechaCreacion");
							put("usuarioActualizacion","usuarioActualizacion");
							put("usuarioCreacion","usuarioCreacion");
							put("origenSolAfom","origenSolAfom");
							put("vigenciaTc","vigenciaTc");
							put("folioProcesar","folioProcesar");
							put("curpTutor","curpTutor");
							put("folioFamilia","folioFamilia");
							put("gerencia","gerencia");
							put("promotor","promotor");
							put("regional","regional");
							put("tipoRegistro","tipoRegistro");
							put("tutor","tutor");
							put("paternoTutor","paternoTutor");
							put("maternoTutor","maternoTutor");
							
						}
				}),
	CONCILIACION(ConciliacionBean.class, ConciliacionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("idConciliacion","idConciliacion");
						put("folio","folio");
						put("claveSolicitud","claveSolicitud");
						put("numeroOrden","numeroOrden");
//						put("numeroCuentaIndividual","numeroCuentaIndividual");
						put("numeroPago","numeroPago");
//						put("claveBanco","claveBanco");
						put("cuentaBanco","cuentaBanco");
						put("importe","importe");
						put("referenciaSubcuentaApovol","referenciaSubcuentaApovol");
						put("fechaCargaArchivo","fechaCargaArchivo");
						put("nombreCliente","nombreCliente");
						put("apellidoClientePaterno","apellidoClientePaterno");
						put("apellidoClienteMaterno","apellidoClienteMaterno");
						put("curp","curp");
						put("rfc","rfc");
//						put("nss","nss");
						put("correoElectronico","correoElectronico");
//						put("celular","celular");
						put("numeroEmpleado","numeroEmpleado");
						put("fechaPagoApovol","fechaPagoApovol");
						put("fechaValorApovol","fechaValorApovol");
						put("folioTransaccion","folioTransaccion");
						put("folioProcesar","folioProcesar");
						put("sucursal","sucursal");
						put("tipoAportacion","tipoAportacion");
						put("registroConciliado","registroConciliado");
						put("movimientoGenerado","movimientoGenerado");
						put("movimiento","movimiento");						
						put("fechaCreacion","fechaCreacion");
						put("fechaActualizacion","fechaActualizacion");
						
						put("nombreOrdenante","nombreOrdenante");
						put("rfcOrdenante","rfcOrdenante");
						put("curpOrdenante","curpOrdenante");
						
						put("tipoAhorrador","tipoAhorrador");
						put("fechaConciliacion","fechaConciliacion");
						put("fechaActualizacionFondo","fechaActualizacionFondo");
						put("usuarioActualizacionFondo","usuarioActualizacionFondo");
						put("folioConciliacion","folioConciliacion");
						
					}
			}),
	DIVERSIFICACION_CONCILIACION(DiversificacionConciliacionBean.class, DiversificacionConciliacionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("monto","monto");
						put("porcentaje","porcentaje");
					}
			}),
	MOVIMIENTOS_BANCOS(MovBancoBean.class, BancosVO.class,
			new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;
					{
						put("folio","folio");
						put("idBanco","idBanco");
//						put("folioRelacionado","folioRelacionado");
						put("referenciaCuenta","cuenta");
						put("autorizacionBanco","autBanco");
						put("importe","importe");
						put("fechaCarga","fechaCarga");
						put("numCuentaIndividual","numCuentaIndividual");
						put("curp","curp");
						put("regConciliado","regConciliado");
						
						
					}
			}),
	FOLIOS_BANCO(FolioBancoBean.class, FolioBancoVO.class,
			new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;
					{
						put("folio","folio");
						put("fechaCreacion","fechaCreacion");
						put("usuarioCreacion","usuarioCreacion");
						put("fechaActualizacion","fechaActualizacion");
						put("usuarioActualizacion","usuarioActualizacion");
					}
			}),
	SUM_CONCILIACION(SumConciliacionBean.class, SumConciliacionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("folio","folio");
						put("importe","importe");
						put("regConciliado","regConciliado");
						
						
					}
			}),
	ELEMENTOS(ElementoBean.class, ElementoVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("nombreElemento","nombreElemento");
						put("importe","importe");
						put("registros","registros");
						put("estatus","estatus");
						put("fecha","fecha");
						put("banco","banco");
						put("archivoOrigen","archivoOrigen");
					}
			}),
	SECCIONES(SeccionBean.class, SeccionVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("nombreSeccion","nombreSeccion");
						
					}
			}),			
	ORDENES_APORTACION(OrdenAportacionBean.class, OrdenesVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("numeroOrden","numeroOrden");
						put("numCuentaIndividual","numCuentaIndividual");
						put("importe","importe");
					}
			}),
	DIVERSIFICACION_ORDEN_APORTACION(DiversificacionOrdenAportacionBean.class, DiversificacionOrdenesVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("monto","monto");
						put("porcentaje","porcentaje");
					}
			}),			
	PRINCIPAL(PrincipalBean.class, PrincipalVO.class,
			new HashMap<String, String>() 
			{
					private static final long serialVersionUID = 1L;
					{
						put("idConciliacion","idConciliacion");
						put("folio","folio");
						put("cveSolicitud","cveSolicitud");
						put("noOrden","noOrden");
						put("numCtaInvdual","numCtaInvdual");
						put("noPago","noPago");
						put("ctaBanco","ctaBanco");
						put("importe","importe");
						put("fechaCargaArchivo","fechaCargaArchivo");
						put("nombre","nombre");
						put("apPaterno","apPaterno");
						put("apMaterno","apMaterno");
						put("curp","curp");
						put("rfc","rfc");
						put("nss","nss");
						put("correo","correo");
						put("celular","celular");
						put("noEmpleado","noEmpleado");
						put("fechaPagoApovol","fechaPagoApovol");
						put("fechaValorApovol","fechaValorApovol");
						put("folioTransaccion","folioTransaccion");
						put("folioProcesar","folioProcesar");
						put("idSucursal","idSucursal");
						put("tipoAportacion","tipoAportacion");
						put("regAcreditado","regAcreditado");
						put("identificadorMov","identificadorMov");
						put("fechaCreacion","fechaCreacion");
						put("usuarioCreacion","usuarioCreacion");
						put("fechaActualizacion","fechaActualizacion");
						put("usuarioActualizacion","usuarioActualizacion");
						put("idInstancia","idInstancia");
					}
			}),
			
	;
	
	/*
	 * >>>>>>>>>>> VARIABLES ESTATICAS <<<<<<<<<<<<<<<<
	 fop 05/09/2018 Time Out mybatis
	 */

	
	private static final String ATTRIBUTE_CAT_GENERICO_ID = "id";
	private static final String ATTRIBUTE_CAT_GENERICO_VALOR = "valor";
	

	private Class claseBean;
	private Class claseVo;
	private Map<String, String> mapaPropiedades;

	private BeanMap(Class claseBean, Class claseVo,
			Map<String, String> mapaPropiedades) {
		this.claseBean = claseBean;
		this.claseVo = claseVo;
		this.mapaPropiedades = mapaPropiedades;
	}

	public static BeanMap getBeanMapOf(Class claseBean, Class claseVO) {

		for (BeanMap map : values()) {
			if (map.getClaseBean().equals(claseBean)
					&& map.getClaseVo().equals(claseVO)) {
				return map;
			}
		}
		return null;
	}

	public Class getClaseBean() {
		return claseBean;
	}

	public Class getClaseVo() {
		return claseVo;
	}

	public Map<String, String> getMapaPropiedades() {
		return mapaPropiedades;
	}

}
