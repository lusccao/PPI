package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command{
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
        String pArea = request.getParameter("area");
		int id = -1;
		Long populacao = null;
		Double area = null;
		try {
			id = Integer.parseInt(pId);
			populacao = Long.parseLong(pPopulacao);
	        area = Double.parseDouble(pArea);
		} catch (NumberFormatException e) {

		}

		Pais pais = new Pais();
		pais.setId(id);
		pais.setNome(pNome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		PaisService ps = new PaisService();
		RequestDispatcher view = null;

		pais = ps.carregar(pais.getId());
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");

		view.forward(request, response);

	}
}
