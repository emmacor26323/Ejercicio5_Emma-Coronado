public class ModuloVuelo extends Modulo {
	private int tipo;
	private int capacidad;
	private int energiaNecesaria;
	
	//Constructor con parametros
	public ModuloVuelo(int id, String nombre, String estado, boolean activo, float costo, int ciclos, int tipo, int capacidad, int enegia) {
		super(id,nombre,estado,activo,costo,ciclos);
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.energiaNecesaria = enegia;

	}
	
	//Getters y Setters
	public void Settipo(int newtipo) {
		this.tipo = newtipo;
	}
	
	public int Gettipo() {
		return this.tipo;
	}
	
	public void Setcapacidad(int newcapacidad) {
		this.capacidad = newcapacidad;
	}
	
	public int Getcapacidad() {
		return this.capacidad;
	}
	
	public void SetenergiaNecesaria(int newenergiaNecesaria) {
		this.energiaNecesaria = newenergiaNecesaria;
	}
	
	public int GetenergiaNecesaria() {
		return this.energiaNecesaria;
	}
	

	@Override //Overide del toString
	public String toString() {
		String cadena = "";
		cadena = "Tipo: Modulo de Vuelo |Id: "+id+" |Nombre: "+nombre+" |Estado: "+estado;
		if (activo) {
			cadena += "|Activo";
		}else{cadena += "|No Activo";}
		cadena += " |Costo: $"+costo+" |Ciclos: "+ciclos;
		if(tipo==1){
			cadena +="|Camara ";
		}else{cadena+="|Sensor ";}
		cadena+= "|Capacidad: "+capacidad+"|Energia necesaria: "+energiaNecesaria;

		return cadena;
	}
	
	//Procesamiento de ciclo
	public boolean procesarCiclo() {
		return activo;  //Validacion de activacion
	}
}
