package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Lavarropas;
import entidades.Television;

public class xTableModelElectrodomesticos extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<entidades.Electrodomestico> dataSource;
	
	public ArrayList<entidades.Electrodomestico> getDataSource() {
		return dataSource;
	}

	public void setDataSource(ArrayList<entidades.Electrodomestico> dataSource) {
		this.dataSource = dataSource;
	}

	public int getRowCount() {
		return dataSource.size();
	}

	public int getColumnCount() {
		return 9;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		entidades.Electrodomestico b= dataSource.get(rowIndex);
		Object o = new Object();
		switch (columnIndex) {
		case 0:
			o = b.getIndice();
			break;
		case 1:
			o = b.getDesc();
			break;
		case 2:
			o=b.getColor().getNombreColor();
			break;
		case 3:
			o=b.getPeso();
			break;
		case 4:
			o=b.getConsumo().getLetra();
			break;
		case 5:
			o=b.getPreciobase();
			break;
		case 6:
			if(Lavarropas.class.isInstance(b))
				o = Lavarropas.class.cast(b).getCarga();
			else
				o="-";
			break;
		case 7:
			if(Television.class.isInstance(b))
				 o = Television.class.cast(b).getResolucion();
			else
				o="-";
			break;	
		case 8:
			if(Television.class.isInstance(b))
				o = Television.class.cast(b).isSintonizador();
			else
				o="-";
			break;
		default:
			o= "";
			break;
		}
		return o;
	}
	
	public String getColumnName( int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="ID";
			break;
		case 1:
			nom="Descripcion";
			break;
		case 2:
			nom="Color";
			break;
		case 3:
			nom="Peso";
			break;
		case 4:
			nom="Consumo";
			break;
		case 5:
			nom="Costo";
			break;
		case 6:
			nom="Carga";
			break;
		case 7:
			nom="Resolucion";
			break;
		case 8:
			nom="Sintonizador TDT";
		default:
			break;
		}
		return nom;
		
	}
}
