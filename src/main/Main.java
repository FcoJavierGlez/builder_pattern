package main;

import builder_pattern.Usuario;
import builder_pattern.UsuarioBuilder;
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
		persona = PersonaSingleton.instancePersonaSingleton("personaSingleton", "12345678Z", 20); 
		System.out.println( persona.toString() );

	}

}
