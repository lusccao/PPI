package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class ManterUsuarioController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pSobrenome = request.getParameter("sobrenome");
		String pUsername = request.getParameter("username");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pSexo = request.getParameter("sexo");
		String pCep = request.getParameter("cep");
		String pCidade = request.getParameter("cidade");
		String pEstado = request.getParameter("estado");
		
		Usuario usuario = new Usuario();
		usuario.setNome(pNome);
		usuario.setSobrenome(pSobrenome);
		usuario.setUsername(pUsername);
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);
		usuario.setSexo(pSexo);
		usuario.setCep(pCep);
		usuario.setCidade(pCidade);
		usuario.setEstado(pEstado);
		
		UsuarioService us = new UsuarioService();
		us.criar(usuario);
		usuario = us.carregar(usuario.getId());
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher view = 
        request.getRequestDispatcher("Usuario.jsp");
        view.forward(request, response);
	}

}
