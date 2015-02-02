package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;
import negocio.ControladorAltaElectrodomestico;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControladorAltaElectrodomestico ce= new ControladorAltaElectrodomestico();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("cod"));
		Electrodomestico e = ce.getElectrodomestico(id);
		
		if(e.getClass()==Lavarropas.class)
		{
		request.setAttribute("elect", e);
		ce.removerElectrodomestico(id);
		getServletContext().getRequestDispatcher("/Alta-Lavarropas.jsp").forward(request, response);}
		else{ if(e.getClass()==Television.class) {	
		request.setAttribute("elect", e);
		ce.removerElectrodomestico(id);
		getServletContext().getRequestDispatcher("/Alta-Televisor.jsp").forward(request, response);}}
		
	}

}
