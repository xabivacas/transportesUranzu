package controlador.camionero;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Camionero;
import modelo.ModeloCamionero;


/**
 * Servlet implementation class Store
 */
@WebServlet("/StoreCamionero")
public class StoreCamionero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCamionero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Camionero c = new Camionero();
		c.setDni(request.getParameter("dni"));
		c.setNombre(request.getParameter("nombre"));
		c.setApellido(request.getParameter("apellido"));
		
		if(c.getDni().isBlank()) {
			response.sendRedirect("IndexCamionero?msg=sinDNI");
		}else {
			ModeloCamionero mc = new ModeloCamionero();
			if(mc.insert(c)) {
				response.sendRedirect("IndexCamionero?msg=stored");
			}else {
				response.sendRedirect("IndexCamionero?msg=noStored");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
