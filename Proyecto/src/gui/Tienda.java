package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloVendedor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Tienda extends JFrame implements ActionListener {
	
	ArregloVendedor av = new ArregloVendedor();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmProductos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmFactura;
	private JMenuItem mntmGenerarReportes;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//constructor
	public Tienda() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 607);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmVendedores = new JMenuItem("Vendedores");
		mntmVendedores.addActionListener(this);
		mnMantenimiento.add(mntmVendedores);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmFactura = new JMenuItem("Factura");
		mntmFactura.addActionListener(this);
		mnVentas.add(mntmFactura);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnReportes.add(mntmGenerarReportes);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//Configurar tienda
		setTitle("Tienda v.1.0");
		setSize(1202,712);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(arg0);
		}
		if (arg0.getSource() == mntmFactura) {
			actionPerformedMntmFactura(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmProductos) {
			actionPerformedMntmProductos(arg0);
		}
		if (arg0.getSource() == mntmVendedores) {
			actionPerformedMntmVendedores(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}
	}
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
		DlgCliente c = new DlgCliente();
		c.setVisible(true);
		c.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmVendedores(ActionEvent arg0) {
		DlgVendedor v = new DlgVendedor();
		v.setVisible(true);
		v.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmProductos(ActionEvent arg0) {
		DlgProducto p = new DlgProducto();
		p.setVisible(true);
		p.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		dispose();
		Login l = new Login();
		l.setVisible(true);
	}
	protected void actionPerformedMntmFactura(ActionEvent arg0) {
		DlgFactura f = new DlgFactura();
		f.setVisible(true);
		f.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent arg0) {
		DlgReporte r = new DlgReporte();
		r.setVisible(true);
		r.setLocationRelativeTo(this);
	}
}
