package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import negocio.ControladorAltaElectrodomestico;
import entidades.Color;
import entidades.Electrodomestico;
import entidades.Lavarropas;

/**
 * Servlet implementation class AltaLavarropas
 */
@WebServlet("/AltaLavarropas")
public class AltaLavarropas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ControladorAltaElectrodomestico ce=new ControladorAltaElectrodomestico();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaLavarropas() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double preciobase=Double.parseDouble(request.getParameter("preciobase"));
		int peso=Integer.parseInt(request.getParameter("peso"));
		
		double carga=Double.parseDouble(request.getParameter("carga"));
		
		String color=request.getParameter("color");
		String consumo=request.getParameter("consumo");	
        
		Lavarropas l=new Lavarropas(preciobase, peso,ce.comprobarColor(color) , ce.comprobarConsumoEnergetico(consumo), carga);
		ce.altaElectrodomestico(l);
		response.sendRedirect("alta.html");
		
	}

}
