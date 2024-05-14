package controlador.viaje;

import java.io.IOException;
import java.util.ArrayList;
import modelo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/IndexViaje")
public class IndexViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Camion> camiones = new ModeloCamion().getTodos();
		ArrayList<Camionero> camioneros = new ModeloCamionero().getTodos();
		ArrayList<Viaje> viajes = new ModeloViaje().getTodos();
		
		request.setAttribute("direccion", "IndexViaje");
		request.setAttribute("msg", request.getParameter("msg"));
		request.setAttribute("asig", request.getParameter("asig"));
		request.setAttribute("viajes", viajes);
		request.setAttribute("camiones", camiones);
		request.setAttribute("camioneros", camioneros);
		
		request.getRequestDispatcher("indexViaje.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
