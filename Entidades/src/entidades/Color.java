package entidades;

public class Color {
	
	String nombreColor;
	public Color()
	{
		nombreColor = "blanco";
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
