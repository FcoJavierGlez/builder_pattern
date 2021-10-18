package circuit_breaker_pattern;

/**
 * 
 * @author Francisco Javier González Sabariego
 *
 */
public class CircuitBreaker {
	
	private String nombre;
	private int nivelDeFallos;
	private int maxNivelFallos;
	private boolean enabled;
	private boolean disabled;
	private boolean forcedOpen;
	
	public CircuitBreaker( String nombre, int nivelDeFallos, int maxNivelFallos ) {
		this.nombre = nombre;
		this.nivelDeFallos = nivelDeFallos;
		this.maxNivelFallos = maxNivelFallos;
		this.forcedOpen = false;
		this.enabled = false;
		this.disabled = false;
	}
	
	public void connect () throws Exception {
		//this.setDisabled();
		if ( this.disabled ) return;
		if ( this.nivelDeFallos >= this.maxNivelFallos ) throw new Exception("La conexión de " + this.nombre + " está completamente dañada y no se podrá iniciar.");
		if ( this.nivelDeFallos > 0 && !this.forcedOpen ) {
			System.out.println( this.nombre + " presenta errores y requiere el arranque forzado.");
			return;
		}
		this.enabled = true;
		System.out.println(this.nombre + " conexión realizada");
		System.out.println("El estado de la conexión de " + this.nombre + " es: " + this.getEstadoConexion());
	}
	
	public void close() {
		this.enabled = false;
	}
	
	public String getEstadoConexion() {
		if ( this.nivelDeFallos == 0 && this.enabled ) return "OPEN";
		else if ( this.nivelDeFallos < maxNivelFallos && this.enabled ) return "HALF_OPEN";
		else return "CLOSED";
	}
	
	//SETTERS & GETTERS\\

	public int getNivelDeFallos() {
		return nivelDeFallos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setNivelDeFallos(int nivelDeFallos) {
		this.nivelDeFallos = nivelDeFallos;
	}

	public int getMaxNivelFallos() {
		return maxNivelFallos;
	}

	public void setMaxNivelFallos(int maxNivelFallos) {
		this.maxNivelFallos = maxNivelFallos;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
//	public void setDisabled() {
//		this.disabled = this.nivelDeFallos >= this.maxNivelFallos;
//	}

	public boolean isForcedOpen() {
		return forcedOpen;
	}

	public void setForcedOpen(boolean forcedOpen) {
		this.forcedOpen = forcedOpen;
	}
	
	/**
	 * Clona la instancia actual.
	 */
	public CircuitBreaker clone() {
		return new CircuitBreaker( this.nombre, this.nivelDeFallos, this.maxNivelFallos);
	}
	
	
}
