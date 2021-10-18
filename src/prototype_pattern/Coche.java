package prototype_pattern;

public class Coche extends Automovil {
	
	public Coche( String marca, String modelo, String matricula, String color ) {
		super( "Coche", marca, modelo, matricula, color );
	}
	public Automovil clone() {
		return new Coche( this.marca, this.modelo, this.matricula, this.color );
	}
	@Override
	public String toString() {
		return "Coche [color=" + color + ", tipoDeVehiculo=" + tipoDeVehiculo + ", marca=" + marca + ", modelo="
				+ modelo + ", matricula=" + matricula + "]";
	}
	
}
