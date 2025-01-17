package builder_pattern;

/**
 * 
 * @author Francisco Javier Gonz�lez Sabariego
 *
 */
public class Usuario {
	
	private String email;
	private String nombre;
	private String telefono;
	private String direccion;
	
	public Usuario () {}
	
	public Usuario (String email, String nombre, String telefono, String direccion) { }
	
//	public Usuario build (String email, String nombre, String telefono, String direccion) {
//		return new Usuario(email, nombre, telefono, direccion);
//	}
	
	//\\

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ "]";
	}
	
}
