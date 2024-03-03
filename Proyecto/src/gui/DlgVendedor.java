package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import arreglos.ArregloVendedor;
import clases.Vendedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.SystemColor;

public class DlgVendedor extends JDialog implements ActionListener {

	// Variable global
	ArregloVendedor av = new ArregloVendedor();

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblVendedor;
	private DefaultTableModel modelo;

	// Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;

	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;

	private JLabel lblCategora;
	private JTextField txtCategoria;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVendedor dialog = new DlgVendedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVendedor() {
		getContentPane().setBackground(SystemColor.controlHighlight);
		setTitle("Mantenimiento | Vendedor");
		setBounds(100, 100, 855, 653);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 11, 110, 23);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNombre.setBounds(10, 61, 70, 23);
		getContentPane().add(lblNombre);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblApellidos.setBounds(10, 86, 79, 23);
		getContentPane().add(lblApellidos);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblTelefono.setBounds(10, 111, 70, 23);
		getContentPane().add(lblTelefono);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblDni.setBounds(10, 136, 70, 23);
		getContentPane().add(lblDni);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 11, 86, 23);
		getContentPane().add(txtCodigo);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 61, 251, 23);
		getContentPane().add(txtNombre);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(90, 86, 251, 23);
		getContentPane().add(txtApellidos);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 111, 251, 23);
		getContentPane().add(txtTelefono);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(90, 136, 251, 23);
		getContentPane().add(txtDni);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(240, 11, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOK.addActionListener(this);
		btnOK.setEnabled(false);
		btnOK.setBounds(361, 136, 100, 23);
		getContentPane().add(btnOK);

		btnOpciones = new JButton("Opciones");
		btnOpciones.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(600, 11, 100, 98);
		getContentPane().add(btnOpciones);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(709, 11, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(709, 36, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(709, 61, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(709, 86, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 823, 388);
		getContentPane().add(scrollPane);

		tblVendedor = new JTable();
		tblVendedor.setFont(new Font("Courier New", Font.PLAIN, 14));
		scrollPane.setViewportView(tblVendedor);
		tblVendedor.setFillsViewportHeight(true);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("CATEG");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		modelo.addColumn("CLAVE");
		tblVendedor.setModel(modelo);

		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblCategora.setBounds(10, 36, 110, 23);
		getContentPane().add(lblCategora);

		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(90, 36, 86, 23);
		getContentPane().add(txtCategoria);
		
		lblNewLabel = new JLabel("Clave");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 170, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(90, 161, 251, 23);
		getContentPane().add(txtPassword);

		ajustarAnchoColumnas();
		listar();
	}

	// Declaración global

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(arg0);
		}
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarPersona();
	}

	protected void actionPerformedBtnOK(ActionEvent arg0) {
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

	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodigo.setText("");
		txtCategoria.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtPassword.setText("");

		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + av.genCodigo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtCategoria.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtCodigo.setEditable(true);
		habilitarBotones(false);
		txtCodigo.requestFocus();
	}

	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblVendedor.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(1));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(1));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(8));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(7));
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10));

	}

	void listar() {
		Vendedor x;
		modelo.setRowCount(0);
		for (int i = 0; i < av.tamanio(); i++) {
			x = av.obtener(i);
			Object fila[] = { x.getCodVen(), 
					x.getCategoria(), 
					x.getNombre(), 
					x.getApellido(), 
					x.getTelefono(),
					x.getDni(), 
					x.getClave() };
			modelo.addRow(fila);
		}
	}

	void adicionarPersona() {
		try {
			int codigo = leerCodigo();
			int categoria = leerCategoria();
			String nombre = leerNombre();
			if (nombre.length() > 0) {
				String apellido = leerApellido();
				if (apellido.length() > 0) {
					String telefono = leerTelefono();
					if (telefono.length() > 0) {
						String dni = leerDni();
						String clave = leerPassword();
						if (dni.length() > 0) {
							// Adicionar
							av.adicionar(new Vendedor(codigo, categoria, nombre, apellido, telefono, dni, clave));
							av.grabar();
							listar();
							txtCodigo.setText("" + av.genCodigo());
							txtCategoria.setText("");
							txtNombre.setText("");
							txtApellidos.setText("");
							txtTelefono.setText("");
							txtDni.setText("");
							txtPassword.setText("");
							txtCategoria.requestFocus();

						} else
							error("Ingrese DNI correcto", txtDni);
					} else
						error("Ingrese TELEFONO correcto", txtTelefono);
				} else
					error("Ingrese APELLIDO correcto", txtApellidos);
			} else
				error("Ingrese NOMBRE correcto", txtNombre);
		} catch (Exception e) {
			error("Ingrese CATEGORIA correcto", txtCategoria);
		}
			

	}

	void consultarPersona() {
		try {
			int codigo = leerCodigo();
			Vendedor x = av.buscar(codigo);
			if (x != null) {
				txtCategoria.setText(Integer.toString(x.getCategoria()));
				txtNombre.setText(x.getNombre());
				txtApellidos.setText(x.getApellido());
				txtTelefono.setText(x.getTelefono());
				txtDni.setText(x.getDni());
				txtPassword.setText(x.getClave());
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtCategoria.requestFocus();
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
			Vendedor x = av.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				int categoria = leerCategoria();
				if (nombre.length() > 0) {
					String apellido = leerApellido();
					if (apellido.length() > 0) {
						String telefono = leerTelefono();
						if (telefono.length() > 0) {
							String dni = leerDni();
							String clave = leerPassword();
							if (dni.length() > 0) {
								x.setCategoria(categoria);
								x.setNombre(nombre);
								x.setApellido(apellido);
								x.setTelefono(telefono);
								x.setDni(dni);
								x.setClave(clave);
								av.grabar();
								listar();
								txtNombre.requestFocus();
							} else
								error("Ingrese DNI correcto", txtDni);
						} else
							error("Ingrese TELEFONO correcto", txtTelefono);
					} else
						error("Ingrese APELLIDO correcto", txtApellidos);
				} else
					error("Ingrese NOMBRE correcto", txtNombre);

			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CATEGORIA correcto", txtCategoria);
		}
	}

	void eliminarPersona() {
		try {
			int codigo = leerCodigo();
			Vendedor x = av.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					av.eliminar(x);
					av.grabar();
					listar();
					btnOK.setEnabled(false);
					txtCodigo.setText("");
					txtCategoria.setText("");
					txtNombre.setText("");
					txtApellidos.setText("");
					txtTelefono.setText("");
					txtDni.setText("");
					txtPassword.setText("");
				}
			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	// Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtCategoria.setEditable(sino);
		txtNombre.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
		txtPassword.setEditable(sino);
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

	int leerCategoria() {
		return Integer.parseInt(txtCategoria.getText().trim());
	}

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	String leerApellido() {
		return txtApellidos.getText().trim();
	}

	String leerTelefono() {
		return txtTelefono.getText().trim();
	}

	String leerDni() {
		return txtDni.getText().trim();
	}
	
	String leerPassword() {
		return txtPassword.getText().trim();
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
