package cine;

public class Cine {
	private int numFilas = 15;
	private int numColumnas = 15;
    private Asiento[][] asientos = new Asiento[numFilas][numColumnas]; //Primer corchete --> filas, segundo --> columnas
    private int recaudacionTotal;
    private String cuentaCine;
    
	public Cine(String cuentaCine) {
		this.recaudacionTotal = 0;
		inicializarAsientos();
		this.cuentaCine = cuentaCine;
	}
	
	public Asiento[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(Asiento[][] asientos) {
		this.asientos = asientos;
	}

	public int getRecaudacionTotal() {
		return recaudacionTotal;
	}

	public void setRecaudacionTotal(int recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}

	public String getCuentaCine() {
		return cuentaCine;
	}

	public void setCuentaCine(String cuentaCine) {
		this.cuentaCine = cuentaCine;
	}
	
	public int getFilas() {
		return numFilas;
	}

	public int getColumnas() {
		return numColumnas;
	}

	public void inicializarAsientos() {
		for(int f = 0; f < numFilas; f++) {
			for(int c = 0; c < numColumnas; c++) {
				this.asientos[f][c] = new Asiento(f,c);
			}
		}
	}
	
	public boolean verificarDisponibilidad(int fila, int columna) {
		boolean disponibilidad = this.asientos[fila][columna].isOcupado() ? false : true;
		return disponibilidad;
	}
	
	public void reservarAsiento(int fila, int columna) {
		this.asientos[fila][columna].setOcupado(true);
	}
	
	public boolean estaLleno() {
		for(int f = 0; f < numFilas; f++) {
			for(int c = 0; c < numColumnas; c++) {
				if(!this.asientos[f][c].isOcupado()) {
					return false;
				}
			}
		}
		return true;
	}
     
    public void agregarRecaudacion(int recaudado) {
    	this.recaudacionTotal += recaudado;
    }
    
    public void reiniciarAsientos() {
    	for(int f = 0; f < numFilas; f++) {
			for(int c = 0; c < numColumnas; c++) {
				this.asientos[f][c].setOcupado(false); //le daremos al setOcupado valor false, para que así todos los asientos estén libres
			}
		}
    }

	
	
}