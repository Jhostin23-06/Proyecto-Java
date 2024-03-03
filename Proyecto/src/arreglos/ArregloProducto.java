package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Producto;

public class ArregloProducto {
	// Atributos privados
	private ArrayList<Producto> pro;

	// Constructor
	public ArregloProducto() {
		pro = new ArrayList<>();
		cargar();
	}

	// Métodos basicos
	public void adicionar(Producto x) {
		pro.add(x);
	}

	public Producto obtener(int pos) {
		return pro.get(pos);
	}

	public int tamanio() {
		return pro.size();
	}

	// Metodos complementarios
	public Producto buscar(int cod) {
		for (int i = 0; i < tamanio(); i++) {
			Producto x = obtener(i);
			if (x.getCodigoProducto() == cod)
				return x;
		}
		return null;
	}

	public void eliminar(Producto x) {
		pro.remove(x);
	}

	public int genCodigo() {
		if (tamanio() == 0)
			return 3001;
		else
			return obtener(tamanio() - 1).getCodigoProducto() + 1;
	}
	
	public void grabar() {
		try {
			String linea="";
			PrintWriter pw=new PrintWriter(new FileWriter("producto.txt"));
			for (int i = 0; i < tamanio(); i++) {
				Producto x=obtener(i);
				linea=x.getCodigoProducto()+";"+x.getDescripcion()+";"+x.getPrecio();
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
			Producto c=null;
			BufferedReader br=new BufferedReader(new FileReader("producto.txt"));
			while((linea=br.readLine())!=null) {
				fila=linea.split(";");
				int cod=Integer.parseInt(fila[0]);
				String des=fila[1];
				double pre=Double.parseDouble(fila[2]);
				c=new Producto(cod,des,pre);
				adicionar(c);				
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
