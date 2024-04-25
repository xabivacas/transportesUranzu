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
 * Servlet implementation class UpdateCamionero
 */
@WebServlet("/UpdateCamionero")
public class UpdateCamionero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCamionero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ModeloCamionero cm = new ModeloCamionero();
	Camionero c = new Camionero();
	c.setDni(request.getParameter("dniMod"));
	c.setNombre(request.getParameter("nombreMod"));
	c.setApellido(request.getParameter("apellidoMod"));
	
	cm.update(c);
	response.sendRedirect("IndexCamionero");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
