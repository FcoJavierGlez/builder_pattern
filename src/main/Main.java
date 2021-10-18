package main;

import builder_pattern.Usuario;
import builder_pattern.UsuarioBuilder;
import singleton_pattern.PersonaSingleton;

public class Main {

	public static void main(String[] args) {
		//builder pattern
		Usuario user1 = new UsuarioBuilder().build("inventado@hotmail.com", "Nombre1", "666498209", "Calle inventada nº4");
		
		//singleton pattern
		PersonaSingleton persona = PersonaSingleton.instancePersonaSingleton("personaSingleton", "12345678Z", 20); 
		
		
		
		//builder
		System.out.println( user1.toString() );
		
		//singleton
		System.out.println( persona.toString() );

	}

}
