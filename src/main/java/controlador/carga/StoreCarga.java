package controlador.carga;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carga;
import modelo.ModeloCarga;
import modelo.ModeloViaje;


/**
 * Servlet implementation class Store
 */
@WebServlet("/StoreCarga")
public class StoreCarga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCarga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Carga c = new Carga();
		c.setPeso(Double.parseDouble(request.getParameter("peso")));
		c.setDimensiones(request.getParameter("dimensiones"));
		c.setViaje(new ModeloViaje().getUno(Integer.parseInt(request.getParameter("viaje"))));
		c.setTipo(request.getParameter("tipo"));
		
		ModeloCarga mc = new ModeloCarga();
		if(mc.insert(c)) {
			response.sendRedirect("IndexCarga?msg=stored");
		}else {
			response.sendRedirect("IndexCarga?msg=noStored");
		}

		response.sendRedirect("IndexCarga");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
