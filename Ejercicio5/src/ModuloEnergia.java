public class ModuloEnergia extends Modulo {
	private int energiaGenerada;
	
	//Constructor con parametros
	public ModuloEnergia(int id, String nombre, String estado, boolean activo, float costo, int ciclos, int energia) {
		super(id,nombre,estado,activo,costo,ciclos);
		this.energiaGenerada = energia;
	}
	
	//Getter y Setter
	public void SetenergiaGenerada(int newenergiaGenerada) {
		this.energiaGenerada = newenergiaGenerada;
	}
	
	public int GetenergiaGenerada() {
		return  energiaGenerada;
	}
	
	@Override //Overide del toString
	public String toString() {
		String cadena = "";
		cadena = "Tipo: Modulo de Energia |Id: "+id+" |Nombre: "+nombre+" |Estado: "+estado;
		if (activo) {
			cadena += "|Activo";
		}else{cadena += "|No Activo";}
		cadena += " |Costo: $"+costo+" |Ciclos: "+ciclos;
		cadena += " |Energia generada: "+energiaGenerada;

		return cadena;
	}
	
	//Procesamiento de ciclo
	public boolean procesarCiclo() {
		if(activo){ //Validacion de activacion
			ciclos += 1; //Se cuenta un cliclo mas
			return true; 
		}else{return false;}
	}
}
