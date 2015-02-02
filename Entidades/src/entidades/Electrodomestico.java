
package entidades;

import java.io.Serializable;

public abstract class Electrodomestico {
	/**
	 * 
	 */

	private double preciobase;
	private int peso;
	private Color color;
	private Consumo consumo;
	private int id;
	private String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setIndice(int i)
	{
		id= i;
	}
	public Color getColor()
	{
		return color;
	}
	public double getPreciobase() {
		return preciobase;
	}
	
	

	
	public double getPeso() {
		return peso;
	}
	public int getpeso(){
		return peso;
	}

	public void setConsumo(Consumo _consumo)
	{
		consumo = _consumo;
	}
	public Electrodomestico(){	
		consumo = new Consumo();
		color = new Color();
		preciobase=100;
		peso=5;
	}
	
	public Electrodomestico(double preciob, int _peso){
		preciobase=preciob;
		peso=_peso;
	}
	public void setColor(Color _color)
	{
		color=_color;
	}
	public Electrodomestico(double preciob, int _peso, Color _color, Consumo consumo){
		preciobase=preciob;
		peso=_peso;
		setColor(_color);
		setConsumo(consumo);
	}
	public void precioFinal()
	{
		if(consumo.getLetra()=="A")
			preciobase+=100;
		if(consumo.getLetra()=="B")
			preciobase+=80;
		if(consumo.getLetra()=="C")
			preciobase+=60;
		if(consumo.getLetra()=="D")
			preciobase+=50;
		if(consumo.getLetra()=="E")
			preciobase+=30;
		if(consumo.getLetra()=="F")
			preciobase+=10;
		

		 if(peso>=0 && peso<=19)
			preciobase+=10;
		 if(peso>=20 && peso<=49)
				preciobase+=50;
		 if(peso>=50 && peso<=79)
				preciobase+=80;
		 if(peso>=80)
				preciobase+=100;
		
	}
	public void aumentarPrecio(double aumento)
	{
		preciobase+=aumento;
	}
	public Consumo getConsumo()
	{
		return consumo;
	}
	public int getIndice()
	{
		return id;
	}
}
