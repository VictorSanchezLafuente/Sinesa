package cine;


public class GestorDeReservas {
	private Cine cine;
	private ProcesadorDePagos procesadorPagos;

	public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorPagos) {

		this.cine = cine;
		this.procesadorPagos = procesadorPagos;
	}

	public synchronized void intentarReservar(Cliente cliente, int filaDeseada, int columnaDeseada) {
		System.out.println(cliente.getNombre() + cliente.getApellidos() + " quiere reservar el asiento " + columnaDeseada + " de la fila " + filaDeseada);
		if (cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
			System.out.println("ASIENTO DISPONIBLE");
			procesarReserva(cliente, filaDeseada, columnaDeseada);
		} else {
			System.out.println("ASIENTO OCUPADO");
			buscarAsientoAlternativo(cliente, filaDeseada, columnaDeseada);
		}
	}

	public void buscarAsientoAlternativo(Cliente cliente, int filaDeseada, int columnaDeseada) {
		for (int i = filaDeseada - 1; i <= filaDeseada + 1; i++) {	//recorro las filas alrededor de la deseada
			for (int j = columnaDeseada - 1; j <= columnaDeseada + 1; j++) {	//recorro las columnas alrededor de la deseada
				if (i >= 1 && i <= cine.getFilas() && j >= 1 && j <= cine.getColumnas()) {		//para saber que no este buscando fuera de los limines del cine
					if (cine.verificarDisponibilidad(i, j)) {	//si el asiento esta libre, lo reserva
						System.out.println(
								"Asiento alternativo en la fila " + i + ", columna " + j);
						procesarReserva(cliente, i, j);
						return;
					}
				}
			}
		}

		// Si no se encuentra un asiento alternativo
		System.out.println("NO HAY ASIENTOS DISPONIBLES");
	}

	private void procesarReserva(Cliente cliente, int fila, int columna) {
		if (procesadorPagos.procesarPago(cliente.getCuentaBancaria(), cliente.getFondos())) {
			cine.reservarAsiento(fila, columna);
			cliente.setFondos(-procesadorPagos.getPrecioEntradaCine() + cliente.getFondos());
			System.out.println(cliente.getNombre() + " ha reservado el asiento " + columna + ", de la fila " + fila);
		} else {
			System.out.println(cliente.getNombre() + " no tiene fondos suficientes");
		}
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public ProcesadorDePagos getProcesadorPagos() {
		return procesadorPagos;
	}

	public void setProcesadorPagos(ProcesadorDePagos procesadorPagos) {
		this.procesadorPagos = procesadorPagos;
	}

}
