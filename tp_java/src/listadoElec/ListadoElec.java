package listadoElec;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import negocio.ControladorAltaElectrodomestico;
import entidades.Electrodomestico;

public  class ListadoElec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Electrodomestico> dataSource;
	public ListadoElec(){
		
	}
	public ListadoElec(String minimo, String maximo, String letra)	
	{
		ArrayList<Electrodomestico> array = new ArrayList<Electrodomestico>();
		ControladorAltaElectrodomestico ce = new ControladorAltaElectrodomestico();
		for (int i = 0; i < ce.getElectrodomesticos().size(); i++) {
			if(!letra.equals(" ")){
				if(!(minimo.isEmpty())&&!(maximo.isEmpty())){
					if(ce.getElectrodomesticos().get(i).getConsumo().getLetra().equals(letra)){
						if(ce.getElectrodomesticos().get(i).getPreciobase()<=Double.parseDouble(maximo)&& ce.getElectrodomesticos().get(i).getPreciobase()>=Double.parseDouble(minimo))
						{
							array.add(ce.getElectrodomesticos().get(i));
						}
					}
				}
				else
					if(ce.getElectrodomesticos().get(i).getConsumo().getLetra().equals(letra)){
						array.add(ce.getElectrodomesticos().get(i));
					}
					
				
			}
			else{
				if(!(minimo.isEmpty())&&!(maximo.isEmpty())){
					if(ce.getElectrodomesticos().get(i).getPreciobase()<=Double.parseDouble(maximo)&& ce.getElectrodomesticos().get(i).getPreciobase()>=Double.parseDouble(minimo))
					{
						array.add(ce.getElectrodomesticos().get(i));
					}
				}
				
				
			}
		}
		this.setDataSource(array);
		if((minimo.isEmpty())&&(maximo.isEmpty()) && (letra.equals(" "))){
			this.setDataSource(ce.getElectrodomesticos());
		}	
		
	}
	public ArrayList<Electrodomestico> getDataSource() {
		return dataSource;
	}
	public void setDataSource(ArrayList<Electrodomestico> dataSource) {
		this.dataSource = dataSource;
	}


}
