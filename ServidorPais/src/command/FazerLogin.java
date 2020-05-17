package command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {
	FileWriter logRequest;

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("passwd");
		logRequest = new FileWriter(new File("/home/lucasarthur/Documentos/logreq"), true);
		request.setCharacterEncoding("UTF-8");

		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		usuario.setPassword(senha);
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			logRequest.append("\n" + Calendar.getInstance().getTime() + "Logou "+usuario);
			logRequest.flush();
		} else {
			logRequest.append("\n" + Calendar.getInstance().getTime() + "Não Logou "+usuario);
			logRequest.flush();
			throw new ServletException("Usuário/Senha inválidos");
		}
		response.sendRedirect("index.jsp");
	}

}
