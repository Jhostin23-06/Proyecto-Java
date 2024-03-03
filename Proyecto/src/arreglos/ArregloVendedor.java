package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Vendedor;

public class ArregloVendedor {
	// Atributos privados
	private ArrayList<Vendedor> cli;

	// Constructor
	public ArregloVendedor() {
		cli = new ArrayList<>();
		cargar();
	}

	// Métodos basicos
	public void adicionar(Vendedor x) {
		cli.add(x);
	}

	public Vendedor obtener(int pos) {
		return cli.get(pos);
	}

	public int tamanio() {
		return cli.size();
	}

	// Metodos complementarios
	public Vendedor buscar(int cod) {
		for (int i = 0; i < tamanio(); i++) {
			Vendedor x = obtener(i);
			if (x.getCodVen() == cod)
				return x;
		}
		return null;
	}

	public void eliminar(Vendedor x) {
		cli.remove(x);
	}

	public int genCodigo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio() - 1).getCodVen() + 1;
	}
	
	public void grabar() {
		try {
			String linea="";
			PrintWriter pw=new PrintWriter(new FileWriter("vendedor.txt"));
			for (int i = 0; i < tamanio(); i++) {
				Vendedor x=obtener(i);
				linea=x.getCodVen()+";"+x.getCategoria()+";"+x.getNombre()+";"+x.getApellido()+";"+x.getTelefono()+";"+x.getDni()+";"+x.getClave();
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
			Vendedor c=null;
			BufferedReader br=new BufferedReader(new FileReader("vendedor.txt"));
			while((linea=br.readLine())!=null) {
				fila=linea.split(";");
				int cod=Integer.parseInt(fila[0]);
				int cat=Integer.parseInt(fila[1]);
				String nom=fila[2];
				String ape=fila[3];
				String tel=fila[4];
				String dni=fila[5];
				String cla=fila[6];
				c=new Vendedor(cod,cat,nom,ape,tel,dni,cla);
				adicionar(c);				
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
