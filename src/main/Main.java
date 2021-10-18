package main;

import builder_pattern.Usuario;
import builder_pattern.UsuarioBuilder;

public class Main {

	public static void main(String[] args) {
		Usuario user1 = new UsuarioBuilder().build("inventado@hotmail.com", "Nombre1", "666498209", "Calle inventada nº4");
		
		System.out.println( user1.toString() );

	}

}
