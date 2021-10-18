package prototype_pattern;

public abstract class Automovil {
	
	protected String tipoDeVehiculo;
	protected String marca;
	protected String modelo;
	protected String matricula;
	protected String color;
	
	public Automovil( String tipoDeVehiculo, String marca, String modelo, String matricula, String color ) {
		this.tipoDeVehiculo = tipoDeVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.color = color;
	}
	
	public abstract Automovil clone();

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipoDeVehiculo() {
		return tipoDeVehiculo;
	}

	public void setTipoDeVehiculo(String tipoDeVehiculo) {
		this.tipoDeVehiculo = tipoDeVehiculo;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
