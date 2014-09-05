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
		Color colores[] = cc.getColores();
		for (int i = 0; i < colores.length; i++) {
			if(colores[i].getNombreColor().equals(color)) 
				return colores[i];
		}
		return colores[0];
	}
	public Consumo comprobarConsumoEnergetico(String letra)
	{
		letra=letra.toUpperCase();
		Consumo consumos[] = cco.getConsumos();
		for (int i = 0; i < consumos.length; i++) {
			if(consumos[i].getLetra().equals(letra) )
			{
				return consumos[i];
			}
		}
		return consumos[5];
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
