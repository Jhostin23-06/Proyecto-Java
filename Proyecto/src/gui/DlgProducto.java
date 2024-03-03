package gui;

import javax.swing.JButton;
import javax.swing.JDialog;

import arreglos.ArregloProducto;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class DlgProducto extends JDialog implements ActionListener {

	// Variable global
	ArregloProducto ap = new ArregloProducto();

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JLabel lblPrecio;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblProducto;
	private DefaultTableModel modelo;
	// Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;

	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;

	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		getContentPane().setBackground(SystemColor.controlHighlight);
		getContentPane().setFont(new Font("Courier New", Font.PLAIN, 14));
		setTitle("Mantenimiento | Producto");
		setBounds(100, 100, 650, 567);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 15, 110, 23);
		getContentPane().add(lblCodigo);

		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 40, 110, 23);
		getContentPane().add(lblDescripcion);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 65, 70, 23);
		getContentPane().add(lblPrecio);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(111, 15, 86, 23);
		getContentPane().add(txtCodigo);

		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(111, 40, 128, 23);
		getContentPane().add(txtDescripcion);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(111, 65, 86, 23);
		getContentPane().add(txtPrecio);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(239, 11, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOK.addActionListener(this);
		btnOK.setEnabled(false);
		btnOK.setBounds(240, 90, 100, 23);
		getContentPane().add(btnOK);

		btnOpciones = new JButton("Opciones");
		btnOpciones.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(397, 15, 100, 98);
		getContentPane().add(btnOpciones);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(506, 15, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(506, 40, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(506, 65, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(506, 90, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 616, 386);
		getContentPane().add(scrollPane);

		tblProducto = new JTable();
		tblProducto.setFont(new Font("Courier New", Font.PLAIN, 15));
		scrollPane.setViewportView(tblProducto);
		tblProducto.setFillsViewportHeight(true);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("DESCRIPCIÓN");
		modelo.addColumn("PRECIO");
		tblProducto.setModel(modelo);

		ajustarAnchoColumnas();
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}

	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + ap.genCodigo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtDescripcion.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnOK(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarPersona();
			break;
		case CONSULTAR:
			consultarPersona();
			break;
		case MODIFICAR:
			modificarPersona();
			break;
		case ELIMINAR:
			eliminarPersona();
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarPersona();
	}

	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtCodigo.setText("");
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");

		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblProducto.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(2));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(70));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(2));

	}

	void listar() {
		Producto x;
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamanio(); i++) {
			x = ap.obtener(i);
			Object fila[] = { x.getCodigoProducto(), x.getDescripcion(), x.getPrecio() };
			modelo.addRow(fila);
		}
	}

	void adicionarPersona() {
		try {
			int codigo = leerCodigo();

			String descripcion = leerDescripcion();
			if (descripcion.length() > 0) {
				double precio = leerPrecio();
				if (precio > 0) {
					// Adicionar
					ap.adicionar(new Producto(codigo, descripcion, precio));
					ap.grabar();
					listar();
					txtCodigo.setText("" + ap.genCodigo());
					txtDescripcion.setText("");
					txtPrecio.setText("");
					txtDescripcion.requestFocus();
				}
			} else
				error("Ingrese DESCRIPCION correcto", txtDescripcion);

		} catch (Exception e) {
			error("Ingrese PRECIO correctamente", txtPrecio);
		}

	}

	void consultarPersona() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				txtDescripcion.setText(x.getDescripcion());
				txtPrecio.setText(Double.toString(x.getPrecio()));
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtDescripcion.requestFocus();
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
				}
			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	void modificarPersona() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				String descripcion = leerDescripcion();
				double precio = leerPrecio();
				if (descripcion.length() > 0) {
					ap.grabar();
					x.setDescripcion(descripcion);
					x.setPrecio(precio);
					
					listar();
					txtDescripcion.requestFocus();
				}

			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese DESCRIPCIÓN correcto", txtDescripcion);
		}
	}

	void eliminarPersona() {
		try {
			int codigo = leerCodigo();
			Producto x = ap.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ap.eliminar(x);
					ap.grabar();
					listar();
					btnOK.setEnabled(false);
					txtCodigo.setText("");
					txtDescripcion.setText("");
					txtPrecio.setText("");
				}
			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	// Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtDescripcion.setEditable(sino);
		txtPrecio.setEditable(sino);
	}

	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ADICIONAR)
			btnOK.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOK.setEnabled(false);
		}
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.requestFocus();
	}

	// Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}

	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}

	Double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	// Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	double ajustar(double numero) {
		return (int) (numero * 10) / 10.0;
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
