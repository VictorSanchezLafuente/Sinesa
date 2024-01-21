package cine;

public class Visualizador implements Runnable {
	
	private Cine cine;

	public Visualizador(Cine cine) {
		this.cine = cine;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (cine) {
				try {
					cine.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mostrarEstadoAsientos();
			}
		}
		
	}
	
	public void mostrarEstadoAsientos() {
		for(int i = 0; i < cine.getAsientos().length; i++) {
			for(int j = 0; j < cine.getAsientos()[0].length; j++) {
				if(cine.getAsientos()[i][j].isOcupado()) {
					System.out.print("[X]");
				}else {
					System.out.print("[O]");
				}
			}
			System.out.println("\n");
		}
	}
}

