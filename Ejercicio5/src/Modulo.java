public abstract class Modulo {
	protected int id;
	protected String nombre;
	protected String estado;
	protected boolean activo;
	protected float costo;
	protected int ciclos;

	//Constructor
	public Modulo(int id, String nombre, String estado, boolean activo, float costo, int ciclos) {
		this.id = id;
		this.nombre =nombre;
		this.estado =estado;
		this.activo=activo;
		this.costo=costo;
		this.ciclos=ciclos;
	}
	
	//Setters y Getters
	public void Setid(int newid) {
		this.id =newid;
	}
	
	public int Getid() {
		return this.id;
	}
	
	public void Setnombre(String newnombre) {
		this.nombre = newnombre;
	}
	
	public String Getnombre() {
		return this.nombre;
	}
	
	public void Setestado(String newestado) {
		this.estado = newestado;
	}
	
	public String Getestado() {
		return this.estado;
	}
	
	public void Setactivo(boolean newactivo) {
		this.activo = newactivo;
	}
	
	public boolean Getactivo() {
		return this.activo;
	}
	
	public void Setcosto(float newcosto) {
		this.costo=newcosto;
	}
	
	public float Getcosto() {
		return this.costo;
	}
	
	public void Setciclos(int newciclos) {
		this.ciclos = newciclos;
	}
	
	public int Getciclos() {
		return this.ciclos;
	}
	
	//Metodos abstractos
	public abstract String toString();
	
	public abstract boolean procesarCiclo();
}
