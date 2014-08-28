package gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import negocio.*;
import entidades.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.peer.MenuPeer;

import javax.swing.JTable;

public class Presentacion {

	
	private JFrame Menu_Principal;
	private JFrame Listado;
	private JFrame Lavarropas;
	private JFrame Televisor;
	private JFrame Alta_Electrodomestico;
	private JTextField textprecio;
	private JTextField txtcolor;
	private JTextField txtconsumo;
	private JTextField textpeso;
	private JTextField textcarga;
	private JComboBox cboElectrodomesticos;
	private JLabel lblEtiqueta;
	private JScrollPane scrollPane;
	private ControladorAltaElectrodomestico ce = new ControladorAltaElectrodomestico();
	private JTextField textResolucion;
	private JTextField textSintonizador;
	private xTableModelElectrodomesticos xt= new xTableModelElectrodomesticos();
	private JTable table;
	private JMenuItem mntmMenuPrincipal;
	private JMenuItem mntmMenuPrincipal_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentacion window = new Presentacion();
					window.Listado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Presentacion() {
		Listado();
	}
	private void Alta_Electrodomestico() {
		Alta_Electrodomestico = new JFrame();
		Alta_Electrodomestico.setBounds(100, 100, 450, 300);
		Alta_Electrodomestico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Alta_Electrodomestico.getContentPane().setLayout(null);
		
		JButton btnLavarropas_1 = new JButton("Lavarropas");
		btnLavarropas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lavarropas();
				Alta_Electrodomestico.setVisible(false);
			}
		});
		btnLavarropas_1.setBounds(60, 102, 123, 23);
		Alta_Electrodomestico.getContentPane().add(btnLavarropas_1);
		
		JButton btnTelevision = new JButton("Television");
		btnTelevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Televisor();
				Alta_Electrodomestico.setVisible(false);
			}
		});
		btnTelevision.setBounds(290, 102, 123, 23);
		Alta_Electrodomestico.getContentPane().add(btnTelevision);
		Alta_Electrodomestico.setVisible(true);
	}
	private void Menu_Principal() {
		Menu_Principal = new JFrame();
		Menu_Principal.setBounds(100, 100, 450, 300);
		Menu_Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu_Principal.getContentPane().setLayout(null);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listado();
			}
		});
		btnBaja.setBounds(164, 79, 89, 23);
		Menu_Principal.getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(293, 79, 89, 23);
		Menu_Principal.getContentPane().add(btnModificar);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu_Principal.setVisible(false);
				Listado();
			}
		});
		btnListado.setBounds(164, 165, 89, 23);
		Menu_Principal.getContentPane().add(btnListado);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alta_Electrodomestico();
				Menu_Principal.setVisible(false);
			}
		});
		btnAlta.setBounds(38, 79, 89, 23);
		Menu_Principal.getContentPane().add(btnAlta);
	}
	private void Lavarropas() {

		Lavarropas = new JFrame();
		Lavarropas.setBounds(100, 100, 450, 300);
		Lavarropas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lavarropas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Precio Base");
		lblNewLabel.setBounds(61, 91, 60, 14);
		Lavarropas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Color");
		lblNewLabel_1.setBounds(61, 116, 46, 14);
		Lavarropas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consumo Energetico");
		lblNewLabel_2.setBounds(61, 141, 103, 14);
		Lavarropas.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(61, 166, 46, 14);
		Lavarropas.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Carga");
		lblNewLabel_4.setBounds(61, 191, 46, 14);
		Lavarropas.getContentPane().add(lblNewLabel_4);
		
		textprecio = new JTextField();
		textprecio.setText("100");
		textprecio.setBounds(200, 88, 86, 20);
		Lavarropas.getContentPane().add(textprecio);
		textprecio.setColumns(10);
		
		txtcolor = new JTextField();
		txtcolor.setText("blanco");
		txtcolor.setBounds(200, 113, 86, 20);
		Lavarropas.getContentPane().add(txtcolor);
		txtcolor.setColumns(10);
		
		txtconsumo = new JTextField();
		txtconsumo.setText("F");
		txtconsumo.setBounds(200, 138, 86, 20);
		Lavarropas.getContentPane().add(txtconsumo);
		txtconsumo.setColumns(10);
		
		textpeso = new JTextField();
		textpeso.setText("5");
		textpeso.setBounds(200, 163, 86, 20);
		Lavarropas.getContentPane().add(textpeso);
		textpeso.setColumns(10);
		
		textcarga = new JTextField();
		textcarga.setText("5");
		textcarga.setBounds(200, 188, 86, 20);
		Lavarropas.getContentPane().add(textcarga);
		textcarga.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Lavarropas l=new Lavarropas(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
						ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),Double.parseDouble(textcarga.getText()));
				ce.altaElectrodomestico(l);
				
				Menu_Principal.setVisible(true);
				Lavarropas.setVisible(false);
			}
		});
		btnNewButton.setBounds(319, 215, 89, 23);
		Lavarropas.getContentPane().add(btnNewButton);
		
		mntmMenuPrincipal = new JMenuItem("Menu Principal");
		mntmMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu_Principal.setVisible(true);
				Lavarropas.setVisible(false);
			}
		});
		mntmMenuPrincipal.setBounds(0, 0, 107, 19);
		Lavarropas.getContentPane().add(mntmMenuPrincipal);
		Lavarropas.setVisible(true);
		}
	private void Televisor() {
		Televisor = new JFrame();
		Televisor.setBounds(100, 100, 450, 300);
		Televisor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Televisor.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Precio Base");
		lblNewLabel.setBounds(61, 91, 60, 14);
		Televisor.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Color");
		lblNewLabel_1.setBounds(61, 116, 46, 14);
		Televisor.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consumo Energetico");
		lblNewLabel_2.setBounds(61, 141, 103, 14);
		Televisor.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(61, 166, 46, 14);
		Televisor.getContentPane().add(lblNewLabel_3);
		textprecio = new JTextField();
		textprecio.setText("100");
		textprecio.setBounds(200, 88, 86, 20);
		Televisor.getContentPane().add(textprecio);
		textprecio.setColumns(10);
		
		txtcolor = new JTextField();
		txtcolor.setText("blanco");
		txtcolor.setBounds(200, 113, 86, 20);
		Televisor.getContentPane().add(txtcolor);
		txtcolor.setColumns(10);
		
		txtconsumo = new JTextField();
		txtconsumo.setText("F");
		txtconsumo.setBounds(200, 138, 86, 20);
		Televisor.getContentPane().add(txtconsumo);
		txtconsumo.setColumns(10);
		
		textpeso = new JTextField();
		textpeso.setText("5");
		textpeso.setBounds(200, 163, 86, 20);
		Televisor.getContentPane().add(textpeso);
		textpeso.setColumns(10);
		
		JLabel lblResolucion = new JLabel("Resolucion");
		lblResolucion.setBounds(61, 191, 103, 14);
		Televisor.getContentPane().add(lblResolucion);
		
		textResolucion = new JTextField();
		textResolucion.setText("20");
		textResolucion.setBounds(200, 188, 86, 20);
		Televisor.getContentPane().add(textResolucion);
		textResolucion.setColumns(10);
		
		JLabel lblSintonizador = new JLabel("Sintonizador");
		lblSintonizador.setBounds(61, 216, 103, 14);
		Televisor.getContentPane().add(lblSintonizador);
		
		textSintonizador = new JTextField();
		textSintonizador.setText("false");
		textSintonizador.setBounds(200, 213, 86, 20);
		Televisor.getContentPane().add(textSintonizador);
		textSintonizador.setColumns(10);
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Television t=new Television(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
						ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),
						Integer.parseInt(textResolucion.getText()),Boolean.parseBoolean(textSintonizador.getText()));
				ce.altaElectrodomestico(t);
				Menu_Principal.setVisible(true);
				Televisor.setVisible(false);
			}
		});
		btnNewButton.setBounds(319, 215, 89, 23);
		Televisor.getContentPane().add(btnNewButton);
		Televisor.setVisible(true);
		}


	private void Listado() {
		Listado = new JFrame();
		Listado.setBounds(100, 100, 779, 467);
		Listado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Listado.getContentPane().setLayout(null);
		
		cboElectrodomesticos = new JComboBox();
		cboElectrodomesticos.setBounds(518, 11, 243, 22);
		
		lblEtiqueta = new JLabel("");
		lblEtiqueta.setBounds(518, 77, 0, 0);
		
		JButton btnListarBoletos = new JButton("ListarElectrodomesticos");
		btnListarBoletos.setBounds(614, 54, 147, 23);
		btnListarBoletos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadTable();
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 751, 341);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Listado.getContentPane().setLayout(null);
		Listado.getContentPane().add(cboElectrodomesticos);
		Listado.getContentPane().add(lblEtiqueta);
		Listado.getContentPane().add(btnListarBoletos);
		Listado.getContentPane().add(scrollPane);
		
		mntmMenuPrincipal_1 = new JMenuItem("Menu Principal");
		mntmMenuPrincipal_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu_Principal.setVisible(true);
				Listado.setVisible(false);
			}
		});
		mntmMenuPrincipal_1.setBounds(0, 0, 107, 19);
		Listado.getContentPane().add(mntmMenuPrincipal_1);
		Listado.setVisible(true);
}
private void LoadTable()
{
	xTableModelElectrodomesticos modelo=new xTableModelElectrodomesticos();
	modelo.setDataSource( ce.getElectrodomesticos());
	table.setModel(modelo);
}
}
