package mx.profuturo.nci.business.util;

public interface ConstantesCatalogos {
	
	public static final String TEMPORAL_SCHEMA_NAME_CIERREN="CIERREN.";
	//  IDs TIPO DE CATALOGO
	public static final Short ID_PROCESO_OPERATIVO 		= 2;
	public static final Short ID_SUBPROCESO_OPERATIVO 	= 3;
	public static final Short ID_TIPO_MOVIMIENTO 		= 25;
	public static final Short ID_FAMILIA_SUBCUENTA 		= 23;
	public static final Short ID_SUBCUENTA 				= 24;
	public static final Short ID_ETAPA_NCI 				= 7;
	public static final Short ID_ETAPA_NCI_OPERACION	= 20;
	public static final Short ID_ESTATUS_SUBETAPA		= 11;
	public static final Short ID_CONCEPTO_MOVIMIENTO	= 31;
	public static final Short ID_SIEFORE				= 18;
	public static final Short ID_REGIMEN				= 21;
	public static final Short ID_TIPO_MONTO				= 26;
	
	public static final Short ID_RESULTADO_SIN_HALLAZGOS	= 29;
	public static final Short ID_ESTATUS_FINALIZADO			= 33;
	public static final Short ID_SUBETAPA_CONCILIACION		= 833;
	
	public static final Short ID_BANCO				= 47;
	public static final Short ID_ESTATUS_BANCOS				= 6;
	public static final Short ID_ORIGEN_APORTACION  = 40;
	public static final Short ID_ORIGEN_APORTACION_EMPRESA  = 45;
	public static final Short ID_CATALOGO_EMPRESAS  = 46;
	public static final Short ID_INDICADOR_SBD = 63;
	public static final Short ID_CATALOGO_FONDOS 		= 66;
	
	public static final Short ID_TIPO_CATALOGO_BANCOS=47;
	public static final Short ID_BANAMEX_NCI= 459;
	public static final Short ID_BANCOMER_NCI = 460;
	public static final Short ID_OTROS_BANCOS_DOMI_FILE=848;
	
	public static final Short ID_CUENTA_DEBITO = 496;
	public static final Short ID_CUENTA_CLABE = 497;
	public static final Short ID_CUENTA_CHEQUERA = 847;
	public static final Short ID_CUENTA_NUM_CELULAR = 947;
	
	public static final Short ID_ORIGEN_APORTACION_INTERNET	=	288	;
	public static final Short ID_ORIGEN_APORTACION_NOMINA	=	289	;
	public static final Short ID_ORIGEN_APORTACION_RED_COMERCIAL	=	290	;
	public static final Short ID_ORIGEN_APORTACION_DOMICILIACION	=	291	;
	public static final Short ID_ORIGEN_APORTACION_SPEI	=	292	;
	public static final Short ID_ORIGEN_APORTACION_VENTANILLA	=	287	;
	public static final Short ID_ORIGEN_DOMICILIACION_E_SAR = 844;
	public static final Short ID_ORIGEN_DOMICILIACION_TRASPASO = 845;
	public static final Short ID_ORIGEN_COMPLEMENTO_AFORE = 1097;
	
	public static final Short ID_ORIGEN_SOLICITUD_SWAP = 1042;
	
	public static final Short ID_ESTATUS_TRASPASO_PENDIENTE = 940;
	public static final Short ID_ESTATUS_TRASPASO_ACEPTADO = 941;
	public static final Short ID_ESTATUS_TRASPASO_CANCELADO = 942;
	
	public static final String STR_ESTATUS_SOLICITUD_CANCELADO = "CANCELADO";
	
	public static final Short ID_ESTATUS_CARGO_PENDIENTE= 498;//498
	public static final Short ID_ESTATUS_CARGO_GENERADO= 499;//499
	
	public static final Short ID_ESTATUS_SOLICITUD_ACEPTADO = 512;
	public static final Short ID_ESTATUS_SOLICITUD_ACEPTADOAUX_1 = 503;
	public static final Short ID_ESTATUS_SOLICITUD_ACEPTADOAUX_2 = 516;
	public static final Short ID_ESTATUS_SOLICITUD_ACEPTADOAUX_3 = 504;
	public static final Short ID_ESTATUS_SOLICITUD_CANCELADO = 513;
	public static final Short ID_ESTATUS_SOLICITUD_RECHAZADO = 511;
	public static final Short ID_ESTATUS_SOLICITUD_PENDIENTE = 509;
	public static final Short ID_ESTATUS_CARGO_APLICADO = 500;
	public static final Short ID_ESTATUS_CARGO_RECHAZADO = 501;
	
	public static final Short ID_TIPO_PERIODOS= 51;
	public static final Short ID_PERIODO_SEMANAL= 492;
	public static final Short ID_PERIODO_QUINCENAL = 493;
	public static final Short ID_PERIODO_MENSUAL = 494;
	public static final Short ID_PERIODO_UNICA = 495;
	
	public static final Short ID_PERIODICIDAD= 51;
	public static final Short ID_FEC_PERIODICIDAD= 77;
	
	public static final Short ID_TIPO_MOVIMIENTO_ABONO = 181;
	public static final Short ID_PROCESO_RECAUDACION = 7;
	public static final Short ID_SUBPROCESO_APORTACION_VOLUNTARIA = 101;
	
	public static final Short ID_PROCESO_REGISTRO = 95;
	public static final Short ID_SUBPROCESO_REGISTRO_NORMAL = 202;
	
	public static final Short IDAPOVOL_CP= 741;
	public static final Short IDAPOVOL_LP = 742;
	public static final Short IDAPOVOL_AVPILP= 743;
	public static final Short IDAPOVOL_ACR= 744;
	
	//------------------ INDICADORES
	public static final Short ID_CONFIG_INDI_VIGENCIA = 2;
	public static final Short ID_CONFIG_INDI_VIGENCIA_VALOR_VIGENTE = 1;
	
	
	// FAMILIA
		public Short ID_FAMILIA_VOLUNTARIAS 			=	147;
		public Short ID_FAMILIA_VIVIENDA 				=	149;	
		public Short ID_FAMILIA_RCV 					=	145;
		public Short ID_FAMILIA_SAR 					=	146;
		public Short ID_FAMILIA_BONO 					=	148;
		public Short ID_FAMILIA_ACR 					=	150;

	public static final String[] ID_MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio",
											 "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	public static final String TXT_DOMICILIACIONES_MAY = "DOMICILIACIONES";
	
	public static final Short ID_PROCESO_FINALIZADO = 18;
	public static final Short ID_PENDIENTE = 968;
	public static final Short ID_APLICADO = 969;
	public static final Short ID_POR_DEVOLVER = 970;
	public static final Short ID_DEVUELTO = 971;
	public static final Short ID_ARCHIVO_BANCARIO = 435;
	
	public static final String ID_CIF_APV_SELCC_ENVIADO_CIF = "1";
	
	public static final Short ID_OPERACIONES = 466;
	
	public static final Short ID_PROCESO_EN_EJECUCION = 17;
	//FOP 2316 24/04/2018
	public static final Short ID_LINEA_NEGOCIO_REGISTRADO = 1;
	public static final Short ID_MONEDA_PESOS_MEXICANOS = 720;
	//FOP 27/09/2018 | Se agrega Domi Registro C/S Liquidaciones
	public static final Short ID_APP_PRODUCE_REGISTRO = 1610;
	
	
}
