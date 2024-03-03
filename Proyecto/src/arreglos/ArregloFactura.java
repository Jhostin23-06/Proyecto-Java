package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Factura;

public class ArregloFactura {
	// Atributo privado
	private ArrayList<Factura> fact;

	// Constructor
	public ArregloFactura() {
		fact = new ArrayList<>();
	}

	// Métodos basicos
	public void adicionar(Factura x) {
		fact.add(x);
	}

	public Factura obtener(int pos) {
		return fact.get(pos);
	}

	public int tamanio() {
		return fact.size();
	}

	// Metodos complementarios
	// BUSCAR POR CÓDIGO
	public Factura buscar(int cod) {
		for (int i = 0; i < tamanio(); i++) {
			Factura x = obtener(i);
			if (x.getCodFact() == cod)
				return x;
		}
		return null;
	}
	public Factura buscar(int num,int pro){
		for (int i = 0; i < tamanio(); i++) {
			Factura x=obtener(i);
			if(x.getCodFact()==num && x.getCodPro()==pro)
				return x;
		}
		return null;
	}

	public void eliminar(Factura x) {
		fact.remove(x);
	}

	public int genCodigo() {
		if (tamanio() == 0)
			return 4001;
		else
			return obtener(tamanio() - 1).getCodFact() + 1;
	}
	
	public double subtotal() {
		double suma=0;
		for (int i = 0; i < tamanio(); i++) {
			Factura x = obtener(i);
			suma += Math.round(x.importe() * 100) / 100;
		}
		return suma;
	}
	
	public double IGV() {
		return 0.18 * subtotal();
	}
	
	public double total() {
		return subtotal() + IGV();
	}
	
	public void grabar() {
		try {
			String linea="";
			PrintWriter pw=new PrintWriter(new FileWriter("venta.txt"));
			for (int i = 0; i < tamanio(); i++) {
				Factura x=obtener(i);
				linea=x.getCodFact()+";"+x.getCodCli()+";"+x.getCodPro()+";"+x.getCodVen()+";"+x.getUnidades()+";"+x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void cargar() {
		try {
			String linea,fila[];
			Factura c=null;
			BufferedReader br=new BufferedReader(new FileReader("venta.txt"));
			while((linea=br.readLine())!=null) {
				fila=linea.split(";");
				int cod=Integer.parseInt(fila[0]);
				int codcli=Integer.parseInt(fila[1]);
				int codpro=Integer.parseInt(fila[2]);
				int codven=Integer.parseInt(fila[3]);
				int uni=Integer.parseInt(fila[4]);
				double pre=Double.parseDouble(fila[5]);
				c=new Factura(cod,codcli,codpro,codven,uni,pre);
				adicionar(c);				
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
