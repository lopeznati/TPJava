package datos;

import entidades.Color;
import entidades.Consumo;

public class CatalogoColores {

	private Color colores[] = new Color[5];
	public CatalogoColores()
	{
		colores[0]=new Color("blanco");
		colores[1]=new Color("negro");
		colores[2]=new Color("rojo");
		colores[3]=new Color("azul");
		colores[4]=new Color("gris");
	}
	public Color[] getColores()
	{
		return colores;
		
	}
}
