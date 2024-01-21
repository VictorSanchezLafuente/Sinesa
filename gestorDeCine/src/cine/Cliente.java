package cine;

public class Cliente implements Runnable{
	private String nombre;
	private String apellidos;
	private String correo;
	private String cuentaBancaria;
	private int fondos;
	private int filaDeseada;
	private int columnaDeseada;
	private GestorDeReservas gestorReservas;
	private Cine cine;
	
	
	
	public Cliente(GestorDeReservas gestorReservas, Cine cine) {
		this.nombre = nombreAleatorio();
		this.apellidos = apellidoAleatorio();
		this.correo = correoAleatorio();
		this.cuentaBancaria = cuentaAleatorio();
		this.fondos = fondosAleatorios();
		this.filaDeseada = filaAleatoria();
		this.columnaDeseada = columnaAleatoria();
		this.gestorReservas = gestorReservas;
		this.cine = cine;
	}
	
	@Override
	public void run() {
		synchronized (gestorReservas.getCine()) {
			gestorReservas.intentarReservar(this, filaDeseada, columnaDeseada);
			gestorReservas.getCine().notifyAll();
		}
	}
	
	public String nombreAleatorio() {
		String[] nombres = {"Manuel", "Blanca", "Victor", "Mario", "Eva", "María", "Candela", "César", "Adrián", "Irene"};
		int num = (int) Math.floor(Math.random()*nombres.length);
		return nombres[num];
	}

	public String apellidoAleatorio() {
		String[] apellido = {"Martinez", "Sanchez", "Lafuente", "Quintana", "Martin", "Lopez", "Gavira", "Jimenez", "Lanzas", "Fernandez"};
		int num = (int) Math.floor(Math.random()*apellido.length);
		int num2 = (int) Math.floor(Math.random()*apellido.length);
		return apellido[num] + " " + apellido[num2];
	}

	public String correoAleatorio() {
		String[] nombres = {"Manuel", "Blanca", "Victor", "Mario", "Eva", "María", "Candela", "César", "Adrián", "Irene"};
		String[] apellido = {"Martinez", "Sanchez", "Lafuente", "Quintana", "Martin", "Lopez", "Gavira", "Jimenez", "Lanzas", "Fernandez"};
		int num = (int) Math.floor(Math.random()*nombres.length);
		int num2 = (int) Math.floor(Math.random()*apellido.length);
		return nombres[num]+"."+apellido[num2]+"@alu.ceacfp.com";	
	}

	public String cuentaAleatorio() {
		String prefijo = "ES";
		for (int i = 0; i < 23; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * 10);
			cuentaBancaria = prefijo.concat(String.valueOf(numAleatorio));
		}

		return cuentaBancaria;
	}
	
	public int filaAleatoria() {
		int num = (int) Math.floor(Math.random()*15);
		return num;
	}
	
	public int columnaAleatoria() {
		int num = (int) Math.floor(Math.random()*15);
		return num;
	}
	
	public int fondosAleatorios() {
		int num = (int) Math.floor(Math.random()*100 );
		return num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getFondos() {
		return fondos;
	}

	public void setFondos(int fondos) {
		this.fondos = fondos;
	}

	public int getFilaDeseada() {
		return filaDeseada;
	}

	public void setFilaDeseada(int filaDeseada) {
		this.filaDeseada = filaDeseada;
	}

	public int getColumnaDeseada() {
		return columnaDeseada;
	}

	public void setColumnaDeseada(int columnaDeseada) {
		this.columnaDeseada = columnaDeseada;
	}

	public GestorDeReservas getGestorReservas() {
		return gestorReservas;
	}

	public void setGestorReservas(GestorDeReservas gestorReservas) {
		this.gestorReservas = gestorReservas;
	}
	
	
   
}

