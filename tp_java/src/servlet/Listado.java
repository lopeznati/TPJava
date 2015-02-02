package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listadoElec.ListadoElec;
import negocio.ControladorAltaElectrodomestico;
import entidades.Electrodomestico;

/**
 * Servlet implementation class Listado
 */
@WebServlet("/lista")
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listado() {
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
		String minimo=request.getParameter("minimo");
		String maximo=request.getParameter("maximo");
		String letra=request.getParameter("opt");
		ListadoElec lista=new ListadoElec(minimo,maximo,letra);
		request.setAttribute("elect", lista.getDataSource());
		getServletContext().getRequestDispatcher("/listadojsp.jsp").forward(request, response);
		}

}
