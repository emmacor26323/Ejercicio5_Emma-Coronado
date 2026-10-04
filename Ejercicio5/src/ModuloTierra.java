public class ModuloTierra extends Modulo {
	private String estacion;
	private int capacidad;
	private int energiaNecesaria;
	private int totalD;

	//Constructor
	public ModuloTierra() {
		super(-1,"","",false,0,0);
		this.estacion ="";
		this.capacidad = 0;
		this.energiaNecesaria=0;
		this.totalD=0;
	}
	
	//Constructor con parametros
	public ModuloTierra(int id, String nombre, String estado, boolean activo, float costo, int ciclos, String estacion, int capacidad, int energia) {
		super(id,nombre,estado,activo,costo,ciclos);
		this.estacion =estacion;
		this.capacidad = capacidad;
		this.energiaNecesaria=energia;
		this.totalD=0;

	}
	
	//Getters y Setters
	public void Setestacion(String newestacion) {
		this.estacion = newestacion;
	}
	
	public String Getestacion() {
		return this.estacion;
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
	
	public void SettotalD(int newtotalD) {
		this.totalD = newtotalD;
	}
	
	public int GettotalD() {
		return this.totalD;
	}
	
		
	@Override //Overide del toString
	public String toString() {
		String cadena = "";
		cadena = "Tipo: Modulo de Tierra |Id: "+id+" |Nombre: "+nombre+" |Estado: "+estado;
		if (activo) {
			cadena += "|Activo";
		}else{cadena += "|No Activo";}
		cadena += " |Costo: $"+costo+" |Ciclos: "+ciclos;
		cadena += " |Estacion: "+estacion+" |Capacidad: "+capacidad+" |Energia necesaria: "+energiaNecesaria+" |Total descargado: "+totalD;

		return cadena;
	}
	
	//Procesamiento de ciclo
	public boolean procesarCiclo() {
		return activo;  //Validacion de activacion
	}
}
