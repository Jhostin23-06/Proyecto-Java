package arreglos;

import clases.Factura;
import clases.Producto;
import clases.Vendedor;

public class ArregloReportes {
	ArregloFactura af = new ArregloFactura();
	ArregloClientes ac = new ArregloClientes();
	ArregloProducto ap = new ArregloProducto();
	ArregloVendedor av = new ArregloVendedor();

	public ArregloReportes() {
		af.cargar();
	}

	public String reporteGeneralProducto() {
		int c = 0, cv = 0;
		double tp = 0;
		String r = "";
		for (int i = 0; i < ap.tamanio(); i++) {
			Producto p = ap.obtener(i);
			for (int j = 0; j < af.tamanio(); j++) {
				Factura f = af.obtener(j);
				if (p.getCodigoProducto() == f.getCodPro()) {
					c += f.getUnidades();
					cv++; //
					tp += f.importe();
				}
			}
			r += p.getCodigoProducto() + " - " + p.getDescripcion() + "\n";
			r += "-----------------------------------\n";
			r += "Cantidad de ventas   : " + cv + "\n";
			r += "Cantidad de unidades : " + c + "\n";
			r += "Total pagado         : " + tp + "\n";
			r += "\n";
			c = 0;
			cv = 0;
			tp = 0;
		}
		return r;
	}

	public String reporteGeneralVendedores() {
		int c = 0, cv = 0;
		double it = 0;
		String r = "";
		for (int i = 0; i < av.tamanio(); i++) {
			Vendedor v = av.obtener(i);
			for (int j = 0; j < af.tamanio(); j++) {
				Factura f = af.obtener(j);
				if (v.getCodVen() == f.getCodVen()) {
					c += f.getUnidades();
					cv++;
					it += f.importe();
				}
			}
			r += v.getCodVen() + " - " + v.nombreCompleto() + "\n";
			r += "-----------------------------------\n";
			r += "Cantidad de ventas   : " + cv + "\n";
			r += "Cantidad de unidades : " + c + "\n";
			r += "Total pagado         : " + it + "\n";
			r += "\n";
			c = 0;
			cv = 0;
			it = 0;
		}
		return r;
	}

	public String reporteProducto(int codpro) {
		String r = "";
		for (int j = 0; j < af.tamanio(); j++) {
			Factura f = af.obtener(j);
			if (codpro == f.getCodPro()) {
				r += codpro + " - " + ap.buscar(codpro).getDescripcion() + "\n";
				r += "-----------------------------------\n";
				r += "Num. Factura  : " + f.getCodFact() + "\n";
				r += "Vendedor      : " + f.getCodVen() + "\n";
				r += "Unidades      : " + f.getUnidades() + "\n";
				r += "Precio        : " + f.getPrecio() + "\n";
				r += "\n";
			}
		}
		return r;
	}

	public String reporteVendedores(int codven) {
		String r = "";
		for (int i = 0; i < af.tamanio(); i++) {
			Factura f = af.obtener(i);
			if (codven == f.getCodVen()) {
				r += codven + " - " + av.buscar(codven).nombreCompleto() + "\n";
				r += "-----------------------------------\n";
				r += "Num. Factura  : " + f.getCodFact() + "\n";
				r += "Producto      : " + f.getCodPro() + "\n";
				r += "Unidades      : " + f.getUnidades() + "\n";
				r += "Precio        : " + f.getPrecio() + "\n";
				r += "\n";
			}
		}
		return r;
	}

	public String reportePrecios() {
		String r = "";
		r += "Precio promedio : " + Math.round(precioPromedio() / ap.tamanio()) + "\n";
		r += "Precio mayor    : " + precioMayor() + "\n";
		r += "Precio menor    : " + precioMenor();
		return r;
	}

	public double precioPromedio() {
		int pre = 0;
		for (int i = 0; i < ap.tamanio(); i++) {
			Producto p = ap.obtener(i);
			pre += p.getPrecio();
		}
		return pre;
	}

	public double precioMayor() {
		double mayor = ap.obtener(0).getPrecio();
		for (int i = 0; i < ap.tamanio(); i++) {
			if (ap.obtener(i).getPrecio() > mayor) {
					mayor = ap.obtener(i).getPrecio();
			}
		}
		return mayor;
	}
	
	public double precioMenor() {
		double menor = ap.obtener(0).getPrecio();
		for (int i = 0; i < ap.tamanio(); i++) {
			if (ap.obtener(i).getPrecio() < menor) {
				menor = ap.obtener(i).getPrecio();
			}
		}
		return menor;
	}
	
}
