package singleton_pattern;

public class PersonaSingleton {
	
	private String nombre;
	private String dni;
	private int edad;
	private static PersonaSingleton instanciaPersona;

	private PersonaSingleton(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		System.out.println("Creando una instancia nueva de " + nombre + " " + dni );
	}
	
	public static PersonaSingleton instancePersonaSingleton(String nombre, String dni, int edad) {
		if (instanciaPersona == null) 
			instanciaPersona = new PersonaSingleton(nombre, dni, edad);

		else System.out.println( "Esta instancia ya fue creada: " + instanciaPersona.toString() );
		
		return instanciaPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static PersonaSingleton getInstanciaPersona() {
		return instanciaPersona;
	}

	public static void setInstanciaPersona(PersonaSingleton instanciaPersona) {
		PersonaSingleton.instanciaPersona = instanciaPersona;
	}

	@Override
	public String toString() {
		return "PersonaSingleton [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + "]";
	}
	
}
