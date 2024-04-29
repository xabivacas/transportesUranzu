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
		c.setId(Integer.parseInt(request.getParameter("idMod")));
		c.setPeso(Double.parseDouble(request.getParameter("pesoMod")));
		c.setDimensiones(request.getParameter("dimensionesMod"));
		c.setViaje(new ModeloViaje().getUno(Integer.parseInt(request.getParameter("viajeMod"))));
		c.setTipo(request.getParameter("tipoMod"));
		
		ModeloCarga mc = new ModeloCarga();
		mc.insert(c);

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
