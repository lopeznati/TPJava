package negocio;

import java.util.ArrayList;


import datos.*;
import entidades.*;

public class ControladorAltaElectrodomestico {

	private CatalogoElectrodomesticos ce = new CatalogoElectrodomesticos();
	private CatalogoColores cc = new CatalogoColores();
	private CatalogoConsumos cco = new CatalogoConsumos();
	public Color comprobarColor(String color)
	{
		return cc.ComprobarColor(color);
	}
	public Consumo comprobarConsumoEnergetico(String letra)
	{
		return cco.ComprobarConsumo(letra);
	}
	public void altaElectrodomestico(Electrodomestico e)
	{
		ce.nuevoElectrodomestico(e);
		
	}
	private CatalogoElectrodomesticos getCatalogoElectrodomesticos()
	{
		return ce;
		
	}
	public ArrayList<Electrodomestico> getElectrodomesticos()
	{
		return getCatalogoElectrodomesticos().getElectrodomesticos();
	}
	public void removerElectrodomestico(int id)
	{
		int i = 0;
		while(i<getElectrodomesticos().size())
		{
			ArrayList<Electrodomestico> e = getElectrodomesticos();
			if(e.get(i).getIndice()==id)
				e.remove(e.get(i));
			i++;
		}
		ce.remover(id);
			
	}
	public Electrodomestico getElectrodomestico(int id)
	{
		for(Electrodomestico e : getElectrodomesticos())
		{
			if(e.getIndice() == id)
				return e;
		}
		return null;
	}
}
