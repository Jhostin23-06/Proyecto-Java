package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloVendedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {
	// Variable global
	ArregloVendedor av = new ArregloVendedor();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_1;
	private JButton btnIngresar;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.DARK_GRAY);
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 65, 65, 14);
		contentPane.add(lblNewLabel);

		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblContrasea.setBounds(40, 90, 80, 14);
		contentPane.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(142, 63, 105, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblNewLabel_1 = new JLabel("Inicio Sesi\u00F3n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(149, 11, 121, 20);
		contentPane.add(lblNewLabel_1);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(SystemColor.window);
		btnIngresar.setBackground(SystemColor.textHighlight);
		btnIngresar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnIngresar.setBounds(321, 63, 89, 23);
		contentPane.add(btnIngresar);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(142, 88, 105, 20);
		contentPane.add(txtPassword);
		
		setSize(466,227);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent arg0) {

		if (txtUsuario.getText().equals("Jhostin") || txtPassword.getText().equals("123456")) {
			dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido al sistema de venta", "Ingresaste",
					JOptionPane.INFORMATION_MESSAGE);
			Tienda t = new Tienda();
			t.setVisible(true);
		} else
		JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
}
