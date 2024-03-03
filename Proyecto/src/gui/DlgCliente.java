package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloClientes;
import clases.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class DlgCliente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//Variable global
	ArregloClientes ac=new ArregloClientes();
	
	
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JButton btnOK;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblPersona;
	private DefaultTableModel modelo;

	// Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;

	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCliente dialog = new DlgCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		getContentPane().setBackground(SystemColor.controlHighlight);
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNombre.setBounds(10, 35, 70, 23);
		getContentPane().add(lblNombre);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtCodigo.setBounds(107, 10, 86, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtNombre.setBounds(107, 36, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(257, 11, 101, 23);
		getContentPane().add(btnBuscar);

		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOK.addActionListener(this);
		btnOK.setEnabled(false);
		btnOK.setBounds(257, 136, 100, 23);
		getContentPane().add(btnOK);

		btnOpciones = new JButton("Opciones");
		btnOpciones.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(555, 10, 100, 98);
		getContentPane().add(btnOpciones);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(664, 10, 120, 23);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(664, 35, 120, 23);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(664, 60, 120, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(664, 85, 120, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 775, 390);
		getContentPane().add(scrollPane);

		tblPersona = new JTable();
		tblPersona.setFont(new Font("Courier New", Font.PLAIN, 15));
		scrollPane.setViewportView(tblPersona);
		tblPersona.setFillsViewportHeight(true);
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		tblPersona.setModel(modelo);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblApellidos.setBounds(10, 60, 87, 23);
		getContentPane().add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(107, 61, 251, 23);
		getContentPane().add(txtApellidos);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblTelefono.setBounds(10, 85, 70, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(107, 86, 251, 23);
		getContentPane().add(txtTelefono);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblDni.setBounds(10, 110, 70, 23);
		getContentPane().add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(107, 111, 251, 23);
		getContentPane().add(txtDni);

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
		txtNombre.setText("");

		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtCodigo.setText("" + ac.genCodigo());
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
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
		TableColumnModel tcm = tblPersona.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));

	}

	void listar() {
		Cliente x;
		modelo.setRowCount(0);		
		for (int i = 0; i < ac.tamanio(); i++) {
			 x=ac.obtener(i);
			Object fila[]={
					x.getCodCli()
					,x.getNombre()
					,x.getApellido()
					,x.getTelefono()
					,x.getDni()
					};
			modelo.addRow(fila);
		}
	}

	void adicionarPersona() {
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String apellido = leerApellido();
			if (apellido.length() > 0) {
				String telefono = leerTelefono();
				if (telefono.length() > 0) {
					String dni = leerDni();
					if (dni.length() > 0) {
						//Adicionar
						ac.adicionar(new Cliente(codigo, nombre, apellido, telefono, dni));
						ac.grabar();
						listar();
						txtCodigo.setText(""+ac.genCodigo());
						txtNombre.setText("");
						txtApellidos.setText("");
						txtTelefono.setText("");
						txtDni.setText("");
						txtNombre.requestFocus();	

					}else
						error("Ingrese DNI correcto", txtDni);
				}else
				error("Ingrese TELEFONO correcto", txtTelefono);
			} else
				error("Ingrese APELLIDO correcto", txtApellidos);
		} else
			error("Ingrese NOMBRE correcto", txtNombre);
	}

	void consultarPersona() {
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombre());
				txtApellidos.setText(x.getApellido());
				txtTelefono.setText(x.getTelefono());
				txtDni.setText(x.getDni());
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodigo.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOK.setEnabled(true);
					txtNombre.requestFocus();
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
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				String nombre=leerNombre();
				if(nombre.length()>0){
					String apellido=leerApellido();
					if(apellido.length()>0){
						String telefono=leerTelefono();
						if(telefono.length()>0){
							String dni=leerDni();
							if(dni.length()>0){
								x.setNombre(nombre);
								x.setApellido(apellido);
								x.setTelefono(telefono);
								x.setDni(dni);
								ac.grabar();
								listar();
								txtNombre.requestFocus();
							}else
								error("Ingrese DNI correcto", txtCodigo);							
						}else
							error("Ingrese TELEFONO correcto", txtCodigo);						
					}else
						error("Ingrese APELLIDO correcto", txtCodigo);					
				} else
					error("Ingrese NOMBRE correcto", txtCodigo);				

			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	void eliminarPersona() {
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ac.eliminar(x);	
					ac.grabar();
					listar();
					btnOK.setEnabled(false);
				}
			} else
				error("El código " + codigo + " no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodigo);
		}
	}

	// Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
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
		txt.setText("");
		txt.requestFocus();
	}

	// Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
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