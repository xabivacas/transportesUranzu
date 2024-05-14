package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 * Servlet implementation class AsignarViaje
 */
@WebServlet("/AsignarViaje")
public class AsignarViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignarViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Viaje v = new ModeloViaje().getUno(Integer.parseInt(request.getParameter("viaje")));
		Camionero camionero = new ModeloCamionero().getUno(request.getParameter("camionero"));
		Camion camion = new ModeloCamion().getUno(request.getParameter("camion"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD");
		Date fecha = new Date();
		if(new ModeloViaje().asignarViaje(v, camion, camionero)) {
		response.sendRedirect(request.getParameter("direccion")+"?asig=asignado");
		}else {
		response.sendRedirect(request.getParameter("direccion")+"?asig=noAsignado");
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
