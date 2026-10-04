import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Scanner teclado = new Scanner(System.in);

		//Ingreso de las 6 maquinas para comenzar
		System.out.println("\n--------------Bienvenido al sistema de Proteccion del Quetzal 2--------------");
		

		//MENU
		boolean adentro = true; //Variable para valirdar repeticion del ciclo.

		try{
		while (adentro){
			System.out.println("\n--------------------Menu--------------------");
			System.out.println("1. Listar modulos\n2. Buscar modulo\n3. Catalogo por precio\n4. Avanzar ciclo en simulador\n5. Consultar resumen\n6. Salir");
			System.out.println("----------------------------------------------");
			boolean error = true;
			int n = 0;
			while (error){
				try{
					System.out.println("Ingrese la opcion que desea:");
					n = teclado.nextInt();teclado.nextLine();
					if(n>6||n<1){
						System.out.println("Debe ingresar un dato numérico (de 1 a 6).");
						error = true;
					}else{error = false;}
				}catch(Exception e){
					teclado.nextLine();
					System.out.println("Debe ingresar un dato numérico (de 1 a 6).");
					error = true;
				}
			}

			System.out.println("----------------------------------------------");
			switch (n) {
				case 1: //Listado de modulos
					System.out.println(sistema.listaModulos());
					break;
				case 2: //Busqueda por ID o nombre
					boolean ciclo = true; //Para validacion de opciones
					int op=0;
					while (ciclo){ //Mientras no se haya registrado una opcion valida
						try{
							System.out.println("1. Buscar por ID / 2. Buscar por nombre");
							System.out.println("Ingrese la opcion que desea:");
							op = teclado.nextInt();teclado.nextLine(); //Se lee opcion seleccionada
							if(op>2||op<1){ //Si esta fuera del rango
								System.out.println("Debe ingresar un dato numérico (1 o 2)."); //Mensaje de error
								ciclo = true; //Se continua el ciclo
							}else{ciclo = false;} //Si es valida, el ciclo termina.
						}catch(Exception e){ //Si se ingresa un tipo de dato incorrecto.
							teclado.nextLine();
							System.out.println("Debe ingresar un dato numérico (1 o 2)."); //Mensaje de error
							ciclo = true; //Se continua en el ciclo
						}
					}

					if(op==1){ //Busqueda por ID
						System.out.println("Ingrese el ID que desea buscar:");
						int id = teclado.nextInt();teclado.nextLine(); //Se lee ID
						System.out.println(sistema.buscarID(id)); //Se muestra el string retornado en la busqueda
					}
					if(op==2){ //Busqueda por Nombre
						System.out.println("Ingrese el nombre que desea buscar:");
						String nom = teclado.nextLine(); //Se lee Nombre
						System.out.println(sistema.buscarNombre(nom)); //Se muestra el string retornado en la busqueda
					}

					break;

				case 3:
					System.out.println(sistema.catologo()); //Se muestra el catalogo ordenado por precio de menor a mayor.
					break;

				case 4:
					System.out.println("Simulando un ciclo...");
					System.out.println(sistema.simular()); //Se corre la simulacion del ciclo. Se muestran los mensajes obtenidos.
					System.out.println("Simulacion terminada.");
					break;

				case 5:
					System.out.println(sistema.reporte()); //Se muestra el reporte.
					break;
				
				case 6:
					adentro = false; //Se frena el ciclo
					System.out.println("¡Adios!");
					break;

				default:
					break;
			}
		}
	}catch (Exception e) { //Si se encuentra error en el ciclo
			System.out.println("Ha ocurrido un error."); //Mensaje de error
		}
}
}
