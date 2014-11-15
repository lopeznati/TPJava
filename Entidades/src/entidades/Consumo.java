package entidades;

public class Consumo {

	private String letra;
	private int precio,id;
	
	public int getPrecio() {
		return precio;
	}
	public Consumo()
	{
	}
	public void setLetra(String _letra)
	{
		letra = _letra;
	}
	public void setPrecio(int _precio)
	{
		precio = _precio;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int _id)
	{
		id = _id;
	}
	public String getLetra()
	{
		return letra;
	}
}
