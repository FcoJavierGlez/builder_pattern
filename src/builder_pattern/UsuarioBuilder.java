package builder_pattern;

public class UsuarioBuilder {


	public Usuario build (String email, String nombre, String telefono, String direccion) {
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setNombre(nombre);
		user.setTelefono(telefono);
		user.setDireccion(direccion);
		return user;
	}
}
