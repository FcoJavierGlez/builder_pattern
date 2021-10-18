package retry_pattern;

public class RetryPattern {
	
	private int maxIntentosPermitidos;
	private int intentosRealizar;
	
	public RetryPattern( int maxIntentos, int intentos ) {
		this.maxIntentosPermitidos = maxIntentos;
		this.intentosRealizar = intentos;
	}
	
	public void connect() {
		
		int conexionesIntentadas = 0;
		
		do {
		
			try{
		        Thread.sleep(1000);
		      } catch (Exception e){}
			
			System.out.println("Intento de conexión: " + ++conexionesIntentadas);
			
			if (conexionesIntentadas == intentosRealizar) {
				System.out.println("Conexión realizada!!!");
				return;
			} else if ( conexionesIntentadas >= maxIntentosPermitidos ) {
				System.out.println("Has superado el límite de conexiones :(");
				return;
			}
			
		} while ( conexionesIntentadas < intentosRealizar || conexionesIntentadas < maxIntentosPermitidos );
		
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
	

}
