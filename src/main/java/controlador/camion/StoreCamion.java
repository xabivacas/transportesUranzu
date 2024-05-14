package controlador.camion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Camion;
import modelo.ModeloCamion;

/**
 * Servlet implementation class StoreCamion
 */
@WebServlet("/StoreCamion")
public class StoreCamion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCamion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Camion c = new Camion();
		
		c.setMatricula(request.getParameter("matricula"));
		c.setMarca(request.getParameter("marca"));
		c.setModelo(request.getParameter("modelo"));
		
		if(c.getMatricula().isBlank()||c.getMatricula() == null) {
			response.sendRedirect("IndexCamion?msg=matriculaRequerida");
		}else {
			if(new ModeloCamion().insertCamion(c)) {
				response.sendRedirect("IndexCamion?msg=stored");
			}else {
				response.sendRedirect("IndexCamion?msg=noStored");
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
