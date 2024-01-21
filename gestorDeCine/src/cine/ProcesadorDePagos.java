package cine;

public class ProcesadorDePagos {
	private Cine cine;
	private int precioEntradaCine = 15;

	public ProcesadorDePagos(Cine cine) {
		this.cine = cine;
	}

	public boolean procesarPago(String cuentaCliente, int fondosCliente) {
		// Si tiene fondos paga

		if (fondosCliente >= precioEntradaCine) {
			System.out.println("Pago aceptado");
			cine.agregarRecaudacion(precioEntradaCine);
			return true;
		}
		System.out.println("Pago rechazado");
		return false;
	}

	public int getPrecioEntradaCine() {
		return precioEntradaCine;
	}

	public void setPrecioEntradaCine(int precioEntradaCine) {
		this.precioEntradaCine = precioEntradaCine;
	}
}

