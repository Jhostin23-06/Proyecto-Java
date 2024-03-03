package clases;

public class Factura {
	private int codFact;
	private int codCli;
	private int codPro;
	private int codVen;
	private int unidades;
	private double precio;
	public Factura() {
	}
	// CONSTRUCTOR
	public Factura(int codFact, int codCli, int codPro, int codVen, int unidades, double precio) {
		super();
		this.codFact = codFact;
		this.codCli = codCli;
		this.codPro = codPro;
		this.codVen = codVen;
		this.unidades = unidades;
		this.precio = precio;
	}
	// GETTERS AND SETTERS
	public int getCodFact() {
		return codFact;
	}
	public void setCodFact(int codFact) {
		this.codFact = codFact;
	}
	public int getCodCli() {
		return codCli;
	}
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	public int getCodPro() {
		return codPro;
	}
	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}
	public int getCodVen() {
		return codVen;
	}
	public void setCodVen(int codVen) {
		this.codVen = codVen;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double importe() {
		return precio * unidades;
	}
	
	
}
