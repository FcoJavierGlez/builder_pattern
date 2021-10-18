package retry_pattern;

public class RetryPattern {
	
	private int maxIntentosPermitidos;
	private int intentosRealizar;
	private int conexionesIntentadas;
	private Boolean conexionExitosa;
	private Boolean conexionFallida;
	
	public RetryPattern( int maxIntentos, int intentos ) {
		this.maxIntentosPermitidos = maxIntentos;
		this.intentosRealizar = intentos;
		this.conexionesIntentadas = 0;
		this.conexionExitosa = false;
		this.conexionFallida = false;
	}
	
	public void connect() {
		
		if ( this.conexionExitosa ) { return; }
		
		if ( this.conexionFallida ) { return; }
		
		System.out.println("Intento de conexión: " + ++this.conexionesIntentadas);
		
		if ( this.conexionesIntentadas == this.intentosRealizar ) {
			this.conexionExitosa = true;
			System.out.println("Conexión realizada!!!");
		} 
		else if ( this.conexionesIntentadas >= this.maxIntentosPermitidos ) {
			this.conexionFallida = true;
			System.out.println("Has superado el límite de conexiones :(");
		}
		
	}
	
	public RetryPattern clone() {
		return new RetryPattern(this.maxIntentosPermitidos, this.intentosRealizar);
	}

	public int getMaxIntentosPermitidos() {
		return maxIntentosPermitidos;
	}

	public void setMaxIntentosPermitidos(int maxIntentosPermitidos) {
		this.maxIntentosPermitidos = maxIntentosPermitidos;
	}

	public int getIntentosRealizar() {
		return intentosRealizar;
	}

	public void setIntentosRealizar(int intentosRealizar) {
		this.intentosRealizar = intentosRealizar;
	}

	public int getConexionesIntentadas() {
		return conexionesIntentadas;
	}

	public void setConexionesIntentadas(int conexionesIntentadas) {
		this.conexionesIntentadas = conexionesIntentadas;
	}

	public Boolean getConexionExitosa() {
		return conexionExitosa;
	}

	public void setConexionExitosa(Boolean conexionExitosa) {
		this.conexionExitosa = conexionExitosa;
	}

	public Boolean getConexionFallida() {
		return conexionFallida;
	}

	public void setConexionFallida(Boolean conexionFallida) {
		this.conexionFallida = conexionFallida;
	}
	

}
