package main;

import builder_pattern.Usuario;
import builder_pattern.UsuarioBuilder;
import circuit_breaker_pattern.CircuitBreaker;
import prototype_pattern.Automovil;
import prototype_pattern.Coche;
import retry_pattern.RetryPattern;
import singleton_pattern.PersonaSingleton;


/**
 * 
 * @author Francisco Javier Gonz�lez Sabariego
 *
 */
public class Main {

	public static void main(String[] args) {
		//builder pattern
		System.out.println("Patr�n Builder. Voy a crear una nueva instancia: ");
		Usuario user1 = new UsuarioBuilder().build("inventado@hotmail.com", "Nombre1", "666498209", "Calle inventada n�4");
		
		System.out.println( user1.toString() + "\n" );
		
		
		//singleton pattern
		System.out.println("Patr�n Singleton. Voy a crear una nueva instancia: ");
		PersonaSingleton persona = PersonaSingleton.instancePersonaSingleton("personaSingleton", "12345678Z", 20); 
		System.out.println( persona.toString() + "\n");
		
		System.out.println("Patr�n Singleton. Voy a crear una nueva instancia: ");
		PersonaSingleton persona2 = PersonaSingleton.instancePersonaSingleton("persona2", "98461234A", 26); 
		System.out.println( persona2.toString() + "\n" );
		
		
		//prototype pattern
		System.out.println("Patr�n prototype. Voy a crear una nueva instancia: ");
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
		System.out.println("Patr�n retry:");
		RetryPattern retry1 = new RetryPattern(5, 3); //n�mero m�ximo de intentos 5, intentos fallidos 3
		RetryPattern retry2 = retry1.clone();
		
		retry2.setIntentosRealizar(7); //n�mero m�ximo de intentos 5, intentos fallidos 7
		
		do {
			retry1.connect();
			
			try{
		        Thread.sleep(1000);
	        } catch (Exception e) {}
			
		} while ( !( retry1.getConexionExitosa() || retry1.getConexionFallida() ) );
		
		do {
			retry2.connect();
			
			try{
		        Thread.sleep(1000);
	        } catch (Exception e) {}
			
		} while ( !( retry2.getConexionExitosa() || retry2.getConexionFallida() ) );
		
		
		//circuitBreaker pattern
		System.out.println("Patr�n circuitBreaker: ");
		
		CircuitBreaker conn1 = new CircuitBreaker( "conn1", 0, 10 );
		
		CircuitBreaker conn2 = conn1.clone();
		conn2.setNivelDeFallos(4);
		conn2.setNombre("conn2");
		
		
		CircuitBreaker conn3 = conn1.clone();
		conn3.setNivelDeFallos(12);
		conn3.setNombre("conn3");
		
		//Inicio la conexi�n 1 que no tiene errores
		try {
			conn1.connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Inicio la conexi�n 2 que est� parcialmente da�ada y requiere activar el sistema forzado
		try {
			conn2.connect();
			System.out.println("Forzamos el arranque de conn2.");
			conn2.setForcedOpen(true);
			conn2.connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Inicio la conexi�n 3 que est� totalmente da�ada y ser� imposible iniciar
		try {
			conn3.connect();
			System.out.println("Forzamos el arranque de conn3.");
			conn3.setForcedOpen(true);
			conn3.connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
