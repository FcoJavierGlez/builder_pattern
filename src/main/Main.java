package main;

import builder_pattern.Usuario;
import builder_pattern.UsuarioBuilder;
import prototype_pattern.Automovil;
import prototype_pattern.Coche;
import retry_pattern.RetryPattern;
import singleton_pattern.PersonaSingleton;

public class Main {

	public static void main(String[] args) {
		//builder pattern
		System.out.println("Patrón Builder. Voy a crear una nueva instancia: ");
		Usuario user1 = new UsuarioBuilder().build("inventado@hotmail.com", "Nombre1", "666498209", "Calle inventada nº4");
		
		System.out.println( user1.toString() + "\n" );
		
		
		//singleton pattern
		System.out.println("Patrón Singleton. Voy a crear una nueva instancia: ");
		PersonaSingleton persona = PersonaSingleton.instancePersonaSingleton("personaSingleton", "12345678Z", 20); 
		System.out.println( persona.toString() + "\n");
		
		System.out.println("Patrón Singleton. Voy a crear una nueva instancia: ");
		PersonaSingleton persona2 = PersonaSingleton.instancePersonaSingleton("persona2", "98461234A", 26); 
		System.out.println( persona2.toString() + "\n" );
		
		
		//prototype pattern
		System.out.println("Patrón prototype. Voy a crear una nueva instancia: ");
		Automovil coche1 = new Coche( "Ferrari", "F40", "1234-ABC", "Rojo" );
		
		System.out.println( "Instancia de coche1: " + coche1.toString() );
		
		System.out.println("Clono 2 veces el objeto: ");
		
		Automovil coche2 = coche1.clone();
		Automovil coche3 = coche1.clone();
		
		System.out.println("Cambio el colo de coche2 a negro y coche3 a azul: ");
		
		coche2.setColor("Negro");
		coche3.setColor("Azul");
		
		System.out.println("Muestro los 3 coches:");
		System.out.println( "Coche1: " + coche1.toString() );
		System.out.println( "Coche2: " + coche2.toString() );
		System.out.println( "Coche3: " + coche3.toString() + "\n" );
		
		
		//retry pattern
		RetryPattern retry1 = new RetryPattern(5, 3);
		RetryPattern retry2 = retry1.clone();
		
		retry2.setIntentosRealizar(7);
		
		retry1.connect();
		retry2.connect();
		
		
		//circuitBreaker pattern
		
	}

}
