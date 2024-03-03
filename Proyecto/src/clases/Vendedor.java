package clases;

public class Vendedor {
	// Atributos privados
	private int codVen;
	private int categoria;
	private String nombre;
	private String apellido;
	private String telefono;
	private String dni;
	private String clave;
	// Constructor
	public Vendedor(int codVen, int categoria, String nombre, String apellido, String telefono, String dni, String clave) {
		this.codVen = codVen;
		this.categoria = categoria;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dni = dni;
		this.clave= clave;
	}
	// GETTERS AND SETTERS
	public int getCodVen() {
		return codVen;
	}
	public void setCodVen(int codVen) {
		this.codVen = codVen;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
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
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String nombreCompleto() {
		return nombre + " " + apellido;
	}
	
	
}
