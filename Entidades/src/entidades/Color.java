package entidades;

public class Color {
	
	String nombreColor;
	int id;
	public void setId(int _id)
	{
		id=_id;
	}
	public int getId()
	{
		return id;
	}
	public Color()
	{
	}
	
	public Color(String nombre){
		this.setNombreColor(nombre);
		
	}
	public void setNombreColor( String _nombreColor)
	{
		nombreColor = _nombreColor;
	}
	public String getNombreColor() {
		return nombreColor;
	}

	
}
