package arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Cliente;
public class ArregloClientes {
	//Atributos privados
	private ArrayList<Cliente> cli;
	//Constructor
	public ArregloClientes() {
		cli=new ArrayList<>();
		cargar();
	}
	//Métodos basicos
	public void adicionar(Cliente x){
		cli.add(x);
	}
	public Cliente obtener(int pos){
		return cli.get(pos);
	}
	public int tamanio(){
		return cli.size();
	}
	//Metodos complementarios
	public Cliente buscar(int cod){
		for (int i = 0; i < tamanio(); i++) {
			Cliente x=obtener(i);
			if(x.getCodCli()==cod)
				return x;
		}
		return null;
	}
	public void eliminar(Cliente x){
		cli.remove(x);
	}
	public int genCodigo(){
		if(tamanio()==0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodCli() +1;
	}
	
	public void grabar() {
		try {
			String linea="";
			PrintWriter pw=new PrintWriter(new FileWriter("cliente.txt"));
			for (int i = 0; i < tamanio(); i++) {
				Cliente x=obtener(i);
				linea=x.getCodCli()+";"+x.getNombre()+";"+x.getApellido()+";"+x.getTelefono()+";"+x.getDni();
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
			Cliente c=null;
			BufferedReader br=new BufferedReader(new FileReader("cliente.txt"));
			while((linea=br.readLine())!=null) {
				fila=linea.split(";");
				int cod=Integer.parseInt(fila[0]);
				String nom=fila[1];
				String ape=fila[2];
				String tel=fila[3];
				String dni=fila[4];
				c=new Cliente(cod,nom,ape,tel,dni);
				adicionar(c);				
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
