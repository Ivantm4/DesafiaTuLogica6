package retoUd6;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GestionCluedo {
	
	//Lista para almacenar las combinaciones de cartas
	
	static ArrayList<Jugador> combinaciones=new ArrayList<>();
	
	//Clave para ver las cartas
	
	static final String claveSecreta="Cluedo";
	
	//Archivo para guardar las combinaciones de cartas
	
	static final String nombreArchivo="combinaciones.txt";
	
	//Listas para almacenar personajes,armas y habitaciones
	
	static ArrayList<String> personajes=new ArrayList<>();
	static ArrayList<String> armas=new ArrayList<>();
	static ArrayList<String> habitaciones=new ArrayList<>();

	public static void main(String[] args) {

		
		
		//Paso 1
		/*//Arrays personajes,armas,habitaciones
		
		String [] personajes= {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
		String [] armas= {"bate","pistola","candelabro","cuchillo","cuerda","hacha","pesa","veneno","trofeo"};
		String [] habitaciones= {"casa de invitados","teatro","spa","observatorio","comedor","terraza","salón","cocina","vestibulo"};
		*/
		
		//Agregar elementos iniciales a las listas
		
		inicializarCartas();
		
		//Paso2
		//Se muestra mensaje de bienvenida
		
		System.out.println("¡Bienvenido al juego del Cluedo!");
		System.out.println("Este programa se encarga de barajar las cartas de forma aleatoria para comenzar el juego.");
		
		//Paso 3
		//Muestras personajes, armas y habitaciones disponibles
		
		mostrarCartasDisponibles();
		
		//Pregunta al usuario por consola si quiere añadir nuevas cartas
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("¿Quieres añadir más personajes, armas o habitaciones? (Si/No)");
		
		String respuesta =sc.nextLine();
		
		while(respuesta.equalsIgnoreCase("si")) {
			
			System.out.println("Menú \n 1.Personaje \n 2.Arma \n 3.Habitación \n 4.Salir \n Elige una opción: ");
			
			int opcion=sc.nextInt();
			sc.nextLine();
			
			//Procesar la opción seleccionada
			
			switch(opcion) {
			case 1: 
				añadirCartas(personajes,"personaje");
				//mostrarCartasDisponibles();
				break;
				
			case 2:
				añadirCartas(armas,"arma");
				//mostrarCartasDisponibles();
				break;
				
			case 3:
				añadirCartas(habitaciones,"habitación");
				//mostrarCartasDisponibles();
				break;
				
			case 4:
				respuesta="no";//Sale del bucle
				break;
				
			default:
				System.out.println("Opción no válida. Por favor elige una opción válida.");	
				
			}
			
			if(!respuesta.equalsIgnoreCase("no")) {
				
				System.out.println("¿Quieres añadir más cartas? (Si/No)");
				
				respuesta=sc.nextLine();
			}
			
		}
		
		System.out.println("¡Sigamos con el juego!\nEsta es la lista definitiva:");
		
		mostrarCartasDisponibles();
		
		//Paso 4
		
		System.out.println("Se va a producir la baraja de cartas...");
		
		//Baraja de cartas y almacenaminento de combinación
		
		boolean exitoBarajado=barajarCartas();
		
		if(exitoBarajado) {
			
			System.out.println("Cartas barajadas correctamente.");
			//mostrarCombinacionActual();
		
		//Paso 5 
		//Solicitar clave para ver las cartas
		
			System.out.println("Si introduces la clave correcta, puedes ver la combinación.");
			System.out.println("Introduce la clave: ");
			String clave=sc.nextLine();
		
		//Verifica clave
		
			if(clave.equalsIgnoreCase(claveSecreta)) {
			
				System.out.println("Clave correcta, aqui tienes la combinación de cartas: ");
			
				mostrarCombinacionActual();
			}else{
			
				System.out.println("Clave incorrecta. No tienes permiso para ver las cartas.");
			}
			
		//Preguntar si quiere crear una nueva combinación 
			
			System.out.println("¿Quiere crear una nueva combinación para el juego?(si/no)");
			
			String nuevaCombinacion=sc.nextLine();
			
			if(nuevaCombinacion.equalsIgnoreCase("si")) {
				
				//Reiniciar juego
				
				main(args);
			}else {
				
				//Guardar combinación en archivo de texto
				
				guardarCombinacionArchivo();
				
				System.out.println("Se acabo el juego. Hasta la próxima!!");
			}
		}else {
			
			System.out.println("Error al barajar las cartas. El juego no puede continuar.");
		}
		
		sc.close();
	}
	
	//Paso 6
					
	//Se construye método 
	
	public static void mostrarCartasDisponibles() {
		
		System.out.println("Personajes disponibles: ");
		
		for (String pers : personajes) {
			
			System.out.println("-"+pers);			
		}
		
		System.out.println("Armas disponibles: ");
		
		for (String arm : armas) {
			
			System.out.println("-"+arm);
		}
		
		System.out.println("Habitaciones disponibles: ");
		
		for (String hab : habitaciones) {
			
			System.out.println("-"+hab);			
		}
	
	}
	
	//Se construye método añadirCartas
	
	public static void inicializarCartas() {
		
		//Agregar elementos iniciales a las listas
		
			personajes.add("Amapola");
	        personajes.add("Celeste");
	        personajes.add("Prado");
	        personajes.add("Mora");
	        personajes.add("Rubio");
	        personajes.add("Blanco");

	        armas.add("bate");
	        armas.add("pistola");
	        armas.add("candelabro");
	        armas.add("cuchillo");
	        armas.add("cuerda");
	        armas.add("hacha");
	        armas.add("pesa");
	        armas.add("veneno");
	        armas.add("trofeo");

	        habitaciones.add("casa de invitados");
	        habitaciones.add("teatro");
	        habitaciones.add("spa");
	        habitaciones.add("observatorio");
	        habitaciones.add("comedor");
	        habitaciones.add("terraza");
	        habitaciones.add("salón");
	        habitaciones.add("cocina");
	        habitaciones.add("vestíbulo");		
	}
	
	public static void añadirCartas(ArrayList<String> cartas,String tipoCarta) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("¿Cuánt@s "+tipoCarta+" quieres añadir? ");
		
		int numCartas=sc.nextInt();
		sc.nextLine();
		
			
		//Actualiza arrayList con las nuevas cartas
		
		/*String[] arrayAntiguo=cartas;
		
		cartas=actualizarArray(arrayAntiguo,numCartas);*/
		
		for(int i=0;i<numCartas;i++) {
			
			System.out.println("Introduce el nombre del "+tipoCarta+": ");
			
			String carta=sc.nextLine();
			
			cartas.add(carta);
			
			//cartas[cartas.length-numCartas+i]=sc.nextLine();
		}		
		
		//System.out.println("¡"+numCartas+" "+tipoCarta+" añadido correctamente!");
		//sc.close();
	}
	
	//Se crea método actualizarArray
	
	public static String[] actualizarArray(String[] arrayAntiguo,int num) {
		
		//Calcula longitud nuevo array
		
		int longitudNuevoArray=arrayAntiguo.length+num;
		
		//Crea nuevo Array con la longitud calculada
		
		String[] arrayNuevo=new String [longitudNuevoArray];
		
		//Copia los elementos del array antiguo al nuevo
		
		for(int i=0;i<arrayAntiguo.length;i++) {
			
			arrayNuevo[i]=arrayAntiguo[i];
		}
		
		return arrayNuevo;				
	}
	
	public static boolean barajarCartas() {
		
		try {
			//Generar combinación aleatoria de personajes, armas y habitaciones
			
			Random random=new Random();
			
			String personaje=personajes.get(random.nextInt(personajes.size()));
			
			String arma=armas.get(random.nextInt(armas.size()));
			
			String habitacion=habitaciones.get(random.nextInt(habitaciones.size()));
			
			Date horaPartida=new Date();//Hora actual del sitema
			
			//Almacena combinación en la lista dínamica
			
			combinaciones.add(new Jugador(personaje,arma,habitacion,horaPartida));
			
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public static void mostrarCombinacionActual() {
		
		Jugador ultimaCombinacion=combinaciones.get(combinaciones.size()-1);
		
		System.out.println("Combinación actual: ");
		System.out.println("Asesino: "+ultimaCombinacion.getNombre());
		System.out.println("Arma: "+ultimaCombinacion.getArma());
		System.out.println("Habitación: "+ultimaCombinacion.getHabitaciones());
		System.out.println("Hora del crimen: "+ultimaCombinacion.getHoraPartida());
	}
	
	public static void guardarCombinacionArchivo() {
		
		try(PrintWriter writer=new PrintWriter(new FileWriter(nombreArchivo))){
			
			//Escribir fecha de cierre en la cabecera del archivo
			
			SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			writer.println("Fecha de cierre: "+formatoFecha.format(new Date()));
			
			//Escribir cada combinación en el archivo
			
			for (Jugador combinacion : combinaciones) {
				
				writer.println("Combinación: ");
				writer.println(combinacion.toString());
				writer.println();
				
			}
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println("Error al guardar las combinaciones en el archivo.");
		}
	}
}
