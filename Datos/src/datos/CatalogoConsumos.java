package datos;

import entidades.Consumo;

public class CatalogoConsumos {

	private Consumo consumos[] = new Consumo[6];

	public CatalogoConsumos()
	{
		for (int i = 0; i < consumos.length; i++) {
			consumos[i] = new Consumo();
		}
		consumos[0].setLetra("A");
		consumos[0].setPrecio(100);
		consumos[1].setLetra("B");
		consumos[1].setPrecio(80);
		consumos[2].setLetra("C");
		consumos[2].setPrecio(60);
		consumos[3].setLetra("D");
		consumos[3].setPrecio(50);
		consumos[4].setLetra("E");
		consumos[4].setPrecio(30);
		consumos[5].setLetra("F");
		consumos[5].setPrecio(10);
	}
	
	public Consumo[]  getConsumos()
	{
		return consumos;
		
	}
}