package mx.profuturo.nci.ws.beans.request;

public class ValidaAluxOssTBeanRequest {

	private String numeroCuenta;

	public ValidaAluxOssTBeanRequest() {}
	
	public ValidaAluxOssTBeanRequest(String numeroCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@Override
	public String toString() {
		return "ValidaAluxOssTBeanRequest [numeroCuenta=" + numeroCuenta + "]";
	}
	
}
