package cine;

public class Main {

	public static void main(String[] args) {
		Cine cine = new Cine("Sinesa");
		ProcesadorDePagos procesadorDePagos = new ProcesadorDePagos(cine);
		GestorDeReservas gestorDeReservas = new GestorDeReservas(cine, procesadorDePagos);
		Visualizador visualizador = new Visualizador(cine);

		Thread th = new Thread(visualizador);
		th.start();

		while (true) {
			try {
				Cliente c = new Cliente(gestorDeReservas, cine);
				th = new Thread(c);
				th.start();

				Thread.sleep(500);
				
				if (cine.estaLleno()) {
					System.out.println("El cine está lleno, ha recaudado ----> "+ cine.getRecaudacionTotal() + "€");
					System.out.println("Vaciando la sala");

					Thread.sleep(5000);

					cine.reiniciarAsientos();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
