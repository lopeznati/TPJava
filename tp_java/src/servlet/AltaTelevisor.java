package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Television;
import negocio.ControladorAltaElectrodomestico;

/**
 * Servlet implementation class AltaTelevisor
 */
@WebServlet("/AltaTelevisor")
public class AltaTelevisor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ControladorAltaElectrodomestico ce=new ControladorAltaElectrodomestico();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTelevisor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double preciobase=Double.parseDouble(request.getParameter("preciobase"));
		int peso=Integer.parseInt(request.getParameter("peso"));
		int resolucion=Integer.parseInt(request.getParameter("resolucion"));
		String color=request.getParameter("color");
		String consumo=request.getParameter("consumo");
		boolean sintonizador;
		if(request.getParameter("opt")==null)
		{
			sintonizador=false;
		}else {sintonizador=true;}
		Television t= new Television(preciobase, peso, ce.comprobarColor(color), ce.comprobarConsumoEnergetico(consumo), resolucion, sintonizador);
		ce.altaElectrodomestico(t);
		response.sendRedirect("alta.html");
	}

}
