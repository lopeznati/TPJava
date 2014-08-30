package gui;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.*;
import entidades.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.Toolkit;

public class Presentacion {


	private JFrame Menu_Principal;
	private JFrame Listado;
	private JFrame Lavarropas;
	private JFrame Televisor;
	private JFrame Alta_Electrodomestico;
	xTableModelElectrodomesticos modelo;
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
	private JTable table;
	private JMenuItem mntmMenuPrincipal;
	private JMenuItem mntmMenuPrincipal_1;
	private JTextField textID;
	private JLabel lblRangoImportes;
	private JTextField textImporteMinimo;
	private JLabel label;
	private JTextField textImporteMax;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentacion window = new Presentacion();
					window.Menu_Principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Presentacion() {
		Menu_Principal();
	}
	private void Alta_Electrodomestico() {
		Alta_Electrodomestico = new JFrame();
		Alta_Electrodomestico.setTitle("Alta Electrodomesticos");
		Alta_Electrodomestico.setIconImage(Toolkit.getDefaultToolkit().getImage(Presentacion.class.getResource("/icono/Icono_de_Super_estrella.png")));
		Alta_Electrodomestico.setBounds(100, 100, 450, 300);
		Alta_Electrodomestico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Alta_Electrodomestico.getContentPane().setLayout(null);
		
		JButton btnLavarropas_1 = new JButton("Lavarropas");
		btnLavarropas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lavarropas(null);
				Alta_Electrodomestico.setVisible(false);
			}
		});
		btnLavarropas_1.setBounds(60, 102, 123, 23);
		Alta_Electrodomestico.getContentPane().add(btnLavarropas_1);
		
		JButton btnTelevision = new JButton("Television");
		btnTelevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Televisor(null);
				Alta_Electrodomestico.setVisible(false);
			}
		});
		btnTelevision.setBounds(290, 102, 123, 23);
		Alta_Electrodomestico.getContentPane().add(btnTelevision);
		Alta_Electrodomestico.setVisible(true);
	}
	private void Menu_Principal() {
		Menu_Principal = new JFrame();
		Menu_Principal.setTitle("Menu");
		Menu_Principal.setIconImage(Toolkit.getDefaultToolkit().getImage(Presentacion.class.getResource("/icono/Icono_de_Super_estrella.png")));
		Menu_Principal.setBounds(100, 100, 450, 300);
		Menu_Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu_Principal.getContentPane().setLayout(null);
		
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
		btnAlta.setBounds(164, 81, 89, 23);
		Menu_Principal.getContentPane().add(btnAlta);
	}
	private void Lavarropas(final Lavarropas lav) {

		Lavarropas = new JFrame();
		Lavarropas.setTitle("Lavarropas");
		Lavarropas.setIconImage(Toolkit.getDefaultToolkit().getImage(Presentacion.class.getResource("/icono/Icono_de_Super_estrella.png")));
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
				if(lav==null){
					Lavarropas l=new Lavarropas(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
							ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),Double.parseDouble(textcarga.getText()));
					ce.altaElectrodomestico(l);
					}
					else
					{
						Lavarropas l =new Lavarropas(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
								ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),Double.parseDouble(textcarga.getText()));
						l.setIndice(lav.getIndice());
						ce.getElectrodomesticos().set(lav.getIndice(), l);

						Listado.setVisible(false);
						Listado();
						LoadTable(ce.getElectrodomesticos());
					}
				if(lav==null){
				Menu_Principal.setVisible(true);}
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
		mntmMenuPrincipal.setBounds(0, 0, 135, 19);
		Lavarropas.getContentPane().add(mntmMenuPrincipal);
		Lavarropas.setVisible(true);
		}
	private void Televisor(final Television tel) {
		Televisor = new JFrame();
		Televisor.setTitle("Television");
		Televisor.setIconImage(Toolkit.getDefaultToolkit().getImage(Presentacion.class.getResource("/icono/Icono_de_Super_estrella.png")));
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
				if(tel==null){
				Television t=new Television(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
						ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),
						Integer.parseInt(textResolucion.getText()),Boolean.parseBoolean(textSintonizador.getText()));
				ce.altaElectrodomestico(t);}
				else if(tel!=null){
					Television t = new Television(Double.parseDouble(textprecio.getText()) , Integer.parseInt(textpeso.getText()) , 
							ce.comprobarColor(txtcolor.getText()), ce.comprobarConsumoEnergetico(txtconsumo.getText()),
							Integer.parseInt(textResolucion.getText()),Boolean.parseBoolean(textSintonizador.getText()));
					t.setIndice(tel.getIndice());
					ce.getElectrodomesticos().set(tel.getIndice(), t);
					Listado.setVisible(false);
					Listado();
					LoadTable(ce.getElectrodomesticos());
					
				}
				if(tel==null){	
				Menu_Principal.setVisible(true);}
				Televisor.setVisible(false);
			}
		});
		btnNewButton.setBounds(319, 215, 89, 23);
		Televisor.getContentPane().add(btnNewButton);
		Televisor.setVisible(true);
		}


	private void Listado() {
		Listado = new JFrame();
		Listado.setTitle("Listado");
		Listado.setIconImage(Toolkit.getDefaultToolkit().getImage(Presentacion.class.getResource("/icono/Icono_de_Super_estrella.png")));
		Listado.setBounds(100, 100, 779, 497);
		Listado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Listado.getContentPane().setLayout(null);
		
		cboElectrodomesticos = new JComboBox();
		cboElectrodomesticos.setBounds(518, 11, 243, 22);
		lblRangoImportes = new JLabel("Rango Importes:");
		lblRangoImportes.setBounds(80, 15, 99, 18);
		Listado.getContentPane().add(lblRangoImportes);
		
		textImporteMinimo = new JTextField();
		textImporteMinimo.setBounds(189, 14, 86, 20);
		Listado.getContentPane().add(textImporteMinimo);
		textImporteMinimo.setColumns(10);
		
		label = new JLabel("-");
		label.setBounds(285, 15, 10, 14);
		Listado.getContentPane().add(label);
		
		textImporteMax = new JTextField();
		textImporteMax.setBounds(295, 13, 86, 20);
		Listado.getContentPane().add(textImporteMax);
		textImporteMax.setColumns(10);
		lblEtiqueta = new JLabel("");
		lblEtiqueta.setBounds(518, 77, 0, 0);
		JButton btnListar = new JButton("Listar Electrodomesticos");
		btnListar.setBounds(528, 54, 185, 23);
		btnListar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<Electrodomestico> array = new ArrayList<Electrodomestico>();
				if(textImporteMax.getText().length()!=0&&textImporteMax.getText().length()!=0){
				   for (int i = 0; i < ce.getElectrodomesticos().size(); i++) {
						if(ce.getElectrodomesticos().get(i).getPreciobase()<=Double.parseDouble(textImporteMax.getText())&&
							ce.getElectrodomesticos().get(i).getPreciobase()>=Double.parseDouble(textImporteMinimo.getText()))
						{
						 array.add(ce.getElectrodomesticos().get(i));
						}
					}
					LoadTable(array);
					}
				else
					LoadTable(ce.getElectrodomesticos());
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 751, 302);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Listado.getContentPane().setLayout(null);
		Listado.getContentPane().add(cboElectrodomesticos);
		Listado.getContentPane().add(lblEtiqueta);
		Listado.getContentPane().add(btnListar);
		Listado.getContentPane().add(scrollPane);
		
		mntmMenuPrincipal_1 = new JMenuItem("Menu Principal");
		mntmMenuPrincipal_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu_Principal.setVisible(true);
				Listado.setVisible(false);
			}
		});
		mntmMenuPrincipal_1.setBounds(0, 0, 163, 19);
		Listado.getContentPane().add(mntmMenuPrincipal_1);
		
		JLabel lblIdElectrodomestico = new JLabel("ID Electrodomestico:");
		lblIdElectrodomestico.setBounds(37, 415, 126, 14);
		Listado.getContentPane().add(lblIdElectrodomestico);
		
		textID = new JTextField();
		textID.setBounds(156, 412, 86, 20);
		Listado.getContentPane().add(textID);
		textID.setColumns(10);
		
		JButton btnModifica = new JButton("Modificar");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ce.getElectrodomesticos().get(Integer.parseInt(textID.getText())).getClass() == Television.class){
					Televisor((Television) ce.getElectrodomesticos().get(Integer.parseInt(textID.getText())));}
				else{
					Lavarropas((Lavarropas)ce.getElectrodomesticos().get(Integer.parseInt(textID.getText())));}
			}
		});
		btnModifica.setBounds(280, 411, 91, 23);
		Listado.getContentPane().add(btnModifica);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ce.getElectrodomesticos().remove(ce.getElectrodomesticos().get(Integer.parseInt(textID.getText())));
				Listado.setVisible(false);
				Listado();
				LoadTable(ce.getElectrodomesticos());
			}
		});
		btnEliminar.setBounds(381, 411, 91, 23);
		Listado.getContentPane().add(btnEliminar);
		Listado.setVisible(true);
}
private void LoadTable(ArrayList<Electrodomestico> e)
{
	modelo=new xTableModelElectrodomesticos();
	modelo.setDataSource(e);
	table.setModel(modelo);
}
}
