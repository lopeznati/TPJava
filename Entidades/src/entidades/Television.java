package entidades;

public class Television extends Electrodomestico {

	private int resolucion;
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	public void setSintonizador(boolean sintonizador) {
		this.sintonizador = sintonizador;
	}
	private boolean sintonizador;
	public int getResolucion() {
		return resolucion;
	}
	public boolean isSintonizador() {
		return sintonizador;
	}
	
	
	
	public Television(){
		resolucion=20;
		sintonizador=false;
	}
	public Television(double _precio,int _peso){
		super(_precio,_peso);
	}
	public Television(int _resolucion, boolean _sintonizador){
		resolucion=_resolucion;
		sintonizador=_sintonizador;
		
	}
	
	public Television(double preciob, int _peso, Color _color, Consumo consumo,  int _resolucion, boolean _sintonizador){
		super(preciob, _peso, _color, consumo);
		setResolucion(_resolucion);
		setSintonizador(_sintonizador);
		setDesc("Television");
		precioFinal();
	}
	
	public void precioFinal()
	{
		super.precioFinal();
		if(resolucion>40)
			super.aumentarPrecio(getPreciobase()*0.3);
		
		if(sintonizador)
			super.aumentarPrecio(50);
	}
	
}
