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

import modelo.Viaje;
import modelo.ModeloViaje;

/**
 * Servlet implementation class UpdateCamionero
 */
@WebServlet("/UpdateViaje")
public class UpdateViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateViaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ModeloViaje vm = new ModeloViaje();
	Viaje v = new Viaje();
	
	v.setId(Integer.parseInt(request.getParameter("idMod")));

	v.setOrigen(request.getParameter("origenMod"));
	v.setDestino(request.getParameter("destinoMod"));


	
	if(vm.update(v)) {
		response.sendRedirect("IndexViaje?msg=modificado");
	}else {
		response.sendRedirect("IndexViaje?msg=noModificado");
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
