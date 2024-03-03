package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import arreglos.ArregloReportes;
import java.awt.SystemColor;

public class DlgReporte extends JDialog implements ActionListener {
	
	ArregloReportes ar=new ArregloReportes();
	
	private final JPanel contentPanel = new JPanel();
	private JComboBox cboTipo;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JLabel lblNewLabel;
	private JLabel lblCodigo;
	private JTextField txtCodigo;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporte dialog = new DlgReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporte() {
		setTitle("Reportes");
		setBounds(100, 100, 558, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboTipo = new JComboBox();
		cboTipo.setFont(new Font("Courier New", Font.PLAIN, 14));
		cboTipo.addActionListener(this);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Reporte  general  por  productos", "Reporte general por vendedores", "Reporte por Vendedor", "Reporte por Producto", "Reporte de precios"}));
		cboTipo.setBounds(98, 15, 305, 25);
		contentPanel.add(cboTipo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 522, 361);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Courier New", Font.PLAIN, 13));
		DefaultCaret caret=new DefaultCaret();//Nueva instancia del caret
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);//Evita el scroll hacia abajo
		txtS.setCaret(caret);//Cada area de texto con el nuevo caret
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(429, 15, 89, 25);
		contentPanel.add(btnProcesar);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 15, 78, 25);
		contentPanel.add(lblNewLabel);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		lblCodigo.setVisible(false);
		lblCodigo.setBounds(10, 45, 78, 25);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtCodigo.setVisible(false);
		txtCodigo.setBounds(98, 45, 305, 25);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipo) {
			actionPerformedCboTipo(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	public void actionPerformedBtnProcesar(ActionEvent e) {
		txtS.setText("");
		switch(leerTipo()) {
		case 0:	
			imprimir(ar.reporteGeneralProducto());
			break;
		case 1:	
			imprimir(ar.reporteGeneralVendedores());
			break;
		case 2:
			try {
				int codven=leerCodigo();
				imprimir(ar.reporteVendedores(codven));
			} catch (Exception e2) {
				error("Ingrese codigo vendedor.",txtCodigo);
			}
			break;
		case 3:	
			try {
				int codpro=leerCodigo();
				imprimir(ar.reporteProducto(codpro));
			} catch (Exception e2) {
				error("Ingrese codigo producto.",txtCodigo);
			}
			break;
		case 4:
			imprimir(ar.reportePrecios());
			break;
		}
	}
	
	void imprimir(String str) {
		txtS.append(str+"\n");
	}
	
	protected void actionPerformedCboTipo(ActionEvent e) {
		switch(leerTipo()) {
		case 2:
		case 3:
		case 5:
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			break;
		default:
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			break;
		}
	}
	
	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}
	int  leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}


}
