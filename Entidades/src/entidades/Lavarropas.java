package entidades;

public class Lavarropas extends Electrodomestico {

static final int cargaPorDefecto=5;
private double carga;

public double getCarga(){
	return carga;
}

public void setCarga(double carga){
	this.carga=carga;
}

public Lavarropas()
{
	carga = cargaPorDefecto;
}

public Lavarropas (double _precio , int _peso)
{	
	super(_precio,_peso);
}

public Lavarropas (double _carga)
{
	carga = _carga;
	
}

public Lavarropas(double preciob, int _peso, Color _color, Consumo consumo, double _carga){
	super(preciob, _peso, _color, consumo);
	setCarga(_carga);
	setDesc("Lavarropas");
	precioFinal();
}

public void precioFinal()
{
	super.precioFinal();
	if(carga>30)
		super.aumentarPrecio(50);
}
}
