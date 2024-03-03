package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultCaret;

import arreglos.ArregloClientes;
import arreglos.ArregloFactura;
import arreglos.ArregloProducto;
import arreglos.ArregloVendedor;
import clases.Cliente;
import clases.Factura;
import clases.Producto;
import clases.TextPrompt;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class DlgFactura extends JDialog implements ActionListener {
	// Variable global
	ArregloFactura af = new ArregloFactura();
	ArregloClientes ac = new ArregloClientes();
	ArregloProducto ap = new ArregloProducto();
	ArregloVendedor av = new ArregloVendedor();

	ArregloFactura temp = new ArregloFactura();

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoFactura;
	private JLabel lblVendedor;
	private JTextField txtCodVendedor;
	private JLabel lblCliente;
	private JLabel lblCodigo;
	private JLabel lblDocumento;
	private JLabel lblApellidosNombres;
	private JTextField txtCodigo;
	private JTextField txtDocumento;
	private JTextField txtApellidosNombres;
	private JButton btnConsultar;
	private JLabel lblConsultarProductos;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JTextField txtCodPro;
	private JButton btnGrabarFactura;
	private JButton btnImprimir;
	private JButton btnNuevaVenta;
	private JTextField txtSubTotal;
	private JLabel lblSubTotal;
	private DefaultTableModel modelo;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JTextField txtNombrePro;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtNomVen;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgFactura dialog = new DlgFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgFactura() {
		getContentPane().setBackground(SystemColor.controlHighlight);
		getContentPane().setForeground(SystemColor.controlHighlight);
		setTitle("FACTURA");
		setFont(new Font("Courier New", Font.PLAIN, 20));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		// CONFIGURAR TAMAÑO Y POSICION DE LA VENTANA
		setSize(1139, 629);
		setLocationRelativeTo(null);

		JLabel lblCodigoFactura = new JLabel("FACTURA");
		lblCodigoFactura.setFont(new Font("Courier New", Font.PLAIN, 25));
		lblCodigoFactura.setBounds(10, 11, 128, 30);
		getContentPane().add(lblCodigoFactura);

		txtCodigoFactura = new JTextField();
		txtCodigoFactura.setEditable(false);
		txtCodigoFactura.setFont(new Font("Courier New", Font.PLAIN, 25));
		txtCodigoFactura.setBounds(158, 14, 100, 25);
		getContentPane().add(txtCodigoFactura);
		txtCodigoFactura.setColumns(10);

		lblVendedor = new JLabel("VENDEDOR");
		lblVendedor.setFont(new Font("Courier New", Font.PLAIN, 25));
		lblVendedor.setBounds(10, 39, 138, 30);
		getContentPane().add(lblVendedor);

		txtCodVendedor = new JTextField();
		txtCodVendedor.setEditable(false);
		txtCodVendedor.setFont(new Font("Courier New", Font.PLAIN, 25));
		txtCodVendedor.setColumns(10);
		txtCodVendedor.setBounds(158, 42, 100, 25);
		getContentPane().add(txtCodVendedor);

		lblCliente = new JLabel("DATOS DEL CLIENTE");
		lblCliente.setFont(new Font("Courier New", Font.PLAIN, 25));
		lblCliente.setBounds(545, 11, 260, 33);
		getContentPane().add(lblCliente);

		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblCodigo.setBounds(545, 40, 80, 30);
		getContentPane().add(lblCodigo);

		lblDocumento = new JLabel("DOCUMENTO");
		lblDocumento.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblDocumento.setBounds(545, 68, 120, 30);
		getContentPane().add(lblDocumento);

		lblApellidosNombres = new JLabel("NOMBRES Y APELLIDOS");
		lblApellidosNombres.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblApellidosNombres.setBounds(545, 109, 230, 30);
		getContentPane().add(lblApellidosNombres);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(667, 43, 110, 25);
		getContentPane().add(txtCodigo);

		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtDocumento.setEditable(false);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(667, 71, 110, 25);
		getContentPane().add(txtDocumento);

		txtApellidosNombres = new JTextField();
		txtApellidosNombres.setFont(new Font("Courier New", Font.PLAIN, 17));
		txtApellidosNombres.setEditable(false);
		txtApellidosNombres.setColumns(10);
		txtApellidosNombres.setBounds(785, 109, 328, 25);
		getContentPane().add(txtApellidosNombres);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setEnabled(false);
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnConsultar.setBounds(804, 40, 150, 30);
		getContentPane().add(btnConsultar);

		lblConsultarProductos = new JLabel("PRODUCTO");
		lblConsultarProductos.setFont(new Font("Courier New", Font.PLAIN, 25));
		lblConsultarProductos.setBounds(20, 149, 128, 33);
		getContentPane().add(lblConsultarProductos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 201, 879, 164);
		getContentPane().add(scrollPane);

		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Courier New", Font.PLAIN, 25));
		btnBuscar.setBounds(278, 153, 150, 25);
		getContentPane().add(btnBuscar);

		txtCodPro = new JTextField();
		txtCodPro.setFont(new Font("Courier New", Font.PLAIN, 25));
		txtCodPro.setColumns(10);
		txtCodPro.setBounds(158, 153, 110, 25);
		getContentPane().add(txtCodPro);

		btnGrabarFactura = new JButton("GRABAR FACTURA");
		btnGrabarFactura.addActionListener(this);
		btnGrabarFactura.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnGrabarFactura.setBounds(214, 551, 171, 30);
		getContentPane().add(btnGrabarFactura);

		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnImprimir.setBounds(655, 551, 150, 30);
		getContentPane().add(btnImprimir);

		btnNuevaVenta = new JButton("NUEVA FACTURA");
		btnNuevaVenta.addActionListener(this);
		btnNuevaVenta.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnNuevaVenta.setBounds(35, 551, 169, 30);
		getContentPane().add(btnNuevaVenta);

		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(1026, 550, 80, 30);
		getContentPane().add(txtSubTotal);

		lblSubTotal = new JLabel("SUB TOTAL");
		lblSubTotal.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblSubTotal.setBounds(896, 549, 120, 30);
		getContentPane().add(lblSubTotal);

		modelo = new DefaultTableModel();

		modelo.addColumn("CÓDIGO");
		modelo.addColumn("PRODUCTO");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("PRECIO");
		modelo.addColumn("IMPORTE");

		tblProductos.setModel(modelo);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(941, 151, 128, 30);
		getContentPane().add(btnAgregar);

		btnQuitar = new JButton("QUITAR");
		btnQuitar.addActionListener(this);
		btnQuitar.setFont(new Font("Courier New", Font.PLAIN, 20));
		btnQuitar.setBounds(941, 192, 128, 30);
		getContentPane().add(btnQuitar);

		txtNombrePro = new JTextField();
		txtNombrePro.setEditable(false);
		txtNombrePro.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtNombrePro.setColumns(10);
		txtNombrePro.setBounds(452, 154, 175, 25);
		getContentPane().add(txtNombrePro);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(640, 154, 110, 25);
		TextPrompt txtPHPrecio = new TextPrompt("Precio", txtPrecio);
		txtPHPrecio.changeAlpha(0.05f);
		txtPHPrecio.changeStyle(Font.MONOSPACED.hashCode());
		txtPHPrecio.changeAlpha(150);
		getContentPane().add(txtPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(770, 154, 110, 25);
		TextPrompt txtPHCantidad = new TextPrompt("Cantidad", txtCantidad);
		txtPHCantidad.changeAlpha(0.05f);
		txtPHCantidad.changeStyle(Font.MONOSPACED.hashCode());
		txtPHCantidad.changeAlpha(150);
		getContentPane().add(txtCantidad);

		txtNomVen = new JTextField();
		txtNomVen.setFont(new Font("Courier New", Font.PLAIN, 25));
		txtNomVen.setEditable(false);
		txtNomVen.setColumns(10);
		txtNomVen.setBounds(268, 42, 223, 25);
		getContentPane().add(txtNomVen);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 376, 881, 164);
		getContentPane().add(scrollPane_1);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Courier New", Font.PLAIN, 14));
		DefaultCaret caret=new DefaultCaret();//Nueva instancia del caret
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);//Evita el scroll hacia abajo
		txtS.setCaret(caret);//Cada area de texto con el nuevo caret
		scrollPane_1.setViewportView(txtS);
		ajustarAnchoColumnas();
		af.cargar();
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabarFactura) {
			actionPerformedBtnGrabarFactura(e);
		}
		if (e.getSource() == btnQuitar) {
			actionPerformedBtnQuitar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnNuevaVenta) {
			actionPerformedBtnNuevaVenta(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnNewButton(e);
		}

	}
	
	protected void actionPerformedBtnNuevaVenta(ActionEvent e) {
		nuevaFactura();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		buscarCliente();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarProducto();
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		agregarProducto();
	}
	
	protected void actionPerformedBtnQuitar(ActionEvent e) {
		quitarProducto();
	}
	
	protected void actionPerformedBtnGrabarFactura(ActionEvent e) {
		grabarFactura();
	}
	
	private void nuevaFactura() {
		limpiar();
		txtCodigoFactura.setText(af.genCodigo() + "");
		txtCodVendedor.setText(av.obtener(0).getCodVen() + "");
		txtNomVen.setText(av.obtener(0).nombreCompleto());
		temp = new ArregloFactura();
		btnConsultar.setEnabled(true);
		btnBuscar.setEnabled(false);
		btnAgregar.setEnabled(false);
		btnQuitar.setEnabled(false);
		btnGrabarFactura.setEnabled(false);
		modelo.setRowCount(0);
		txtCodigo.requestFocus();
	}
	
	private void buscarCliente() {
		try {
			int codCli = leerCodCli();
			Cliente x = ac.buscar(codCli);
			if (x != null) {
				txtDocumento.setText(x.getDni());
				txtApellidosNombres.setText(x.nombreCompleto());
				btnBuscar.setEnabled(true);
				txtCodPro.requestFocus();
			} else {
				error("El código de cliente no existe", txtCodigo);
			}
		} catch (Exception e) {
			error("Ingrese el código de cliente", txtCodigo);
		}
	}

	private void buscarProducto() {
		try {
			int codPro = leerCodPro();
			Producto p = ap.buscar(codPro);
			if (p != null) {
				txtNombrePro.setText(p.getDescripcion());
				txtPrecio.setText(p.getPrecio() + "");
				btnAgregar.setEnabled(true);
				txtCantidad.requestFocus();
			} else {
				error("El código de producto no existe", txtCodPro);
			}
		} catch (Exception e) {
			error("Ingrese el código de producto", txtCodPro);
		}
	}
	
	private void agregarProducto() {
		int num = leerFactura();
		int codven = av.obtener(0).getCodVen();
		try {
			int codcli = leerCodCli();
			try {
				int codpro = leerCodPro();
				try {
					int can = leerCantidad();
					double pre = leerPrecio();
					Factura v = new Factura(num, codcli, codpro, codven, can, pre);
					if (temp.buscar(num, codpro) == null) {
						temp.adicionar(v);
						listar();
						txtSubTotal.setText(temp.subtotal() + "");
						btnQuitar.setEnabled(true);
						btnGrabarFactura.setEnabled(true);
						txtCodPro.requestFocus();
					}

				} catch (Exception e) {
					error("Ingrese la cantidad.", txtCantidad);
				}

			} catch (Exception e) {
				error("Ingrese codigo del producto.", txtCodPro);
			}

		} catch (Exception e) {
			error("Ingrese codigo del cliente.", txtCodigo);
		}
	}
	
	private void quitarProducto() {
		if(temp.tamanio()>0) {
			int fila=tblProductos.getSelectedRow();
			if(fila>=0) {
				int num=leerFactura();
				int codlib=Integer.parseInt(tblProductos.getValueAt(fila, 0).toString());
				Factura x=temp.buscar(num,codlib);
				if(x!=null) {
					temp.eliminar(x);
					listar();
					txtSubTotal.setText(temp.subtotal()+"");
				}				
			}else {
				mensaje("Seleccionar una fila");
			}
		}
	}
	
	private void grabarFactura() {			
		if(temp.tamanio()>0) {
			for (int i = 0; i < temp.tamanio(); i++) {
				Factura x=temp.obtener(i);			
				af.adicionar(x);
			}
			af.grabar();
			listado();
			nuevaFactura();
		}		
	}
	
	void listado() {
		txtS.setText("DETALLE FACTURA" + "\n");
		txtS.append("Código de cliente        : " + leerCodigoCliente() + "\n");
		txtS.append("Código de vendedor       : " + leerCodigoVendedor() + "\n");
		txtS.append("Código de producto       : " + leerCodPro() + "\n");
		txtS.append("Descripción del producto : " + leerDescripcion() + "\n");
		txtS.append("Precio unitario          : " + leerPrecio() + "\n");
		txtS.append("Importe subtotal         : " + leerTotal() + "\n");
		txtS.append("Importe del IGV          : " + Math.round((leerTotal() *  0.18) * 100)/100 + "\n");
		txtS.append("Total a pagar            : " + ( leerTotal() + (leerTotal() * 0.18)) + "\n");
	}
	
	
	
	void listar() {
		Factura x;
		modelo.setRowCount(0);
		for (int i = 0; i < temp.tamanio(); i++) {
			x = temp.obtener(i);
			Object fila[] = { x.getCodPro(), ap.buscar(x.getCodPro()).getDescripcion(), x.getPrecio(), x.getUnidades(),
					x.importe() };
			modelo.addRow(fila);
		}
	}

	void limpiar() {
		txtCodigo.setText("");
		txtDocumento.setText("");
		txtApellidosNombres.setText("");
		txtCodPro.setText("");
		txtNombrePro.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtSubTotal.setText("");
	}

	public String leerCodigoCliente() {
		return txtCodigo.getText().trim();
	}

	// Metodos de entrada
	int leerFactura() {
		return Integer.parseInt(txtCodigoFactura.getText());
	}

	int leerCodCli() {
		return Integer.parseInt(txtCodigo.getText());
	}
	
	int leerCodigoVendedor() {
		return Integer.parseInt(txtCodVendedor.getText());
	}

	int leerCodPro() {
		return Integer.parseInt(txtCodPro.getText());
	}
	
	String leerDescripcion() {
		return txtNombrePro.getText();
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	double leerTotal() {
		return Double.parseDouble(txtSubTotal.getText());
	}

	

	// Configurar tabla
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProductos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(45));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));
	}

	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	double ajustar(double numero) {
		return (int) (numero * 10) / 10.0;
	}

	// Metodos Utiles
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}