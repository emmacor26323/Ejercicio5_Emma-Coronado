import java.util.ArrayList;

public class Sistema {
	private Modulo[] modulos;
	private int energia;
	private int totalDescargado;
	private int datosOrbita;
	
	public Sistema() { //Constructor
		modulos = new Modulo[10]; //10 modulos
		energia = 0;
		totalDescargado = 0;
		datosOrbita = 0;

		//10 Modulos construidos ya registrados en la Mision
		modulos[0] = new ModuloEnergia(10,"E1","Funcional",true,10000,0,5);
		modulos[1] = new ModuloTierra(20, "T1", "Dañado", false, 5000, 0, "Washington", 5, 3);
		modulos[2] = new ModuloVuelo(30, "V1", "Funcional", true, 7500, 0, 1, 6, 4);
		modulos[3] = new ModuloEnergia(40,"E2","Dañado",false,10000,0,10);
		modulos[4] = new ModuloTierra(50, "T2", "Funcional", true, 5000, 0, "GT", 10, 4);
		modulos[5] = new ModuloVuelo(60, "V2", "Funcional", true, 7500, 0, 2, 10, 5);
		modulos[6] = new ModuloEnergia(70,"E3","Funcional",true,15000,0,15);
		modulos[7] = new ModuloTierra(80, "T3", "Funcional", true, 5000, 0, "MX", 1, 1);
		modulos[8] = new ModuloVuelo(90, "V3", "Dañado", false, 7500, 0, 2, 20, 5);
		modulos[9] = new ModuloEnergia(101,"E5","Funcional",true,9000,0,2);
	}
	
	//Getters y Setters
	public void Setenergia(int newenergia) {
		this.energia = newenergia;
	}
	
	public int Getenergia() {
		return this.energia;
	}
	
	public void SettotalDescargado(int newtotalDescargado) {
		this.totalDescargado = newtotalDescargado;
	}
	
	public int GettotalDescargado() {
		return this.totalDescargado;
	}
	
	public void SetdatosOrbita(int newdatosOrbita) {
		this.datosOrbita=newdatosOrbita;
	}
	
	public int GetdatosOrbita() {
		return this.datosOrbita;
	}
	
	public String listaModulos() {
		String cadena = "-----------Modulos---------------";
		for(Modulo m:modulos){ //Se recorre cada modulo
			cadena += "\n \n"+m.toString(); //Se almacena su infromacion como String
		}

		return cadena; //Se retorna el String con la informacion de cada modulo.
	}

	
	public String buscarID(int id) {
		for(Modulo m:modulos){ //Se recorre cada modulo
			if(m.Getid()==id){ //Se compara el id del modulo con el buscado
				return m.toString(); //Si es igual, se retorna un String con la informacion del modulo
			}
		}
		return "No se encontró módulo"; //Si no hay concidencias, se muestra en un mensaje.
	}
	
	public String buscarNombre(String nombre) {
		for(Modulo m:modulos){ //Se recorre cada modulo
			if(m.Getnombre().equals(nombre)){ //Se compara el nombre del modulo con el buscado
				return m.toString(); //Si es igual, se retorna un String con la informacion del modulo
			}
		}
		return "No se encontró módulo"; //Si no hay concidencias, se muestra en un mensaje.
	}
	
	public String catologo(){
		Modulo[] orden = modulos.clone(); //Copia de modulos
		
		for(int i=0;i<9;i++){ //Ciclo que recorre la copia de los modulos registrados.
			Modulo t1 = orden[i]; //Se almacena el modulo de la posicion que se analiza.
			Modulo t2 = orden[i+1]; //Se almacena el modulo de la posicion siguiente.

			float costo1 =t1.Getcosto(); //Costo del modulo en la posicion actual.
			float costo2 = t2.Getcosto(); //Costo del modulo en la posicion siguiente.

			if(costo1>costo2){ //Si el costo del modulo actual es mayor
				//Se intercambian los modulos (cambian su posicion)
				orden[i]=t2;
				orden[i+1]=t1;	
				i=-1; //Se retorna posicion incial para empezar la comparacion de todos los datos nuevamente
				//Permite que todos los datos sean comparados y el orden este correcto.			
			}
		}

		String cadena = "";
		for(Modulo m:orden){ //Para cada modulo del arreglo ordenado
			cadena += m.toString()+"\n"; //Se almacena su informacion como String
		}

		return cadena; //Se retorna el String con la informacion de los modulos en orden.
	}


	public String simular() {
		String mensajes = "";

		for(Modulo m:modulos){ //Para cada Modulo registrado

			//Modulos de Vuelo
			if(m instanceof ModuloVuelo){
				if(m.procesarCiclo()){ //Si esta activo
					if(energia<((ModuloVuelo)m).GetenergiaNecesaria()){ //Verificacion de energía suficiente
						mensajes += "Id: "+m.Getid()+" | No se ejecuto por falta de energia.\n"; //Mensaje de falta de energia
					}else{ //Si hay suficiente energia y esta activo
						datosOrbita += ((ModuloVuelo)m).Getcapacidad(); //Se suben datos a Orbita
						energia -= ((ModuloVuelo)m).GetenergiaNecesaria(); //Se gasta energia
						m.Setciclos(m.Getciclos()+1);//Se agrega un ciclo a la cuenta
					}
				}else{mensajes += "Id: "+m.Getid()+" | Modulo inactivo\n";} //Mensaje de inactividad
			}

			//Modulos de Tierra
			if(m instanceof ModuloTierra){
				if(m.procesarCiclo()){ //Si esta activo
					if(energia<((ModuloTierra)m).GetenergiaNecesaria()){ //Verificacion de energía suficiente
						mensajes += "Id: "+m.Getid()+" | No se ejecuto por falta de energia.\n"; //Mensaje de falta de energia
					}else{ //Si hay suficiente energia y esta activo

						if(datosOrbita!=0){//Si hay datos para descargar
							datosOrbita -=  ((ModuloTierra)m).Getcapacidad(); //Se descargan los datos posibles
							int descargado = ((ModuloTierra)m).Getcapacidad(); //Cantidad de datos descargados
							if(datosOrbita<0){ //Si se descargaron todos los datos.
								descargado += datosOrbita; //Ajuste de cantidad descargada
								datosOrbita=0; //No hay datos en orbita
							} 
							energia -= ((ModuloTierra)m).GetenergiaNecesaria(); //Se gasta energia
							m.Setciclos(m.Getciclos()+1);//Se agrega un ciclo a la cuenta
							((ModuloTierra)m).SettotalD(((ModuloTierra)m).GettotalD()+descargado);//Actualizacion de descargas en el modulo
							totalDescargado += descargado; //Actualizacion de totaldescargado en el sistema.
						}else{
							mensajes += "Id: "+m.Getid()+" | No hay datos en orbita\n"; //Mensaje de falta de datos.
						}
					}
				}else{mensajes += "Id: "+m.Getid()+" | Modulo inactivo\n";} //Mensaje de inactividad
			}

			//Modulos Energia
			if(m instanceof ModuloEnergia){
				if(m.procesarCiclo()){ //Se verifica activacion
					energia += ((ModuloEnergia)m).GetenergiaGenerada(); //Se genera energia
				}else{mensajes += "Id: "+m.Getid()+" | Modulo inactivo\n";} //Mensaje de inactividad
			}

			mensajes += "Energia disponible: " + energia+" |Datos en orbita: " + datosOrbita + " MB |Total descargado: " + totalDescargado + " MB\n";//Estado tras modulo
		}
		
		return mensajes; //Retorno de todos los mensajes almacenados en la simulacion.
	}
	
	public String reporte() {
		int c = 0; //Cantidad de ModulosTierra
		int a = 0; //Cantidad de Modulos Tierra Activos
		int cT = 0; //Capacidad de descargas total

		ModuloTierra MM = new ModuloTierra(); //Modulo de comparacion
		ArrayList<Modulo> maximos = new ArrayList<>(); //Lista de modulos con el mayor total de descargas

		for(Modulo m:modulos){ //Para cada modulo
			if(m instanceof ModuloTierra){ //Si es de Tierra
				c ++; //Se suma un ModuloTierra
				if(m.Getactivo()){ //Si esta activo
					a++; //Se suma un modulo activo
					cT += ((ModuloTierra)m).Getcapacidad(); //Se suma la capacidad del modulo
				}
				
				if (((ModuloTierra)m).GettotalD() > MM.GettotalD()){ //Si el modulo tiene mas descargas que le modulo de referencia
					MM = (ModuloTierra)m; //Se convierte en el modulo de referencia
					maximos = new ArrayList<>(); //Se limpia la lista de modulos con mayor total de descargas
				}
				if (((ModuloTierra)m).GettotalD() == MM.GettotalD()){//Si el modulo tiene la misma cantidad de descargas que el de referncia
					if(maximos.contains(MM)){}else{maximos.add(MM);}//Si el modulo de referencia no esta en la lista se agrega 
					if(MM.Getid()!=m.Getid()){maximos.add(m);} //Se agrega el modulo comparado a la lista (si no es el mismo)
				}
			}
		}

		String cadena = "-----------Reporte-------------"; //Encabezado
		//Informacion del reporte
		cadena += "\nModulos de Tierra: "+c;  
		cadena += "\nModulos de Tierra Activos: "+a;
		cadena += "\nTotal de descarga por ciclo: "+cT;
		cadena += "\nTotal de historico descargado: "+totalDescargado;
		cadena += "\nMayor cantidad historica de datos descargados:\n";
		
		if(maximos.size()==0){ //Si la lista esta vacia
			cadena +=MM.toString(); //Se muestra la informacion del modulo de refencia
		}else{//Si no
			for(Modulo m:maximos){//Para cada modulo en la lista
				cadena += m.toString()+"\n"; //Se almacena la infromacion
			}
		}

		return cadena; //Se retorna un String con todo el reporte
	}
}
