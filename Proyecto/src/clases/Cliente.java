package clases;

public class Cliente {
	//Atributos privados
	private int codCli;
	private String nombre;
	private String apellido;
	private String telefono;
	private String dni;
	//Constructor
	public Cliente(int codCli, String nombre, String apellido, String telefono, String dni) {
		this.codCli = codCli;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dni = dni;
	}
	public int getCodCli() {
		return codCli;
	}
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String nombreCompleto() {
		return nombre + " " + apellido;
	}
	

}
