package controlador.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.ModeloCliente;


/**
 * Servlet implementation class Store
 */
@WebServlet("/StoreCliente")
public class StoreCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cl = new Cliente();
		cl.setCif(request.getParameter("cif"));
		cl.setNombre(request.getParameter("nombre"));
		cl.setDireccion(request.getParameter("direccion"));
		
		if(cl.getCif().isBlank()) {
			response.sendRedirect("IndexCliente?msg=sinCif");
		}else {
			ModeloCliente mc = new ModeloCliente();
			if(mc.insert(cl)) {
				response.sendRedirect("IndexCliente?msg=stored");
			}else {
				response.sendRedirect("IndexCliente?msg=noStored");
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