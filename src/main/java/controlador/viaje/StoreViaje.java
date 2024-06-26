package controlador.viaje;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Camionero;
import modelo.ModeloViaje;
import modelo.Viaje;


/**
 * Servlet implementation class Store
 */
@WebServlet("/StoreViaje")
public class StoreViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Viaje v = new Viaje();
		v.setOrigen(request.getParameter("origen"));
		v.setDestino(request.getParameter("destino"));
		
		if(v.getOrigen().isBlank()||v.getDestino().isBlank()) {
			response.sendRedirect("IndexViaje?msg=sinDatos");
		}else {
			if(v.getOrigen().equalsIgnoreCase(v.getDestino())) {
				response.sendRedirect("IndexViaje?msg=repes");
			}else {
				ModeloViaje mv = new ModeloViaje();
				if(mv.insert(v)) {
					response.sendRedirect("IndexViaje?msg=stored");
				}else {
					response.sendRedirect("IndexViaje?msg=noStored");
				}
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
