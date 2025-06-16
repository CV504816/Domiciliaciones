package mx.profuturo.nci.business.wrapped;

public class UltimosArchivosGeneradosFilter {

	private String cuentasIncluir;
	private String archivoGenerar;

	public UltimosArchivosGeneradosFilter() {

	}

	public UltimosArchivosGeneradosFilter(String cuentasIncluir, String archivoGenerar) {
		this.cuentasIncluir = cuentasIncluir;
		this.archivoGenerar = archivoGenerar;
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