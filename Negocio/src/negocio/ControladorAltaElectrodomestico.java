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
		color = color.toLowerCase();
		for (int i = 0; i < cc.getColores().size(); i++) {
			if(cc.getColores().get(i).getNombreColor().equals(color)) 
				return cc.getColores().get(i);
		}
		return cc.getColores().get(0);
	}
	public Consumo comprobarConsumoEnergetico(String letra)
	{
		letra=letra.toUpperCase();
		for (int i = 0; i < cco.getConsumos().size(); i++) {
			if(cco.getConsumos().get(i).getLetra().equals(letra) )
			{
				return cco.getConsumos().get(i);
			}
		}
		return cco.getConsumos().get(5);
	}
	public void altaElectrodomestico(Electrodomestico e)
	{
		e.setIndice(ce.getElectrodomesticos().size());
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
}
