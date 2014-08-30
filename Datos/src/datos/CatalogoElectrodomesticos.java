package datos;
import java.util.ArrayList;
import entidades.Electrodomestico;

public class CatalogoElectrodomesticos {

	private ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
	
	public void nuevoElectrodomestico(Electrodomestico e)
	{
		electrodomesticos.add(e);
		
	}
	public ArrayList<Electrodomestico> getElectrodomesticos()
	{
		return electrodomesticos;
	}
}
