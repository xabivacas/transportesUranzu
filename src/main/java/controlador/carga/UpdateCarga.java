package controlador.carga;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;


/**
 * Servlet implementation class UpdateCamionero
 */
@WebServlet("/UpdateCarga")
public class UpdateCarga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ModeloCarga cm = new ModeloCarga();
	Carga c = new Carga();
	
	c.setId(Integer.parseInt(request.getParameter("idMod")));
	c.setPeso(Double.parseDouble(request.getParameter("pesoMod")));
	c.setDimensiones(request.getParameter("dimensionesMod"));
	c.setTipo(request.getParameter("tipoMod"));
	if(new ModeloCarga().update(c)) {
		response.sendRedirect("IndexCarga?msg=modificado");
	}else {
		response.sendRedirect("IndexCarga?msg=noModificado");
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
